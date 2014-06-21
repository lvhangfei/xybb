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

    .menu_1 {
        border-bottom: 3px solid #d30d15;
    }
</style>
<script>

    var menu_1 = "#" + "${sessionScope.menu_1}";

    $(function () {
        $(menu_1).addClass("menu_1");
        $("#search").mousedown(function () {
            $("#home,#affective,#secondhand").hide();
            $("#search").css("width", "430px");
        });
        $("#search").mouseout(function () {
            $("#home,#affective,#secondhand").show();
            $("#search").css("width", "200px");
        });
    });

</script>
<!-- Fixed navbar 导航 -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation" style="font-weight:900;">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><i class="icon-flag pull-left"></i>校园帮帮</a>
        </div>

        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" id="search" style="width: 200px" class="form-control" placeholder="搜 索" title="搜 索">
            </div>
            <%-- <button class="btn btn-info"><i class='icon-search'></i></button>--%>
        </form>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="home"><a href="<%=basePath%>home">主页</a></li>
                <li id="affective"><a href="<%=basePath%>affective">情感交流</a></li>
                <li id="secondhand"><a href="<%=basePath%>secondhand">二手交易</a></li>
                <li id="foodie"><a href="<%=basePath%>foodie">我是吃货</a></li>
                <li id="play"><a href="<%=basePath%>play">去哪儿玩</a></li>
                <%--<li id="graduate"><a href="<%=basePath%>graduate">我们毕业了</a></li>--%>
                <li id="help"><a href="<%=basePath%>help">找人帮忙</a></li>
            </ul>

            <c:choose>

                <c:when test="${empty sessionScope.userName }">
                    <ul class="nav navbar-nav navbar-right">
                        <li id="login"><a href="<%=basePath%>login"> Login</a></li>
                    </ul>
                </c:when>

                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown"> LIWEI&nbsp;<i class="icon-user"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li class=""><a href="#icons-new">新图标</a></li>
                                <li class="divider"></li>
                                <li class=""><a href="#icons-web-app"><i class="icon-edit"></i> Web 应用</a></li>
                                <li class=""><a href="#icons-text-editor"><i class="icon-save"></i> 文本编辑器</a></li>
                                <li class=""><a href="#icons-directional"><i class="icon-hand-right"></i> 指示方向</a></li>
                                <li class=""><a href="#icons-video-player"><i class="icon-play"></i>视频播放器</a></li>
                                <li class=""><a href="#icons-social"><i class="icon-github"></i> SNS</a></li>
                                <li class=""><a href="#icons-medical"><i class="icon-stethoscope"></i> 医疗</a></li>
                            </ul>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <!--/.nav-collapse -->
</div>
</div>

