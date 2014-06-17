<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    body {
        min-height: 2000px;
        padding-top: 70px;
    }

    .active {
        border-bottom: 3px solid #d30d15;
    }
</style>
<script>
    $(function () {
    });
</script>
<!-- Fixed navbar -->
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
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">主页</a></li>
                <li><a href="#about">情感交流</a></li>
                <li class="active"><a href="#contact">二手交易</a></li>
                <li><a href="#about">我是吃货</a></li>
                <li><a href="#about">去哪儿玩</a></li>
                <li><a href="#about">我们毕业了</a></li>
                <li><a href="#about">找人帮忙</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" style="width: 250px" class="form-control" placeholder="搜 索" title="搜 索">
                </div>
                <button type="submit" class="btn btn-info">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar/">Wei.L</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>

