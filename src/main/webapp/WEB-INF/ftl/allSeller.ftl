<html>
<head>
    <title>卖家列表</title>
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
                    <small>卖家列表 —— 显示所有卖家 </small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <form action="" name="userForm">
                卖家Id：
                <input type="text" name="sellerId" value="${seller.sellerId}"/>
                <input type="button" value="搜索" onclick="selectSellerId()"/>
            </form>
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
                </tr>
                </thead>
                <tbody>
                <#list list as seller>
                    <tr>
                        <td>${seller.sellerId}</td>
                        <td>${seller.sellerName}</td>
                        <td>${seller.sellerPwd}</td>
                        <td>${seller.sellerEmail}</td>
                        <td>${seller.sellerTel}</td>
                        <td>${seller.sellerAddress}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectSellerId() {
            var form = document.forms[0];
            form.action = "/seller/selectSellerId";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
