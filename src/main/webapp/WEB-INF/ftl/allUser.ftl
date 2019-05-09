<html>
<head>
    <title>顾客列表</title>
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
                    <small>用户列表 —— 显示所有用户 </small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <form action="" name="userForm">
                用户Id：
                <input type="text" name="userId" value="${user.userId}"/>
                <input type="button" value="搜索" onclick="selectUserId()"/>
            </form>
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
                </tr>
                </thead>
                <tbody>
                <#list list as user>
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.userName}</td>
                        <td>${user.userPwd}</td>
                        <td>${user.userEmail}</td>
                        <td>${user.userTel}</td>
                        <td>${user.userAddress}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function selectUserId() {
            var form = document.forms[0];
            form.action = "/user/selectUserId";
            form.method = "post";
            form.submit();
        }
    </script>
</div>