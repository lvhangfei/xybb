package com.xybb.mvc.controller;

import com.xybb.system.parameter.ProjectParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by lw on 14-6-20.
 * 登录
 */
@Controller
@RequestMapping("login")
public class LoginConreoller {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.login");
        view.addObject(ProjectParameter.MENU_1, "login");
        return view;
    }

}
