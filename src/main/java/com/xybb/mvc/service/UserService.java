package com.xybb.mvc.service;

import com.xybb.mvc.repository.UserInfoRository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lw on 14-7-01.
 */
@Service
public class UserService {

    @Resource
    private UserInfoRository userInfoRository;


}
