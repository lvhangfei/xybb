package com.xybb.system.quartz;

import com.xybb.model.user.UserRegister;
import com.xybb.mvc.service.RegisterService;
import com.xybb.utils.LogFactoryUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lw on 14-6-29.
 * 定时清理任务
 */
@Component
public class ClearJob {

    @Resource
    RegisterService registerService;

    public void clean_job() {
        //定时清理用户注册信息临时表记录
        clean_UserRegisters();
    }

    /**
     * 清理用户注册信息临时表记录
     */
    private void clean_UserRegisters() {
        List<UserRegister> userRegisters = registerService.clean_Job();
        if (userRegisters.size() != 0) {
            LogFactoryUtil.quartz_Log.info("===============定时清理任务:清理用户临时记录====================");
            LogFactoryUtil.quartz_Log.info("===============定时清理任务:共计-[" + userRegisters.size() + "]个====================");
            for (UserRegister userRegister : userRegisters) {
                LogFactoryUtil.quartz_Log.info(userRegister);
            }
        } else {
            LogFactoryUtil.quartz_Log.info("===============定时清理任务:无用户临时记录====================");
        }
    }
}
