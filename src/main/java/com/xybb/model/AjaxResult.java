package com.xybb.model;

/**
 * Created by lw on 14-6-21.
 * ajax数据返回封装对象
 */
public class AjaxResult {

    private String msg = "";//返回描述信息
    private Object object;//返回数据
    private boolean isSucceed = true;//是否成功

    //枚举类型获取常用返回数据描述
    public enum State {
        SUCCEED, FAILURE, ERROR, POWERQUESTION, SENSITIVEQUESTION
    }

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

    /**
     * 静态方法，枚举类型获取返回对象
     *
     * @param state 返回类型描述
     * @return
     */
    public static AjaxResult getAjaxResult(State state) {
        AjaxResult ajaxResult = new AjaxResult();
        switch (state) {
            case SUCCEED:
                ajaxResult.setSucceed(true);
                ajaxResult.setMsg("加载成功！");
                break;
            case FAILURE:
                ajaxResult.setSucceed(false);
                ajaxResult.setMsg("加载失败！");
                break;
            case ERROR:
                ajaxResult.setSucceed(false);
                ajaxResult.setMsg("数据错误！");
                break;
            case POWERQUESTION:
                ajaxResult.setSucceed(false);
                ajaxResult.setMsg("权限不足！");
                break;
            case SENSITIVEQUESTION:
                ajaxResult.setSucceed(false);
                ajaxResult.setMsg("含有敏感字符！");
                break;
        }
        return ajaxResult;
    }

    /**
     * 静态方法，枚举类型获取返回对象
     *
     * @param state  返回类型描述
     * @param object 封装数据
     * @return
     */
    public static AjaxResult getAjaxResult(State state, Object object) {
        AjaxResult ajaxResult = getAjaxResult(state);
        ajaxResult.setObject(object);
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
