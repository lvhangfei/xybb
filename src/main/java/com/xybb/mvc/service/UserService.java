package com.xybb.mvc.service;

import com.xybb.model.AjaxResult;
import com.xybb.model.user.Session2UserInfo;
import com.xybb.model.user.UserInfo;
import com.xybb.mvc.repository.UserInfoRository;
import com.xybb.utils.IpUtil;
import com.xybb.utils.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lw on 14-7-01.
 */
@Service
public class UserService {

    @Resource
    private UserInfoRository userInfoRository;


}
