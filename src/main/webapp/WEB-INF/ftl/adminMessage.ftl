<html>
<head>
    <title>管理员信息</title>
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
    <a href="/user/allUser">查看用户</a>
    <a href="/seller/allSeller">查看卖家</a>
    <a href="/goods/allGoodsAdminVer">查看商品</a>
    <a href="/order/allOrder">查看订单</a>
    <a href="/sales/allSalesVolume">查看销量情况</a>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>管理员信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>管理员编号</th>
                    <th>管理员名字</th>
                    <th>管理员密码</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${admin.adminId}</td>
                        <td>${admin.adminName}</td>
                        <td>${admin.adminPwd}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
