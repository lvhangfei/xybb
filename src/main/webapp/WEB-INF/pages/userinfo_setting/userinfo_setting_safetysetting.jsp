<!--
安全信息设置
Created by IntelliJ IDEA.
User: lw
Date: 14-7-2
Time: 21:55
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<br>

<div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">找回密码邮箱</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" id="form_password_Email">
                <div class="form-group">
                    <label class="col-sm-2 control-label">当前找回密码邮箱</label>

                    <div class="col-sm-6">
                        <p class="form-control-static">liweityut@163.com</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password_Email" class="col-sm-2 control-label">更换找回密码邮箱</label>

                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password_Email" placeholder="新的找回密码邮箱">
                    </div>
                </div>
                <div class="form-group">
                    <label for="submit_password_Email" class="col-sm-2 control-label"></label>

                    <div class="col-sm-8">
                        <button type="button" id="submit_password_Email" class="btn btn-success">更换找回密码邮箱</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">密保问题</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" id="form_password_Q">
                <div class="form-group">
                    <label for="question_1" class="col-sm-2 control-label">密保问题一</label>

                    <div class="col-sm-6">
                        <select class="form-control" id="question_1">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="answer_1" class="col-sm-2 control-label">密保答案一</label>

                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="answer_1" placeholder="密保答案一">
                    </div>
                </div>
                <div class="form-group">
                    <label for="question_2" class="col-sm-2 control-label">密保问题二</label>

                    <div class="col-sm-6">
                        <select class="form-control" id="question_2">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="answer_2" class="col-sm-2 control-label">密保答案二</label>

                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="answer_2" placeholder="密保答案二">
                    </div>
                </div>
                <div class="form-group">
                    <label for="question_3" class="col-sm-2 control-label">密保问题三</label>

                    <div class="col-sm-6">
                        <select class="form-control" id="question_3">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="answer_3" class="col-sm-2 control-label">密保答案三</label>

                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="answer_3" placeholder="密保答案三">
                    </div>
                </div>
                <div class="form-group">
                    <label for="submit_password_Q" class="col-sm-2 control-label"></label>

                    <div class="col-sm-8">
                        <button type="button" id="submit_password_Q" class="btn btn-success">保存密保问题</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
</script>