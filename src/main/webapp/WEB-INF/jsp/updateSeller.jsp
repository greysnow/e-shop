<%--
  Created by IntelliJ IDEA.
  User: yinixie
  Date: 2019/3/28
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>修改卖家</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改顾客</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="userForm">
        <input type="hidden" name="sellerName" value="${user.sellerName}"/>
        卖家密码：<input type="text" name="sellerPassword" value="${user.sellerPassword}"/>
        <input type="hidden" name="sellerEmail" value="${user.sellerEmail}"/>
        卖家电话：<input type="text" name="sellerTel" value="${user.sellerTel}"/>
        卖家地址：<input type="text" name="sellerAddress" value="${user.sellerAddress}"/>
        <input type="button" value="提交" onclick="updateSeller()"/>
    </form>
    <script type="text/javascript">
        function updateSeller(){
            var form = document.forms[0];
            form.action = "<%=basePath %>user/updateSeller";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
