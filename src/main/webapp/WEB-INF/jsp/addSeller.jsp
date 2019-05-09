<%--
  Created by IntelliJ IDEA.
  User: yinixie
  Date: 2019/3/27
  Time: 12:14
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
    <title>新增卖家</title>
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
                    <small>新增卖家</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        卖家名称：<input type="text" name="sellerName"><br><br><br>
        卖家密码：<input type="text" name="sellerPassword"><br><br><br>
        卖家邮箱：<input type="text" name="sellerEmail"><br><br><br>
        卖家电话：<input type="text" name="sellerTel"><br><br><br>
        卖家地址：<input type="text" name="sellerAddress"><br><br><br>
        <input type="button" value="注册" onclick="addSeller()">
    </form>

    <script type="text/javascript">
        function addSeller() {
            var form = document.forms[0];
            form.action = "<%=basePath %>user/addSeller";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
