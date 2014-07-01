package com.xybb.mvc.controller;

import com.xybb.model.AjaxResult;
import com.xybb.mvc.service.RegisterService;
import com.xybb.system.parameter.ProjectParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        request.getSession().setAttribute(ProjectParameter.MENU_1_TEXT, "register");
        return view;
    }

    /**
     * 用户注册，用户名是否存在验证
     *
     * @param emailName
     * @return
     */
    @RequestMapping(value = "/ishaveemailname", method = RequestMethod.GET)
    public
    @ResponseBody
    AjaxResult isHaveEmailName(@RequestParam String emailName) {
        return registerService.isHaveEmailName(emailName);
    }

    /**
     * 用户注册-邮箱激活链接发送
     *
     * @param emailName
     * @param password
     * @param tag
     * @return
     */
    @RequestMapping(value = "/activate", method = RequestMethod.GET)
    public
    @ResponseBody
    AjaxResult activate(@RequestParam String emailName, @RequestParam String password, @RequestParam String tag) {
        return registerService.activate(emailName, password, tag);
    }

    /**
     * 用户注册-邮箱激活链接处理
     *
     * @param emailName
     * @param uuid
     * @param tag
     * @param request
     * @return
     */
    @RequestMapping(value = "/activate/handle", method = RequestMethod.GET)
    public ModelAndView activate_Handle(@RequestParam String emailName, @RequestParam String uuid, @RequestParam String tag, HttpServletRequest request) {
        AjaxResult ajaxResult = registerService.activate_Handle(emailName, uuid, tag);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("emailName", emailName);
        //成功-设置seesion
        if (ajaxResult.isSuccess()) {
            request.getSession().setAttribute("session2UserInfo", ajaxResult.getObject());
            modelAndView.setViewName("/login/register_success");
        } else {
            modelAndView.addObject("error", ajaxResult.getMsg());
            modelAndView.setViewName("login/register_failure");
        }
        return modelAndView;
    }


}
