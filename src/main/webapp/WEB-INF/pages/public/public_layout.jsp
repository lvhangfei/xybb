<%--
  Created by IntelliJ IDEA.
  User: lw
  Date: 14-6-14
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>校园帮帮平台</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script type="text/javascript" src="<%=basePath%>resources/js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/bootstrap/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resources/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>resources/css/style.css">

</head>
<body>
<div>
    <tiles:insertAttribute name="header"/>
</div>

<div style="padding-top: 50px">
    <tiles:insertAttribute name="main-container"/>
</div>

<div>
    <tiles:insertAttribute name="bottom"/>
</div>

</body>
</html>

