package com.xybb.mvc.controller;

import com.xybb.model.AjaxResult;
import com.xybb.model.Session2UserInfo;
import com.xybb.mvc.service.LoginService;
import com.xybb.system.parameter.ProjectParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by lw on 14-6-20.
 * 登录
 */
@Controller
@RequestMapping("login")
public class LoginConreoller {

    @Resource
    public LoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView go_Login_Page(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.login");
        Session2UserInfo session2UserInfo = new Session2UserInfo();
        loginService.loginCheck(session2UserInfo, request);
        request.getSession().setAttribute(ProjectParameter.MENU_1, "login");
        return view;
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxResult Login(@RequestParam String name, @RequestParam String password, @RequestParam String remember, HttpServletRequest request) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMsg("用户名密码错误");
        ajaxResult.setSucceed(false);
        Session2UserInfo session2UserInfo = new Session2UserInfo();
        loginService.loginCheck(session2UserInfo, request);
        return ajaxResult;
    }

}
