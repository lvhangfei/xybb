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
<link rel="stylesheet" type="text/css" media="screen"
      href="<%=basePath%>resources/plug/datepicker/css/datepicker.css">
<script type="text/javascript"
        src="<%=basePath%>resources/plug/datepicker/js/bootstrap-datepicker.js"></script>
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
            <label for="area_Id" class="col-sm-2 control-label">所在地</label>

            <div class="col-sm-8">
                <select id="province_Id" style="display:inline-block ;width: 150px">
                    <option value="-1">所在省</option>
                    <option value="1">我的小学学校名字是？</option>
                    <option value="2">我的初中学校名字是？</option>
                    <option value="3">我的高中学校名字是？</option>
                    <option value="4">我的大学学校名字是？</option>
                    <option value="4">我的第一个公司名字是？</option>
                </select>
                &nbsp;
                <select id="city_Id" style="width: 150px">
                    <option value="-1">所在市</option>
                    <option value="1">我的小学学校名字是？</option>
                    <option value="2">我的初中学校名字是？</option>
                    <option value="3">我的高中学校名字是？</option>
                    <option value="4">我的大学学校名字是？</option>
                    <option value="4">我的第一个公司名字是？</option>
                </select>
                &nbsp;
                <select id="area_Id" style="width: 150px">
                    <option value="-1">所在地区</option>
                    <option value="1">我的小学学校名字是？</option>
                    <option value="2">我的初中学校名字是？</option>
                    <option value="3">我的高中学校名字是？</option>
                    <option value="4">我的大学学校名字是？</option>
                    <option value="4">我的第一个公司名字是？</option>
                </select>
                &nbsp;
                <span class="label label-info" style="cursor: hand">地图定位</span>
                <span class="label label-warning" style="cursor: hand">IP自动定位</span>
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
            <label for="explain" class="col-sm-2 control-label">个人说明</label>

            <div class="col-sm-8">
                <textarea class="form-control" id="explain" rows="2"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="submit_userinfo_setting_home" class="col-sm-2 control-label"></label>

            <div class="col-sm-8">
                <button type="button" id="submit_userinfo_setting_home" class="btn btn-success">保存基本信息</button>
            </div>
        </div>
    </form>

    <div class="input-append date" id="dpYears" data-date="12-02-2012" data-date-format="dd-mm-yyyy"
         data-date-viewmode="years">
        <input class="span2" size="16" type="text" value="12-02-2012" readonly="">
        <span class="add-on"><i class="icon-calendar"></i></span>
    </div>
</div>
<script>
    $(function () {
        $('#dpYears').datepicker();

    });
</script>