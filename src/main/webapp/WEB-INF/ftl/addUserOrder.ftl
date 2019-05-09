<html>
<head>
    <title>新增顾客</title>
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
                    <small>新增订单</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="orderForm">
        <input type="hidden" name="orderId">
        <input type="hidden" name="userId">
        <input type="hidden" name="goodsId">
        <input type="hidden" name="orderDate">
        数量：<input type="text" name="quantity"><br><br><br>
        <input type="hidden" name="total">
        <input type="button" value="添加" onclick="addOrder()">
    </form>

    <script type="text/javascript">
        function addOrder() {
            var form = document.forms[0];
            form.action = "/order/addOrder";
            form.method = "post";
            form.submit();
        }
    </script>
</div>