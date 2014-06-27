package com.xybb.mvc.controller;

import com.xybb.model.AjaxResult;
import com.xybb.mvc.service.RegisterService;
import com.xybb.system.parameter.ProjectParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by lw on 14-6-20.
 * 注册
 */
@Controller
@RequestMapping("register")
public class RegisterConreoller {

    @Resource
    public RegisterService registerService;

    /**
     * 跳转到注册页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView go_Login_Page(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.register");
        request.getSession().setAttribute(ProjectParameter.MENU_1, "register");
        return view;
    }

    /**
     * 用户注册-邮箱激活链接发送
     *
     * @param emailName
     * @param password
     * @return
     */
    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public String activate(@RequestParam String emailName, @RequestParam String password) {
        registerService.activate(emailName, password);
        return "";
    }

}
