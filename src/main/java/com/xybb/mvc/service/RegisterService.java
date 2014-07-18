package com.xybb.mvc.service;

import com.xybb.model.AjaxResult;
import com.xybb.model.email.Email2Admin;
import com.xybb.model.user.Session2UserInfo;
import com.xybb.model.user.UserInfo;
import com.xybb.model.user.UserRegister;
import com.xybb.mvc.repository.RegisterRository;
import com.xybb.mvc.repository.UserInfoRository;
import com.xybb.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by lw on 14-6-21.
 * 注册service
 */
@Service
public class RegisterService {

    @Resource
    private RegisterRository registerRository;
    @Resource
    private UserInfoRository userInfoRository;

    /**
     * 用户注册，用户名是否存在验证
     *
     * @param emailName
     * @return
     */
    public AjaxResult isHaveEmailName(String emailName) {
        if (null == userInfoRository.getUserByEmailName(emailName)) {
            return AjaxResult.getAjaxResult(AjaxResult.State.SUCCEED);
        }
        return new AjaxResult("该用户已存在 !", false);
    }

    /**
     * 用户注册，激活邮箱
     *
     * @param emailName
     * @param password
     * @param tag
     * @return
     */
    public AjaxResult activate(String emailName, String password, String tag) {
        String uuid = UUID.randomUUID().toString();
        long registerTime = TimeUtil.getNowTimeToHalfHourToLong();
        try {
            //设置临时用户注册信息
            UserRegister userRegister = new UserRegister();
            userRegister.setEmailName(emailName);
            userRegister.setPassword(password);
            userRegister.setRegisterTime(registerTime);
            userRegister.setUuid(uuid);

            registerRository.save(userRegister);

            //发送邮件
            Email2Admin email2Admin = Email2Admin.getEmail2Admin();
            email2Admin.addTo(emailName);
            email2Admin.setSubject("校园帮帮用户注册激活"); // 标题
            StringBuffer buffer = new StringBuffer();
            buffer.append("<h3>欢迎注册校园帮帮用户，点击下面链接激活您的账号！</h3>");
            buffer.append("<h4>有效期为半小时,");
            buffer.append("<a href=\"http://localhost").
                    //buffer.append("<a href=\"http://").append(IpUtil.getLocalIp()).
                            append(":8080/xybb/register/activate/handle?emailName=").append(emailName).
                    append("&uuid=").append(uuid).append("&tag=0").append("\">点击激活</a></h4>");
            buffer.append("<hr>");
            email2Admin.setHtmlMsg(buffer.toString());
            email2Admin.send();
        } catch (EmailException e) {
            e.printStackTrace();
            return AjaxResult.getAjaxResult(AjaxResult.State.ERROR);
        }
        return AjaxResult.getAjaxResult(AjaxResult.State.SUCCEED);
    }

    /**
     * 用户激活邮箱链接处理
     * 临时记录信息转存到用户简单信息表
     * 删除注册用户临时记录信息
     *
     * @param emailName
     * @param uuid
     * @return
     */
    public AjaxResult activate_Handle(String emailName, String uuid, String tag) {

        UserRegister userRegister = registerRository.getUserByEmailName(emailName, uuid , 0);

        if (userRegister == null || !StringUtils.equals(uuid, userRegister.getUuid())) {
            return new AjaxResult("链接无效", false);
        }
        if (TimeUtil.getNowTimeToLong() - userRegister.getRegisterTime() > 0) {
            return new AjaxResult("链接无效", false);
        }

        UserInfo userInfo = UserInfo.getUserInfoByUserRegister(userRegister);
        registerRository.delete(userRegister.getId());
        return new AjaxResult("", true, Session2UserInfo.getSession2UserInfo(userInfoRository.save(userInfo)));
    }

    /**
     * 定时任务清理用户注册-密码修改临时信息
     */
    public List<UserRegister> clean_Job() {
        List<UserRegister> userRegisters = registerRository.getUserRegistersByTime(TimeUtil.getNowTimeToLong());
        if (0 == userRegisters.size()) return userRegisters;
        registerRository.delete(userRegisters);
        return userRegisters;
    }
}
