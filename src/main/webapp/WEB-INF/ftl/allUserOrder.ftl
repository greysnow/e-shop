<html>
<head>
    <title>卖家订单列表</title>
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
        <a href="/order/allUserOrder?userId=${userId}">顾客订单</a>
    </tr>
    <tr>
        <a href="/goods/allGoods?userId=${userId}">所有商品</a>
    </tr>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>买家订单</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>买家名称</th>
                    <th>卖家名称</th>
                    <th>商品名称</th>
                    <th>订单日期</th>
                    <th>订单数量</th>
                    <th>订单总额</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list list as orderDTO>
                    <tr>
                        <td>${orderDTO.order.orderId}</td>
                        <td>${orderDTO.userName}</td>
                        <td>${orderDTO.sellerName}</td>
                        <td>${orderDTO.goodsName}</td>
                        <td>${orderDTO.order.orderDate?string('yyyy-MM-dd')}</td>
                        <td>${orderDTO.order.quantity}</td>
                        <td>${orderDTO.order.total}</td>
                        <td>
                            <a href="/order/del?orderId=${orderDTO.order.orderId}">删除</a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
