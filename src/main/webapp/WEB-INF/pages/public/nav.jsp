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

    .menu_1_text {
        border-bottom: 3px solid #2aabd2;
    }

    .menu_1_icon {
        color: #2aabd2;
        font-family: "Cherry Swash", sans-serif;
    }
</style>
<script>

    var menu_1_text = "${sessionScope.menu_1_text}";
    var menu_1_icon = "${sessionScope.menu_1_icon}";

    $(function () {

        if (menu_1_text == "") {
            $("#" + menu_1_icon).css("color", "#2aabd2");
        } else {
            $("#" + menu_1_text).addClass("menu_1_text");
        }

        $("#search").focus(function () {
            $("#home,#affective,#secondhand").hide();
            $("#search").css("width", "430px");
        });
        $("#search").blur(function () {
            $("#home,#affective,#secondhand").show();
            $("#search").css("width", "200px");
        });
        $("#userinfo,#userinfo_setting,#plus,#message,#out").tooltip();
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
            <a class="navbar-brand" href="#"><i class="icon-flag pull-left"></i>${applicationScope.PROJECTNAME}</a>
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

                <c:when test="${empty sessionScope.session2UserInfo }">
                    <ul class="nav navbar-nav navbar-right">
                        <li id="login"><a href="<%=basePath%>login"> 登录</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li id="register"><a href="<%=basePath%>register"> 注册</a></li>
                    </ul>
                </c:when>

                <c:otherwise>
                    <ul class="nav navbar-nav navbar-right">
                        <li id="userinfo" data-toggle="tooltip" data-placement="bottom" title="我的个人信息">
                            <a id="userinfo_icon" href="#"><i class="icon-user"></i></a>
                        </li>
                        <li id="userinfo_setting" data-toggle="tooltip" data-placement="bottom" title="设置个人信息"
                            style="color: red">
                            <a id="userinfo_setting_icon"
                               href="<%=basePath%>userinfo/${sessionScope.session2UserInfo.userInfo_Id}/setting">
                                <i class="icon-cog"></i></a>
                        </li>
                        <li id="plus" data-toggle="tooltip" data-placement="bottom" title="发布信息">
                            <a id="plus_icon" href="#"><i class="icon-plus"></i></a>
                        </li>
                        <li id="message" data-toggle="tooltip" data-placement="bottom" title="查看我的消息">
                            <a id="message_icon" href="#"><i class="icon-envelope"></i></a>
                        </li>
                        <li id="out" data-toggle="tooltip" data-placement="bottom" title="注销">
                            <a href="javascript:;" onclick="login_Out('<%=basePath%>login/out')"><i
                                    class="icon-off"></i></a>
                        </li>
                    </ul>
                </c:otherwise>

                <%--<c:otherwise>--%>
                <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li  class="dropdown">--%>
                <%--<a href="#" data-toggle="dropdown"> ${sessionScope.session2UserInfo.alias_Name }&nbsp;<i--%>
                <%--class="icon-user"></i></a>--%>
                <%--<ul class="dropdown-menu" role="menu">--%>
                <%--<li class=""><a href="#icons-new">新图标</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li class=""><a href="#icons-web-app"><i class="icon-edit"></i> Web 应用</a></li>--%>
                <%--<li class=""><a href="#icons-text-editor"><i class="icon-save"></i> 文本编辑器</a></li>--%>
                <%--<li class=""><a href="#icons-directional"><i class="icon-hand-right"></i> 指示方向</a></li>--%>
                <%--<li class=""><a href="#icons-video-player"><i class="icon-play"></i>视频播放器</a></li>--%>
                <%--<li class=""><a href="#icons-social"><i class="icon-github"></i> SNS</a></li>--%>
                <%--<li class=""><a href="#icons-medical"><i class="icon-stethoscope"></i> 医疗</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
                <%--</ul>--%>
                <%--</c:otherwise>--%>
            </c:choose>
        </div>

    </div>
    <!--/.nav-collapse -->
</div>
</div>

