<html>
<head>
    <title>修改顾客</title>
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
                    <small>修改顾客信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="userForm">
        <input type="hidden" name="userId" value="${user.userId}"/>
        <input type="hidden" name="userName" value="${user.userName}"/>
        顾客密码：<input type="text" name="userPwd" value="${user.userPwd}"/>
        顾客邮箱：<input type="text" name="userEmail" value="${user.userEmail}"/>
        顾客电话：<input type="text" name="userTel" value="${user.userTel}"/>
        顾客地址：<input type="text" name="userAddress" value="${user.userAddress}"/>
        <input type="button" value="提交" onclick="updateUser()"/>
    </form>
    <script type="text/javascript">
        function updateUser(){
            var form = document.forms[0];
            form.action = "/user/updateUser";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
