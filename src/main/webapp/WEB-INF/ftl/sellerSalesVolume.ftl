<html>
<head>
    <title>卖家销售量列表</title>
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
                    运动鞋销售管理系统
                </h1>
            </div>
        </div>
    </div>
    <tr>
        <a href="/order/allSellerOrder?sellerId=${sellerId}">卖家订单</a>
    </tr>
    <tr>
        <a href="/goods/allSellerGoods?sellerId=${sellerId}">卖家商品</a>
    </tr>
    <tr>
        <a href="/sellerSales/sellerSalesVolume?sellerId=${sellerId}">卖家销量</a>
    </tr>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>销售量列表</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <td><a class="btn btn-primary" href="/sellerSales/toSellerPredict?sellerId=${sellerId}">前往销量预测</a></td>
            <form action="" name="userForm">
                <input type="hidden" name="sellerId" value="${sellerId}"/>
                商品名称：
                <input type="text" name="goodsName" value=""/>
                <input type="button" value="搜索" onclick="selectGoodsName()"/>
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>销售量编号</th>
                    <th>商品名称</th>
                    <th>日期</th>
                    <th>销售量</th>
                </tr>
                </thead>
                <tbody>
                <#list list as sellerSales>
                <tr>
                    <td>${sellerSales.sellerSalesId}</td>
                    <td>${sellerSales.goodsName}</td>
                    <td>${sellerSales.orderDate}</td>
                    <td>${sellerSales.quantity}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectGoodsName() {
            var form = document.forms[0];
            form.action = "/sellerSales/queryByGoodsName";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
