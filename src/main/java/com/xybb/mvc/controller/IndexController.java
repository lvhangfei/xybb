package com.xybb.mvc.controller;

import com.xybb.cache.MemcachedClient_Demo;
import com.xybb.system.parameter.SystemParameter;
import com.xybb.utils.ip.IpUtil;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
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
        return view;
    }

    /**
     * 如果系统维护中过来的请求，再次判断是否维护
     * 不判断的话用户从此链接不可以跳出去
     *
     * @return
     */
    @RequestMapping(value = "/system_maintenance", method = RequestMethod.GET)
    public ModelAndView system_Maintenance() {
        ModelAndView view = new ModelAndView();
        if (SystemParameter.IS_SYSTEM_MAINTENANCE)
            view.setViewName("system_maintenance/system_maintenance");
        else
            view.setViewName("redirect:/index");
        return view;
    }
}