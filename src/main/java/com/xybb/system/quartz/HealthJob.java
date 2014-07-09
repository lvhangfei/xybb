package com.xybb.system.quartz;

import com.xybb.system.parameter.SystemParameter;
import org.springframework.stereotype.Component;

/**
 * Created by lw on 14-6-25.
 * 系统运行时期组件健康状态监控
 */
@Component
public class HealthJob {

    public void init_Quartz() {
        System.out.println("===============init_Quartz===============");
    }

    public void Quartz() {

        if (SystemParameter.IS_SYSTEM_MAINTENANCE) {
            SystemParameter.IS_SYSTEM_MAINTENANCE = false;
        } else {
            SystemParameter.IS_SYSTEM_MAINTENANCE = true;
        }

        System.out.println("===============Quartz===============");
    }

}
