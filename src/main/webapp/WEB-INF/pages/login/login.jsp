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
    var emailName, password, remember, cookie;

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
                if (msg.success) {
                    window.location.href = "<%=basePath%>home";
                } else {
                    errorHint(msg.msg);
                    if (msg.object == 'cookie_failure') {
                        COOKIE_UTIL.delCookie('_xybb_auth_record');
                    }
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

    $(function () {

        $("#register_error").hide();

        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
        cookie = COOKIE_UTIL.getCookie("_xybb_auth_record");
        //如果设置过自动登录，进行自动登录验证
        if (cookie != null) {
            cookie = COOKIE_UTIL.getCookie("_xybb_auth_record");
            remember = "automatic_login";
            var data = "emailName=" + emailName + "&password=" + password + "&remember=" + remember + "&cookie=" + cookie;
            login(data);
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
            emailName = $("#emailName").val();
            password = $("#password").val();

            if (isEmail(emailName)) {
                errorHint("邮箱格式不正确 !");
                return false;
            }

            if (isPasswd(password)) {
                errorHint("密码格式不正确，6-20个字母、数字、下划线 !");
                return false;
            }

            remember = $("[name='remember']:checked").length;

            //如果用户设置了自动登录-设置cookie
            if (remember == 1) {
                cookie = COOKIE_UTIL.getCookie("JSESSIONID");
                COOKIE_UTIL.savaCookie('_xybb_auth_record', cookie);
            } else {
                COOKIE_UTIL.delCookie('_xybb_auth_record');
                cookie = "";
            }
            var data = "emailName=" + emailName + "&password=" + password + "&remember=" + remember + "&cookie=" + cookie;
            login(data);
        });
    });

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