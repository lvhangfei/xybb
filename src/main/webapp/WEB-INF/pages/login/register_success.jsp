<!--
注册
Created by IntelliJ IDEA.
User: lw
Date: 14-6-28
Time: 15:34
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.0.3.min.js"></script>
<script>
    $(function () {
        setTimeout(function () {
            window.location.href = "<%=basePath%>home";
        }, 2000);
    });
</script>
<body>
${emailName}账号激活成功，自动登录中...
</body>
