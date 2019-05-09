<html>
<head>
    <title>新增订单</title>
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
                    <small>购买</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        <input hidden type="text" name="goodsId" value="${goodsId}"/>
        <div>名称：${goodsDTO.goods.goodsName}</div>
        <div>
            图片：<img src="/images/1.jpg" width="270" height="217"/>
        </div>
        <div>
            详情：
            <p>本款运动鞋轻薄透气，很适合休闲人群。</p>
            <p>相信会给您带来别致的体验。</p>
        </div>
        数量：<input type="text" name="quantity"><br><br><br>
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