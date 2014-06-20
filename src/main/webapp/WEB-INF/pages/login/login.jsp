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

<style>

    .form-signin {
        max-width: 330px;
        padding: 10px;
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

    #submit {
        width: 120px;
        margin-left: 190px;
    }
</style>
<script>
    $(document).ready(function () {

        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-red',
            radioClass: 'iradio_flat-red'
        });
        $("[name='remember']").iCheck('check');

        $('#submit').click(function () {
            var submit_Obj = $("#submit");
            if (submit_Obj.hasClass("disabled")) {
                return false;
            }
            submit_Obj.html("登录中 " + load_icon);
            submit_Obj.addClass("disabled");
            var data = "name=" + $("#name").val() + "&password=" + $("#password").val() + "&remember=" + $("[name='remember']").val();

            /*if ($("[name='remember']").val()) {
             $.cookie('xybb_user_msg', 'data', { expires: 15, path: '/' });
             }*/
            login(submit_Obj, data);
        });

        var cookie = $.cookie('xybb_user_msg'); // cookie存在 => 'the_value'

        if (cookie != null) {

        }

    });

    /**
     * 登录事件
     * @param submit_Obj
     * @param data
     */
    function login(submit_Obj, data) {
        //alert($("[name='remember']").parent.(".checked"));
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
</script>
<div class="container" style="min-height: 400px">

    <form class="form-signin" role="form">
        <div style="text-align: center">
            <h2 class="form-signin-heading">登录</h2>
        </div>
        <input type="text" id="name" class="form-control" placeholder=" 输入用户名" required autofocus>
        <input type="password" id="password" class="form-control" placeholder="输入密码" required>
        <label class="checkbox">
            <input type="checkbox" name="remember" value="remember-me">&nbsp;自动登录
        </label>
        <button type="button" id="submit" class="btn btn-primary">登&nbsp;录</button>

    </form>
</div>