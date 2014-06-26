<!--
注册
Created by IntelliJ IDEA.
User: lw
Date: 14-6-26
Time: 20:04
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>resources/css/login.css">
<script>
    $(function () {

        $("#register_error").hide();

        /**
         * 文本框获取焦点事件
         */
        $(".form-control").focus(function () {
            $("#register_error").hide();
            obj2Disabled("register_click", false, "注 册");
        });

        /**
         * 注册事件
         */
        $('#register_click').click(function () {

            obj2Disabled("register_click", true, "");
            var emailName = $("#emailName").val();
            var password = $("#password").val();
            var password_1 = $("#password_1").val();

            if (isEmail(emailName)) {
                errorHint("邮箱格式不正确 !");
                return false;
            }

            if (isPasswd(password)) {
                errorHint("密码格式不正确，6-20个字母、数字、下划线 !");
                return false;
            }

            if (password != password_1) {
                errorHint("两次密码输入不一致 !");
                return false;
            }

            //  register(submit_Obj, data);
        });

    });

    /**
     * 登录事件
     * @param submit_Obj
     * @param data
     */
    function register(data) {
        $.ajax({
            type: "POST",
            url: "<%=basePath%>login/do",
            data: data,
            success: function (msg) {
                if (msg.isSuccess) {

                    window.location;
                } else {
                    //submit_Obj.html("登 录");
                    // submit_Obj.removeClass("disabled");
                }
            }
        });
    }

    /**
     * 错误提示
     */
    function errorHint(msg) {
        $("#register_error").show();
        $("#error").html(msg);
    }
</script>
<div class="container" style="min-height: 400px">
    <form class="form-signin" role="form">
        <div style="text-align: center">
            <h4 class="form-signin-heading">请输入email、密码进行注册</h4>
        </div>
        <input type="text" id="emailName" class="form-control" placeholder="输入email号码" required autofocus>
        <input type="password" id="password" class="form-control" placeholder="输入密码" required>
        <input type="password" id="password_1" class="form-control" placeholder="再次输入密码" required>
        <br>
        <button type="button" id="register_click" class="btn btn-primary form-signin-submit">注&nbsp;册</button>
        <div id="register_error" class="alert alert-warning alert-error" style="margin-top: 10px">
            <strong>&nbsp;提示&nbsp;:&nbsp;</strong>&nbsp;&nbsp; <span id="error"></span>
        </div>
    </form>

</div>