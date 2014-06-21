package com.xybb.mvc.service;

import com.xybb.annotation.VerificationAutomaticLogin;
import com.xybb.model.Session2UserInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lw on 14-6-21.
 */
@Service
public class LoginService {

    public String loginCheck(Session2UserInfo session2UserInfo, HttpServletRequest request) {

        return "";
    }
}
