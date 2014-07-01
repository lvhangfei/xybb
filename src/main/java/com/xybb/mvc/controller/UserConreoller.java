package com.xybb.mvc.controller;

import com.xybb.mvc.service.UserService;
import com.xybb.system.parameter.ProjectParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by lw on 14-7-1.
 * userInfo
 */
@Controller
@RequestMapping("userinfo")
public class UserConreoller {

    @Resource
    public UserService userService;

    /**
     * 跳转到个人信息修改页面
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/{id}/setting", method = RequestMethod.GET)
    public ModelAndView go_Login_Page(@PathVariable("id") String id, HttpServletRequest request) {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.userinfo_setting");
        HttpSession session = request.getSession();
        session.removeAttribute(ProjectParameter.MENU_1_TEXT);
        session.setAttribute(ProjectParameter.MENU_1_ICON, "userinfo_setting_icon");
        return view;
    }


}
