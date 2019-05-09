<html>
<head>
    <title>新增商品</title>
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
                    <small>新增商品</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="goodsForm">
        <input hidden type="text" name="sellerId" value="${sellerId}"/>
        商品名称：<input type="text" name="goodsName"><br><br><br>
        商品品牌：<input type="text" name="goodsBrand"><br><br><br>
        商品种类：<input type="text" name="goodsType"><br><br><br>
        男女款式：<input type="text" name="goodsFor"><br><br><br>
        库存数量：<input type="text" name="goodsStock"><br><br><br>
        商品价格：<input type="text" name="goodsPrice"><br><br><br>
        <input type="button" value="添加" onclick="addGoods()">
    </form>

    <script type="text/javascript">
        function addGoods() {
            var form = document.forms[0];
            form.action = "/goods/addGoods";
            form.method = "post";
            form.submit();
        }
    </script>
</div>

