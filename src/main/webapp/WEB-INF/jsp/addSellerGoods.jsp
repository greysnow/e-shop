<%--
  Created by IntelliJ IDEA.
  User: yinixie
  Date: 2019/3/27
  Time: 12:34
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
    <title>新增顾客</title>
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
                    <small>新增顾客</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        卖家名称：<input type="text" name="sellerName"><br><br><br>
        商品名称：<input type="text" name="goodsName"><br><br><br>
        商品种类：<input type="text" name="goodsType"><br><br><br>
        男女款式：<input type="text" name="goodsFor"><br><br><br>
        库存数量：<input type="text" name="goodsNumber"><br><br><br>
        商品价格：<input type="text" name="goodsPrice"><br><br><br>
        <input type="button" value="添加" onclick="addGoods()">
    </form>

    <script type="text/javascript">
        function addGoods() {
            var form = document.forms[0];
            form.action = "<%=basePath %>goods/addGoods";
            form.method = "post";
            form.submit();
        }
    </script>
</div>

