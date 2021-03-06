package com.xybb.mvc.controller;

import com.xybb.cache.MemcachedClient_Demo;
import com.xybb.model.AjaxResult;
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
@RequestMapping("index")
public class IndexController {

    @Resource
    private MemcachedClient_Demo memcachedClient_demo;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model, HttpServletRequest request) throws InterruptedException, MemcachedException, TimeoutException {
        ModelAndView view = new ModelAndView();
        view.setViewName("layouts.application_layout.index");
        model.addAttribute("message", "Hello world!");
        IpUtil.getIpAddr(request);
        String s = memcachedClient_demo.set2Get(new String[]{"1iwei", "1"});
        System.out.println(SensitiveQuestion.SENSITIVEQUESTIONS);
        return view;
    }

}