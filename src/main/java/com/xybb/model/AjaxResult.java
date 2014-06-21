package com.xybb.model;

/**
 * Created by lw on 14-6-21.
 * ajax数据返回封装对象
 */
public class AjaxResult {

    private String msg = "";//返回描述信息
    private Object object;//返回数据
    private boolean isSucceed = true;//是否成功

    public AjaxResult() {

    }

    public AjaxResult(String msg, boolean isSucceed) {
        this.msg = msg;
        this.isSucceed = isSucceed;
    }

    public AjaxResult(String msg, Object object, boolean isSucceed) {
        this.msg = msg;
        this.object = object;
        this.isSucceed = isSucceed;
    }

    public static AjaxResult get_Service_Error() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSucceed(false);
        ajaxResult.setMsg("服务器发生错误！");
        return ajaxResult;
    }

    public static AjaxResult get_Data_Error() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSucceed(false);
        ajaxResult.setMsg("服务器端数据发生错误！");
        return ajaxResult;
    }

    public static AjaxResult get_Power_Error() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSucceed(false);
        ajaxResult.setMsg("含有敏感字符！");
        return ajaxResult;
    }

    public static AjaxResult get_SensitiveQuestion_Error() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSucceed(false);
        ajaxResult.setMsg("含有敏感字符！");
        return ajaxResult;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSucceed() {
        return isSucceed;
    }

    public void setSucceed(boolean isSucceed) {
        this.isSucceed = isSucceed;
    }
}
