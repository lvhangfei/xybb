package com.xybb.system.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by lw on 14-6-25.
 * <p/>
 * 处理springmvc的异常
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private static final Logger LOG = Logger.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView view = new ModelAndView();
        return view;
    }
}