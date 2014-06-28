package com.xybb.mvc.controller;

import com.xybb.model.AjaxResult;
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

    /**
     * 跳转到登录页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView go_Login_Page(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.login");
        request.getSession().setAttribute(ProjectParameter.MENU_1, "login");
        return view;
    }

    /**
     * 用户登录验证
     *
     * @param emailName
     * @param password
     * @param remember
     * @param cookie
     * @param request
     * @return
     */
    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxResult login_Do(@RequestParam String emailName, @RequestParam String password,
                        @RequestParam String remember,
                        @RequestParam String cookie, HttpServletRequest request) {
        return loginService.login_Do(emailName, password, remember, cookie, request);
    }

    /**
     * 用户注销事件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public ModelAndView login_Out(HttpServletRequest request) {
        loginService.login_Out(request);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login/");
        return modelAndView;
    }


}
