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
<br>

<div>
<form class="form-horizontal" role="form" id="form_userinfo_setting_home">
    <div class="form-group">
        <label for="alias_Name" class="col-sm-2 control-label">用户名</label>

        <div class="col-sm-8">
            <input type="password" class="form-control" id="alias_Name" placeholder="用户名">
        </div>
    </div>
    <div class="form-group">
        <label for="sex1" class="col-sm-2 control-label">性别</label>

        <div class="col-sm-8">
            <label class="radio-inline">
                <input type="radio" name="sex" id="sex1" value="0"> 男
            </label>
            <label class="radio-inline">
                <input type="radio" name="sex" id="sex2" value="1" checked> 女
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="birthday_year" class="col-sm-2 control-label">生日</label>

        <div class="col-sm-8">
            <select id="birthday_year" style="display:inline-block ;width: 150px">
                <option value="1970">1970</option>
                <option value="1971">1971</option>
                <option value="1972">1972</option>
                <option value="1973">1973</option>
                <option value="1974">1974</option>
                <option value="1975">1975</option>
                <option value="1976">1976</option>
                <option value="1977">1977</option>
                <option value="1978">1970</option>
                <option value="1979">1970</option>
                <option value="1980">1980</option>
                <option value="1981">1981</option>
                <option value="1982">1982</option>
                <option value="1983">1983</option>
                <option value="1984">1984</option>
                <option value="1985">1985</option>
                <option value="1986">1986</option>
                <option value="1987">1987</option>
                <option value="1988">1988</option>
                <option value="1989">1989</option>
                <option value="1990" selected>1990</option>
                <option value="1991">1991</option>
                <option value="1992">1992</option>
                <option value="1993">1993</option>
                <option value="1994">1994</option>
                <option value="1995">1995</option>
                <option value="1996">1996</option>
                <option value="1997">1997</option>
                <option value="1998">1998</option>
                <option value="1999">1999</option>
                <option value="2000">2000</option>
                <option value="2001">2001</option>
                <option value="2002">2002</option>
                <option value="2003">2003</option>
                <option value="2004">2004</option>
                <option value="2005">2005</option>
                <option value="2006">2006</option>
                <option value="2007">2007</option>
                <option value="2008">2008</option>
                <option value="2009">2009</option>
                <option value="2010">2010</option>
                <option value="2011">2011</option>
            </select>
            &nbsp;
            <select id="birthday_mouth" style="width: 150px">
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06" selected>06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>
            &nbsp;
            <select id="birthday_day" style="width: 150px">
                <option value="01">01</option>
                <option value="02">02</option>
                <option value="03">03</option>
                <option value="04">04</option>
                <option value="05">05</option>
                <option value="06">06</option>
                <option value="07">07</option>
                <option value="08">08</option>
                <option value="09">09</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15" selected>15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label for="area_Id" class="col-sm-2 control-label">所在地</label>

        <div class="col-sm-8">
            <select id="province_Id" class="" style="display:inline-block ;width: 150px">
                <option value="-1">所在省</option>
                <option value="1">我的父亲的名字是？</option>
                <option value="2">我的母亲的名字是？</option>
                <option value="3">我的妹妹的名字是？</option>
                <option value="4">我的弟弟的名字是？</option>
            </select>
            &nbsp;
            <select id="city_Id" style="width: 150px">
                <option value="-1">所在市</option>
                <option value="1">我的小学学校名字是？</option>
                <option value="2">我的初中学校名字是？</option>
                <option value="3">我的高中学校名字是？</option>
                <option value="4">我的大学学校名字是？</option>
            </select>
            &nbsp;
            <select id="area_Id" style="width: 150px">
                <option value="-1">所在地区</option>
                <option value="1">我的第一个公司名字是？</option>
                <option value="2">我配偶的名字是？</option>
                <option value="3">我初恋的名字是？</option>
                <option value="4">我的名字是？</option>
            </select>
            &nbsp;
            <span class="label label-info" style="cursor: hand">地图定位</span>
            <span class="label label-warning" style="cursor: hand">IP自动定位</span>
            //http://api.map.baidu.com/location/ip?ak=EFfee49fcb850d465bd2d2d26b30b050
        </div>
    </div>
    <div class="form-group">
        <label for="school" class="col-sm-2 control-label">学校</label>

        <div class="col-sm-8">
            <input type="password" class="form-control" id="school" placeholder="学校">
        </div>
    </div>
    <div class="form-group">
        <label for="love_State1" class="col-sm-2 control-label">恋爱状态</label>

        <div class="col-sm-8">
            <label class="radio-inline">
                <input type="radio" name="love_State" id="love_State1" value="0" checked> 单身
            </label>
            <label class="radio-inline">
                <input type="radio" name="love_State" id="love_State2" value="1"> 热恋
            </label>
            <label class="radio-inline">
                <input type="radio" name="love_State" id="love_State3" value="2"> 已婚
            </label>
            <label class="radio-inline">
                <input type="radio" name="love_State" id="love_State4" value="3"> 离异
            </label>
        </div>
    </div>
    <div class="form-group">
        <label for="explain" class="col-sm-2 control-label">个人说明</label>

        <div class="col-sm-8">
            <textarea class="form-control" id="explain" rows="2"></textarea>
        </div>
    </div>

    <div class="form-group">
        <label for="submit_userinfo_setting_home" class="col-sm-2 control-label"></label>

        <div class="col-sm-8">
            <button type="button" id="submit_userinfo_setting_home" class="btn btn-success">保存基本信息</button>
        </div>
    </div>
</form>
</div>
<script>
    $(function () {

    });
</script>