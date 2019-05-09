<html>
<head>
    <title>顾客信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h3>
                    运动鞋销售管理系统
                </h3>
                <h4>
                    <p align="right">
                        你好！${user.userName}
                        <a href="/user/login">退出</a>
                    </p>
                </h4>

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
                    <small>用户信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>用户编号</th>
                    <th>用户名字</th>
                    <th>用户密码</th>
                    <th>用户邮箱</th>
                    <th>用户电话</th>
                    <th>用户地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.userPwd}</td>
                    <td>${user.userEmail}</td>
                    <td>${user.userTel}</td>
                    <td>${user.userAddress}</td>
                    <td>
                        <a href="/user/toUpdateUser?userId=${user.userId}">修改</a>
                        <a href="/user/del/${user.userId}">注销</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
