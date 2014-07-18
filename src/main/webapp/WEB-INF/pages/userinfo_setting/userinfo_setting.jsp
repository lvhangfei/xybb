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
<div class="container theme-showcase" style="width: 80%">
    <ul class="nav nav-tabs" role="tablist" id="myTab">
        <li class="active"><a href="#userinfo_setting_home" role="tab" data-toggle="tab">基本信息</a></li>
        <li><a href="#userinfo_setting_attention" role="tab" data-toggle="tab">我的关注</a></li>
        <li><a href="#userinfo_setting_safetysetting" role="tab" data-toggle="tab">安全设置</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active" id="userinfo_setting_home">
            <jsp:include page="userinfo_setting_home.jsp"></jsp:include>
        </div>
        <div class="tab-pane" id="userinfo_setting_attention">
            <jsp:include page="userinfo_setting_attention.jsp"></jsp:include>
        </div>
        <div class="tab-pane" id="userinfo_setting_safetysetting">
            <jsp:include page="userinfo_setting_safetysetting.jsp"></jsp:include>
        </div>
    </div>

</div>
