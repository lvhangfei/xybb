package com.xybb.mvc.controller;

import com.xybb.model.AjaxResult;
import com.xybb.system.parameter.ProjectParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by lw on 14-6-20.
 * 登录
 */
@Controller
@RequestMapping("login")
public class LoginConreoller {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView go_Login_Page(HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.login");
        request.getSession().setAttribute(ProjectParameter.MENU_1, "login");
        return view;
    }

    @RequestMapping(value = "/do", method = RequestMethod.POST)
    public
    @ResponseBody
    AjaxResult Login(@RequestParam String name, @RequestParam String password, @RequestParam String remember) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMsg("用户名密码错误");
        ajaxResult.setSucceed(false);
        return ajaxResult;
    }

}
