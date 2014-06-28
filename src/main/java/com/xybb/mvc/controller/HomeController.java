package com.xybb.mvc.controller;

import com.xybb.cache.MemcachedClient_Demo;
import com.xybb.model.user.Session2UserInfo;
import com.xybb.mvc.service.HomeService;
import com.xybb.system.parameter.ProjectParameter;
import com.xybb.system.parameter.SensitiveQuestion;
import com.xybb.utils.IpUtil;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("home")
public class HomeController {

    @Resource
    private HomeService homeService;

    @Resource
    private MemcachedClient_Demo memcachedClient_demo;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView go_Home_Page(ModelMap model, HttpServletRequest request) throws InterruptedException, MemcachedException, TimeoutException {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.index");
        model.addAttribute("message", "Hello world!");
        IpUtil.getIpAddr(request);

        request.getSession().setAttribute(ProjectParameter.MENU_1, "home");
        homeService.go_Home_Page(new Session2UserInfo(), request);
        String s = memcachedClient_demo.set2Get(new String[]{"1iwei", "1"});
        return view;
    }

}