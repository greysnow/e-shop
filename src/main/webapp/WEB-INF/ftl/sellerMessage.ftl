<html>
<head>
    <title>卖家信息</title>
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
                    <small>卖家列表</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>卖家编号</th>
                    <th>卖家名字</th>
                    <th>卖家密码</th>
                    <th>卖家邮箱</th>
                    <th>卖家电话</th>
                    <th>卖家地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${seller.sellerId}</td>
                    <td>${seller.sellerName}</td>
                    <td>${seller.sellerPwd}</td>
                    <td>${seller.sellerEmail}</td>
                    <td>${seller.sellerTel}</td>
                    <td>${seller.sellerAddress}</td>
                    <td>
                        <a href="/seller/toUpdateSeller?sellerId=${seller.sellerId}">修改</a>
                        <a href="/seller/del/${seller.sellerId}">注销</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
