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
                    <small>商品列表 —— 显示所有商品</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="/goods/toAddGoods?sellerId=${sellerId}">新增</a>
            <form action="" name="userForm">
                <input type="hidden" name="sellerId" value="${sellerId}"/>
                商品名称：
                <input type="text" name="goodsName" value=""/>
                <input type="button" value="搜索" onclick="selectSellerGoodsName()"/>
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>商品编号</th>
                    <th>商品名称</th>
                    <th>商品品牌</th>
                    <th>商品类型</th>
                    <th>男女款式</th>
                    <th>库存数量</th>
                    <th>销售总量</th>
                    <th>商品价格</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list list as goodsDTO>
                    <tr>
                        <td>${goodsDTO.goods.goodsId}</td>
                        <td>${goodsDTO.goods.goodsName}</td>
                        <td>${goodsDTO.goods.goodsBrand}</td>
                        <td>${goodsDTO.goods.goodsType}</td>
                        <td>${goodsDTO.goods.goodsFor}</td>
                        <td>${goodsDTO.goods.goodsStock}</td>
                        <td>${goodsDTO.goods.goodsSales}</td>
                        <td>${goodsDTO.goods.goodsPrice}</td>
                        <td>
                            <a href = "/goods/toUpdateSellerGoods?goodsId=${goodsDTO.goods.goodsId}">更改</a>
                            <a href = "/goods/del?goodsId=${goodsDTO.goods.goodsId}">删除</a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectSellerGoodsName() {
            var form = document.forms[0];
            form.action = "/goods/selectSellerGoodsName";
            form.method = "get";
            form.submit();
        }
    </script>
</div>
