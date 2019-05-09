<html>
<head>
    <title>新增卖家</title>
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
                    卖家注册
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增卖家</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="" name="userForm">
        卖家名称：<input type="text" name="sellerName"><br><br><br>
        卖家密码：<input type="text" name="sellerPwd"><br><br><br>
        卖家邮箱：<input type="text" name="sellerEmail"><br><br><br>
        卖家电话：<input type="text" name="sellerTel"><br><br><br>
        卖家地址：<input type="text" name="sellerAddress"><br><br><br>
        <input type="button" value="注册" onclick="addSeller()">
    </form>

    <script type="text/javascript">
        function addSeller() {
            var form = document.forms[0];
            form.action = "/seller/addSeller";
            form.method = "post";
            form.submit();
        }
    </script>
</div>
