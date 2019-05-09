<%--
  Created by IntelliJ IDEA.
  User: yinixie
  Date: 2019/3/27
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>

<form action="${path}/seller/checkLogin" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input id="customerName" name="customerName" type="text"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input id="customerPassword" name="customerPassword" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>