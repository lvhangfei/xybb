package com.xybb.annotation;

import java.lang.annotation.*;

/**
 * Created by lw on 14-6-21.
 * 识别自动登录的Service注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface VerificationAutomaticLogin {
}
