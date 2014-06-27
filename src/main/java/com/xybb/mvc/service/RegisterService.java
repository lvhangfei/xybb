package com.xybb.mvc.service;

import com.xybb.model.AjaxResult;
import com.xybb.model.email.Email;
import com.xybb.model.email.Email2Admin;
import com.xybb.model.user.Session2UserInfo;
import com.xybb.utils.IpUtil;
import com.xybb.utils.TimeUtil;
import org.apache.commons.mail.EmailException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by lw on 14-6-21.
 * 注册service
 */
@Service
public class RegisterService {

    /*@Resource
    private UserInfoRository userInfoRository;*/
    @Resource
    private Email2Admin email2Admin;

    public boolean activate(String emailName, String password) {
        String uuid = UUID.randomUUID().toString();
        long time = TimeUtil.getNowTimeToHalfHour();
        try {
            email2Admin.addTo(emailName);
            email2Admin.setMsg("校园帮帮用户激活");
            email2Admin.setHtmlMsg("<a href=\"http://" + IpUtil.getLocalIp() + ":8080/xybb\">点击激活</a>");
            email2Admin.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return true;
    }
}
