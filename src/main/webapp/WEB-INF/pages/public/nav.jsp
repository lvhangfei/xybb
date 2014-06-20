<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<style>
    body {
        padding-top: 70px;
    }

    .active {
        border-bottom: 3px solid #d30d15;
    }
</style>
<script>

    var menu_1 = "#" + "${menu_1}";

    $(function () {
        $(menu_1).addClass("active");
    });

</script>
<!-- Fixed navbar 导航 -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">校园帮帮</a>
        </div>

        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" style="width: 200px" class="form-control" placeholder="搜 索" title="搜 索">
            </div>
            <button type="submit" class="btn btn-info">搜索</button>
        </form>

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="home"><a href="<%=basePath%>home">主页</a></li>
                <li id="affective"><a href="<%=basePath%>affective">情感交流</a></li>
                <li id="secondhand"><a href="<%=basePath%>secondhand">二手交易</a></li>
                <li id="foodie"><a href="<%=basePath%>foodie">我是吃货</a></li>
                <li id="play"><a href="<%=basePath%>play">去哪儿玩</a></li>
                <li id="graduate"><a href="<%=basePath%>graduate">我们毕业了</a></li>
                <li id="help"><a href="<%=basePath%>help">找人帮忙</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li id="login"><a href="<%=basePath%>login">登录</a></li>
                <%--<li><a href="../navbar/">Wei.L</a></li>--%>
            </ul>

        </div>
        <!--/.nav-collapse -->
    </div>
</div>

