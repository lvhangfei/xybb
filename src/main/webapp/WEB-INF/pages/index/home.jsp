<%--
  Created by IntelliJ IDEA.
  User: lw
  Date: 14-6-14
  Time: 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="resources/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<style>
    .state {
        padding-left: 100px;
    }
</style>
<script>
    $(function () {
        $("#a1").tooltip();
        $('#a1').popover();
        $('#a1').popover('show');
    });

</script>
<div class="state">
    <h2>校园交流</h2>
    对校园的文化进行交流
    <h2>情感天地</h2>
    发布一些自己生活中的情感信息
    <h2>毕业心声</h2>
    大四毕业生离开学校，离开朋友们的一些心中感想
    <h2>二手交易</h2>
    可以发布出售或者求购信息，可以联系卖家进行购买，形式为见面交易，不涉及支付模块。
    <h2>找好玩</h2>
    共享或者发布咨询一些好玩的地方，比如去哪儿玩过，旅游过，以及一些感想
    <h2>我是吃货</h2>
    共享或者发布咨询一些校园周围好吃的地方
    <h2>寻找帮助</h2>
    发布求助信息，比如帮写毕业论文
    <h2>我在帮帮</h2>
    展示我在帮帮的操作记录,发布过的信息，进行删除操作管理
    <h1>伙伴们我调研一下：</h1>

    <h1>假如有这么个网站，你觉得做什么功能可以吸引人，让大学生愿意没事进这儿看看</h1>

    <h1>或者上面的某个功能没有意义？</h1>

    <button id="a1" type="button" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title=""
            data-original-title="<h1> <>假如有这么个网站，你觉得做什么功能可以吸引人，让大学生愿意没事进这儿看看</h1>

    <h1>或者上面的某个功能没有意义？</h1>">左侧Tooltip
    </button>
</div>

