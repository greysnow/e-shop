<%--
  Created by IntelliJ IDEA.
  User: yinixie
  Date: 2019/3/27
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>卖家商品列表</title>
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
                    <small>商品列表 —— 显示所有卖家所有商品</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/goods/toAddGoods">新增</a>
            <form action="" name="userForm">
                商品名称：
                <input type="text" name="customerId" value="${goods.goodsName}"/>
                <input type="button" value="搜索" onclick="selectGoodsName()"/>
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>商品编号</th>
                    <th>卖家名称</th>
                    <th>商品名称</th>
                    <th>商品类型</th>
                    <th>男女款式</th>
                    <th>库存数量</th>
                    <th>商品价格</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="goods" items="${requestScope.get('list')}" varStatus="status">
                    <tr>
                        <td>${goods.goodsId}</td>
                        <td>${goods.sellerName}</td>
                        <td>${goods.goodsName}</td>
                        <td>${goods.goodsType}</td>
                        <td>${goods.goodsFor}</td>
                        <td>${goods.goodsNumber}</td>
                        <td>${goods.goodsPrice}</td>
                        <td>
                            <a href="${path}/goods/toUpdateGoods?id=${goods.goodsId}">更改</a> |
                            <a href="<%=appPath%>/goods/del/${goods.goodsId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectGoodsName() {
            var form = document.forms[0];
            form.action = "/goods/selectGoodsName";
            form.method = "post";
            form.submit();
        }
    </script>context
</div>
