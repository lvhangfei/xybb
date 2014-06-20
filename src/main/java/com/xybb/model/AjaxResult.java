package com.xybb.model;

/**
 * Created by lw on 14-6-21.
 * ajax数据返回
 */
public class AjaxResult {

    private String msg = "";//返回描述信息
    private Object object;//返回数据
    private boolean isSucceed = true;//是否成功


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
