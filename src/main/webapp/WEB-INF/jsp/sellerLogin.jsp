<%--
  Created by IntelliJ IDEA.
  User: yinixie
  Date: 2019/3/27
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>买家登录界面</title>
    <link rel="stylesheet" type="text/css"
          href="introduce/easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="introduce/easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css"
          href="introduce/easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css"
          href="introduce/easyui-1.5.2/themes/demo.css">
    <script type="text/javascript" src="introduce/easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript"
            src="introduce/easyui-1.5.2/jquery.easyui.min.js"></script>

    <style type="text/css">
        .login {
            position: absolute;
            width: 1024px;
            height: 480px;
            left: 50%;
            top: 50%;
            margin-left: -512px;
            margin-top: -240px;
            border: 1px solid #00F;
            color: #ffffff;
            background-image: url("./img/login.jpg");
            font-size: 16px;
        }

        .button {
            display: inline-block;
            zoom: 1; /* zoom and *display = ie7 hack for display:inline-block */
            *display: inline;
            vertical-align: baseline;
            margin: 0 2px;
            outline: none;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            font: 14px/100% Arial, Helvetica, sans-serif;
            padding: .5em 2em .55em;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
            -webkit-border-radius: .5em;
            -moz-border-radius: .5em;
            border-radius: .5em;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
        }

        .button:hover {
            text-decoration: none;
        }

        .button:active {
            position: relative;
            top: 1px;
        }
    </style>
    <script type="text/javascript">



        $(function(){
            $(document).keyup(function(event){
                if(event.keyCode==13){
                    login1();
                }
            });

            $('#sellerName').textbox('setValue',"${cookie.sellerName.value}");


        });

        function login1(){
            if($('#sellerName').val()==""){
                $.messager.alert('提示','用户名不能为空！');
                return;
            }

            if($('#sellerPassword').val()==""){
                $.messager.alert('提示','密码不能为空！');
                return;
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/user/login.action',
                data:$('#fm').serialize(),
                type:'post',
                success:function(map){
                    if(map.msg=="1"){
                        window.self.location='jsp/index.jsp';

                    }else{
                        $.messager.alert('提示','登陆失败，'+map.msg);
                    }
                },
                error:function(xhr,status,error){
                    $.messager.alert('提示',xhr.responseText);
                }

            });
        }

    </script>
</head>
<body style="background-color: #ccccaa;">
<div class="login">
    <form id="fm">
        <div style="position: fixed; margin-top: 260px; margin-left: 320px;">
            <div style="height: 50px;">
                <input type="text" class="easyui-textbox" label="用户：" style="width: 100%" id="sellerName" name="sellerName" >
            </div>
            <div style="height: 50px;">
                <input type="password" class="easyui-textbox"  label="密码："  style="width: 100%"  id=sellerPassword"
                       name="sellerPassword">
            </div>

            <div style="height: 50px; text-align: center; font-size: 16px;">

                <a href="javascript:void(0)" class="easyui-linkbutton c1" style="font-size: 16px;width: 80px; height: 30px;"
                   onclick="login1()" style="width: 90px">登&nbsp;&nbsp;陆</a>

            </div>
        </div>
    </form>
</div>
