<html>
<head>
    <title>管理员端商品列表</title>
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
                    <small>商品列表 —— 显示所有商品</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <form action="" name="userForm">
                商品名称：
                <input type="text" name="goodsName" value="${goodsDTO.goods.goodsName}"/>
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
                    <th>商品品牌</th>
                    <th>商品类型</th>
                    <th>男女款式</th>
                    <th>库存数量</th>
                    <th>销售总量</th>
                    <th>商品价格</th>
                </tr>
                </thead>
                <tbody>
                <#list list as goodsDTO>
                    <tr>
                        <td>${goodsDTO.goods.goodsId}</td>
                        <td>${goodsDTO.sellerName}</td>
                        <td>${goodsDTO.goods.goodsName}</td>
                        <td>${goodsDTO.goods.goodsBrand}</td>
                        <td>${goodsDTO.goods.goodsType}</td>
                        <td>${goodsDTO.goods.goodsFor}</td>
                        <td>${goodsDTO.goods.goodsStock}</td>
                        <td>${goodsDTO.goods.goodsSales}</td>
                        <td>${goodsDTO.goods.goodsPrice}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectGoodsName() {
            var form = document.forms[0];
            form.action = "/goods/selectGoodsNameAdminVer";
            form.method = "post";
            form.submit();
        }
    </script>context
</div>