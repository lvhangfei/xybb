<!--
注册
Created by IntelliJ IDEA.
User: lw
Date: 14-6-28
Time: 15:41
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<body>
${emailName}账号激活失败，请 <a href="<%=basePath%>register">重新申请！</a>&nbsp;&nbsp;原因：${error}
</body>