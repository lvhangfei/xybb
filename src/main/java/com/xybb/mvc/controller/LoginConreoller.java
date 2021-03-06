package com.xybb.mvc.controller;

import com.xybb.model.AjaxResult;
import com.xybb.mvc.service.UserService;
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
    public UserService userService;

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
     * @param name
     * @param password
     * @param remember
     * @param request
     * @return
     */
    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxResult Login_Do(@RequestParam String name, @RequestParam String password, @RequestParam String remember, HttpServletRequest request) {

        return userService.Login_Do(name, password, remember, request);
    }

}
