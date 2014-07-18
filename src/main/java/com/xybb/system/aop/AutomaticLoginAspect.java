package com.xybb.system.aop;

import com.xybb.model.user.Session2UserInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lw on 14-6-21.
 */
@Component
@Aspect
public class AutomaticLoginAspect {

    @Before(value = "execution(* com.xybb.mvc.service.*.*(..)) && args(session2UserInfo,request)", argNames = "joinPoint,session2UserInfo,request")
    public void isHaveCookie(JoinPoint joinPoint, Session2UserInfo session2UserInfo, HttpServletRequest request) {
    }
}
