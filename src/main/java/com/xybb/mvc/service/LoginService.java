package com.xybb.mvc.service;

import com.xybb.model.AjaxResult;
import com.xybb.model.user.Session2UserInfo;
import com.xybb.model.user.UserDetailedInfo;
import com.xybb.model.user.UserInfo;
import com.xybb.mvc.repository.UserDetailedInfoRository;
import com.xybb.mvc.repository.UserInfoRository;
import com.xybb.utils.IpUtil;
import com.xybb.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lw on 14-6-21.
 */
@Service
public class LoginService {

    @Resource
    private UserInfoRository userInfoRository;

    @Resource
    private UserDetailedInfoRository userDetailedInfoRository;

    /**
     * 登录验证
     * TODO 权限验证未处理
     *
     * @param emailName
     * @param password
     * @param remember
     * @param cookie
     * @param request
     * @return
     */
    public AjaxResult login_Do(String emailName, String password, String remember, String cookie, HttpServletRequest request) {
        UserInfo userInfo;
        //如果是自动登录
        if (StringUtils.isNotBlank(cookie) && StringUtils.equals(remember, "automatic_login")) {
            userInfo = userInfoRository.getUserByCookie(cookie);
            if (null == userInfo) {
                return new AjaxResult("用户自动登录账户不匹配，请重新登录!", false, "cookie_failure");
            }
        } else {
            //如果是正常登录
            userInfo = userInfoRository.getUserByEmailName(emailName);
            if (userInfo == null) {
                return new AjaxResult("用户名不存在!", false);
            }
            userInfo = userInfoRository.getUserByEmailNameAndPassword(emailName, password);
            if (userInfo == null) {
                return new AjaxResult("用户名密码错误!", false);
            }
        }


        /**
         * 验证是否是正常状态
         * 0正常，1被账户锁定，2 被ip锁定
         */
        int state = userInfo.getState();
        if (state == 1) {
            return new AjaxResult("该账户被锁定!<br>锁定原因:" + userInfo.getLock_Explain() + "<br>解锁日期:" + TimeUtil.getTimeLong(userInfo.getLock_Time()), false);
        } else if (state == 2) {
            String ip = IpUtil.getIpAddr(request);
            if (userInfo.getLock_IP().contains(ip)) {
                return new AjaxResult("该账户IP被锁定!<br>锁定原因:" + userInfo.getLock_Explain() + "<br>解锁日期:" + TimeUtil.getTimeLong(userInfo.getLock_Time()), false);
            }
        }

        //如果设置了自动登录,记录cookie
        if (StringUtils.equals(remember, "1")) {
            userInfo.setCookie(cookie);
            userInfo = userInfoRository.save(userInfo);
        }
        request.getSession().setAttribute("session2UserInfo", Session2UserInfo.getSession2UserInfo(userInfo));
        return AjaxResult.getAjaxResult(AjaxResult.State.SUCCEED);
    }

    /**
     * 注销事件
     *
     * @param request
     * @return
     */
    public void login_Out(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("session2UserInfo");

        if (null != o) {
            String id = ((Session2UserInfo) o).getUserInfo_Id();
            userInfoRository.del_CookieById(id);
            session.removeAttribute("session2UserInfo");
        }
    }


}
