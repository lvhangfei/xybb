<!--

Created by IntelliJ IDEA.
User: lw
Date: 14-7-1
Time: 19:47
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script>
    $(function () {
        $('#myTab a:first').tab('show');
        $('#myTab a').click(function (e) {
            e.preventDefault()
            $(this).tab('show')
        })
    });
</script>
<div class="container theme-showcase">
    <ul class="nav nav-tabs" role="tablist" id="myTab">
        <li class="active"><a href="#userinfo_setting__home" role="tab" data-toggle="tab">基本信息</a></li>
        <li><a href="#userinfo_setting_attention" role="tab" data-toggle="tab">我的关注</a></li>
        <li><a href="#userinfo_setting_safetysettings" role="tab" data-toggle="tab">安全设置</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active" id="userinfo_setting__home">基本信息</div>
        <div class="tab-pane" id="userinfo_setting_attention">我的关注</div>
        <div class="tab-pane" id="userinfo_setting_safetysettings">安全设置</div>
    </div>

</div>
