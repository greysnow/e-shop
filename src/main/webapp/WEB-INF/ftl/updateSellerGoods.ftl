<html>
<head>
    <title>修改商品</title>
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

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改商品</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="userForm">
        <input type="hidden" name="goodsId" value="${goods.goodsId}"/>
        <input type="hidden" name="sellerId" value="${goods.sellerId}">
        商品名称：<input type="text" name="goodsName" value="${goods.goodsName}"/>
        商品品牌：<input type="text" name="goodsBrand" value="${goods.goodsBrand}"/>
        商品类型：<input type="text" name="goodsType" value="${goods.goodsType}"/>
        男女款式：<input type="text" name="goodsFor" value="${goods.goodsFor}"/>
        库存数量：<input type="text" name="goodsStock" value="${goods.goodsStock}"/>
        <input type="hidden" name="goodsSales" value="${goods.goodsSales}"/>
        商品价格：<input type="text" name="goodsPrice" value="${goods.goodsPrice}"/>
        <input type="button" value="提交" onclick="updateSellerGoods()"/>
    </form>
    <script type="text/javascript">
        function updateSellerGoods(){
            var form = document.forms[0];
            form.action = "/goods/updateSellerGoods";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
