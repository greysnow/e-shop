<html>
<head>
    <title>品牌销售量列表</title>
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
                    <small>销售量列表</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <td><a class="btn btn-primary" href="/sales/toPredict">前往销量预测</a></td>
            <form action="" name="userForm">
                商品品牌：
                <input type="text" name="goodsBrand" value="${sales.goodsBrand}"/>
                <input type="button" value="搜索" onclick="selectGoodsBrand()"/>
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>销售量编号</th>
                    <th>商品品牌</th>
                    <th>日期</th>
                    <th>销售量</th>
                </tr>
                </thead>
                <tbody>
                <#list list as sales>
                <tr>
                    <td>${sales.salesId}</td>
                    <td>${sales.goodsBrand}</td>
                    <td>${sales.orderDate}</td>
                    <td>${sales.quantity}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectGoodsBrand() {
            var form = document.forms[0];
            form.action = "/sales/queryByGoodsBrand";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
