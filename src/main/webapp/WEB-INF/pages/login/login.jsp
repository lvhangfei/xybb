<!--

Created by IntelliJ IDEA.
User: lw
Date: 14-6-20
Time: 21:27
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }

    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }

    .form-signin .checkbox {
        font-weight: normal;
    }

    .form-signin .form-control {
        position: relative;
        font-size: 16px;
        height: auto;
        padding: 10px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
    }

    .form-signin .form-control:focus {
        z-index: 2;
    }

    .form-signin input[type="text"] {
        margin-bottom: -1px;
        border-bottom-left-radius: 0;
        border-bottom-right-radius: 0;
    }

    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

    .checkbox {
        padding-left: 0px;
    }
</style>
<script>
    $(document).ready(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
    });
</script>
<div class="container" style="min-height: 400px">

    <form class="form-signin" role="form">
        <div style="text-align: center"><h2 class="form-signin-heading">登录</h2></div>
        <input type="text" class="form-control" placeholder=" 输入用户名" required autofocus>
        <input type="password" class="form-control" placeholder="输入密码" required>
        <label class="checkbox">
            <input type="checkbox" value="remember-me">&nbsp;自动登录
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div>
<!-- /container -->