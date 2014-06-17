<!--

Created by IntelliJ IDEA.
User: lw
Date: 14-6-15
Time: 20:28
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<script type="text/javascript" src="http://www.jsfoot.com/skin/js/jquery.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        var h = $(document).height();
        $(".overlay").css({"height": h });

        $(".action").click(function () {

            $(".overlay").css({'display': 'block', 'opacity': '0.8'});

            $(".showbox").stop(true).animate({'margin-top': '300px', 'opacity': '1'}, 200);

            setTimeout(function () {

                $(".showbox").stop(true).animate({'margin-top': '250px', 'opacity': '0'}, 400);

                $(".overlay").css({'display': 'none', 'opacity': '0'});

            }, 800);

        });

    });
</script>


<div class="demo"><a class="action" href="javascript:void(0);">jquery float浮动层弹出层页面加载特效</a></div>

<div class="overlay"></div>

<div id="AjaxLoading" class="showbox">
    <div class="loadingWord"><img src="waiting.gif">加载中，请稍候...</div>
</div>

<div style="height:1200px;">

</div>

</body>
</html>
