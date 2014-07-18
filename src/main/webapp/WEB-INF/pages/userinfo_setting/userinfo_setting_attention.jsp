<!--
基本信息
Created by IntelliJ IDEA.
User: lw
Date: 14-7-2
Time: 20:55
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<script type="text/javascript" src="<%=basePath%>resources/plug/chosen/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>resources/plug/chosen/chosen.css">

<div class="col-sm-10">
    <select data-placeholder="请选择关注内容..." class="chosen-select" multiple id="chosen-select" style="height: ">
        <option value=""></option>
        <option value="United States">United States</option>
        <option value="United Kingdom">United Kingdom</option>
        <option value="Afghanistan">Afghanistan</option>
        <option value="Aland Islands">Aland Islands</option>
        <option value="Albania">Albania</option>
    </select>
</div>
<div class="btn-group" data-toggle="buttons">
    <label class="btn btn-info active">
        <input type="checkbox" name="a" checked> Option 1
    </label>
    <label class="btn btn-info">
        <input type="checkbox" name="a"> Option 2
    </label>
    <label class="btn btn-info">
        <input type="checkbox" name="a"> Option 3
    </label>
    <label class="btn btn-info">
        <input type="checkbox" name="a"> Option 2
    </label>
    <label class="btn btn-info">
        <input type="checkbox" name="a"> Option 3
    </label>
</div>

<script>

    $(".chosen-select").chosen({width: "300px;", disable_search_threshold: 10});
    $(function () {
        $("input[type=checkbox][name='a']").change(function () {
            alert(this);
        });
    });
</script>