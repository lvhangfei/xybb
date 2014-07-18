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

<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    修改密码
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in">
            <div class="panel-body">
                <form class="form-horizontal" role="form" id="form_password">
                    <div class="form-group">
                        <label for="password_old" class="col-sm-2 control-label">原始密码</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password_old" placeholder="原始密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password_new" class="col-sm-2 control-label">新密码</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password_new" placeholder="新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password_new_1" class="col-sm-2 control-label">确认新密码</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password_new_1" placeholder="再次输入新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="submit_password_Email" class="col-sm-2 control-label"></label>

                        <div class="col-sm-8">
                            <button type="button" id="submit_password" class="btn btn-success">更新密码</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                    找回密码邮箱
                </a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse">
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
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                    密保问题
                </a>
            </h4>
        </div>
        <div id="collapseThree" class="panel-collapse collapse">
            <div class="panel-body">
                <form class="form-horizontal" role="form" id="form_password_Q">
                    <div class="form-group">
                        <label for="password_password_Q" class="col-sm-2 control-label">账号密码</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="password_password_Q" placeholder="账号密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="question_1" class="col-sm-2 control-label">密保问题一</label>

                        <div class="col-sm-6">
                            <select class="form-control" id="question_1">
                                <option value="1">我父亲的名字是？</option>
                                <option value="2">我母亲的名字是？</option>
                                <option value="3">我妹妹的名字是？</option>
                                <option value="4">我弟弟的名字是？</option>
                                <option value="5">我配偶的名字是？</option>
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
                                <option value="1">我父亲的生日是？</option>
                                <option value="2">我母亲的生日是？</option>
                                <option value="3">我妹妹的生日是？</option>
                                <option value="4">我弟弟的生日是？</option>
                                <option value="5">我配偶的生日是？</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="answer_2" class="col-sm-2 control-label">密保答案二</label>

                        <div class="col-sm-6">
                            <input type="password" class="form-control" id="answer_2"
                                   placeholder="密保答案二(建议格式为yyyy-mm-dd)">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="question_3" class="col-sm-2 control-label">密保问题三</label>

                        <div class="col-sm-6">
                            <select class="form-control" id="question_3">
                                <option value="1">我的小学学校名字是？</option>
                                <option value="2">我的初中学校名字是？</option>
                                <option value="3">我的高中学校名字是？</option>
                                <option value="4">我的大学学校名字是？</option>
                                <option value="5">我的第一个公司名字是？</option>
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
</div>
<script>
</script>