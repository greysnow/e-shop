<html>
<head>
    <title>修改卖家</title>
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
                    <small>修改卖家信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="" name="sellerForm">
        <input type="hidden" name="sellerId" value="${seller.sellerId}"/>
        <input type="hidden" name="sellerName" value="${seller.sellerName}"/>
        卖家密码：<input type="text" name="sellerPwd" value="${seller.sellerPwd}"/>
        卖家邮箱：<input type="text" name="sellerEmail" value="${seller.sellerEmail}"/>
        卖家电话：<input type="text" name="sellerTel" value="${seller.sellerTel}"/>
        卖家地址：<input type="text" name="sellerAddress" value="${seller.sellerAddress}"/>
        <input type="button" value="提交" onclick="updateSeller()"/>
    </form>
    <script type="text/javascript">
        function updateSeller(){
            var form = document.forms[0];
            form.action = "/seller/updateSeller";
            form.method = "post";
            form.submit();
        }
    </script>
</div>