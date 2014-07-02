<!--
基本信息
Created by IntelliJ IDEA.
User: lw
Date: 14-7-2
Time: 20:55
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<br>

<div>
    <form class="form-horizontal" role="form" id="form_userinfo_setting_home">
        <div class="form-group">
            <label for="emailName" class="col-sm-2 control-label">邮箱</label>

            <div class="col-sm-8">
                <input type="password" class="form-control" id="emailName" placeholder="邮箱">
            </div>
        </div>
        <div class="form-group">
            <label for="alias_Name" class="col-sm-2 control-label">用户名</label>

            <div class="col-sm-8">
                <input type="password" class="form-control" id="alias_Name" placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="sex1" class="col-sm-2 control-label">性别</label>

            <div class="col-sm-8">
                <label class="radio-inline">
                    <input type="radio" name="sex" id="sex1" value="0"> 男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="sex" id="sex2" value="1" checked> 女
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="birthday" class="col-sm-2 control-label">生日</label>

            <div class="col-sm-8">
                <input type="password" class="form-control" id="birthday" placeholder="生日">
            </div>
        </div>
        <div class="form-group">
            <label for="area" class="col-sm-2 control-label">所在地</label>

            <div class="col-sm-8">
                <input type="password" class="form-control" id="area" placeholder="所在地">
            </div>
        </div>
        <div class="form-group">
            <label for="school" class="col-sm-2 control-label">学校</label>

            <div class="col-sm-8">
                <input type="password" class="form-control" id="school" placeholder="学校">
            </div>
        </div>
        <div class="form-group">
            <label for="love_State1" class="col-sm-2 control-label">恋爱状态</label>

            <div class="col-sm-8">
                <label class="radio-inline">
                    <input type="radio" name="love_State" id="love_State1" value="0" checked> 单身
                </label>
                <label class="radio-inline">
                    <input type="radio" name="love_State" id="love_State2" value="1"> 热恋
                </label>
                <label class="radio-inline">
                    <input type="radio" name="love_State" id="love_State3" value="2"> 已婚
                </label>
                <label class="radio-inline">
                    <input type="radio" name="love_State" id="love_State4" value="3"> 离异
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="submit_userinfo_setting_home" class="col-sm-2 control-label"></label>

            <div class="col-sm-8">
                <button type="button" id="submit_userinfo_setting_home" class="btn btn-success">保存配置</button>
            </div>
        </div>
    </form>
</div>