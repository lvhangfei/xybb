package com.xybb.mvc.service;

import com.xybb.model.AjaxResult;
import com.xybb.model.user.Session2UserInfo;
import com.xybb.mvc.repository.UserInfoRository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lw on 14-6-21.
 */
@Service
public class UserService {

    @Resource
    private UserInfoRository userInfoRository;

    public AjaxResult Login_Do(String name, String password, String remember, HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult();

        Session2UserInfo session2UserInfo = new Session2UserInfo();
        return ajaxResult;
    }
}
