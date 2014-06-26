<!--

Created by IntelliJ IDEA.
User: lw
Date: 14-6-20
Time: 21:27
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

        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
        var remember_me = COOKIE_UTIL.getCookie('remember_me');

        //如果设置过自动登录，显示cookie记录
        if (remember_me == 'true') {
            $("[name='remember']").iCheck('check');
            var remember_emailName = $.cookie('remember_emailName');
            var remember_password = $.cookie('remember_password');
            if (remember_emailName != null) {
                $("#emailName").val(remember_emailName);
            }
            if (remember_password != null) {
                $("#password").val(remember_password);
            }
        }


        /**
         * 文本框获取焦点事件
         */
        $(".form-control").focus(function () {
            $("#register_error").hide();
            obj2Disabled("login_click", false, "登 录");
        });

        /**
         * 注册登录按钮事件
         */
        $("#login_click").click(function () {
            obj2Disabled("login_click", true, "");
            var emailName = $("#emailName").val();
            var password = $("#password").val();

            if (isEmail(emailName)) {
                errorHint("邮箱格式不正确 !");
                return false;
            }

            if (isPasswd(password)) {
                errorHint("密码格式不正确，6-20个字母、数字、下划线 !");
                return false;
            }

            var remember = $("[name='remember']:checked").length;
            var data = "emailName=" + emailName + "&password=" + password + "&remember=" + remember;

            //如果用户设置了自动登录-设置cookie
            if (remember == 1) {
                COOKIE_UTIL.savaCookie('remember_me', 'true');
                COOKIE_UTIL.savaCookie('remember_emailName', emailName);
                COOKIE_UTIL.savaCookie('remember_password', password);
            } else {
                COOKIE_UTIL.delCookie('remember_me');
                COOKIE_UTIL.delCookie('remember_emailName');
                COOKIE_UTIL.delCookie('remember_password');
            }
            //login(submit_Obj, data);
        });

    });

    /**
     * 登录事件
     * @param submit_Obj
     * @param data
     */
    function login(data) {
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
            <h4 class="form-signin-heading">请输入email、密码登录到${applicationScope.PROJECTNAME}</h4>
        </div>
        <input type="text" id="emailName" class="form-control" placeholder="输入email号码" required autofocus>
        <input type="password" id="password" class="form-control" placeholder="输入密码" required>
        <label class="checkbox">
            <input type="checkbox" name="remember" value="remember-me">&nbsp;自动登录
        </label>
        <button type="button" id="login_click" class="btn btn-primary form-signin-submit">登&nbsp;录</button>
        <div id="register_error" class="alert alert-warning alert-error" style="margin-top: 10px">
            <strong>&nbsp;提示&nbsp;:&nbsp;</strong>&nbsp;&nbsp; <span id="error"></span>
        </div>
    </form>
</div>