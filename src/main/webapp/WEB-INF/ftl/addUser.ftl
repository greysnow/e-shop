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
                    顾客注册
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增顾客</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        顾客名称：<input type="text" name="userName"><br><br><br>
        顾客密码：<input type="text" name="userPwd"><br><br><br>
        顾客邮箱：<input type="text" name="userEmail"><br><br><br>
        顾客电话：<input type="text" name="userTel"><br><br><br>
        顾客地址：<input type="text" name="userAddress"><br><br><br>
        <input type="button" value="注册" onclick="addUser()">
    </form>

    <script type="text/javascript">
        function addUser() {
            var form = document.forms[0];
            form.action = "/user/addUser";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
