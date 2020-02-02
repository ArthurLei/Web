<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/18
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内网管理员</title>
</head>
<body>
<form name="frm" action="${pageContext.request.contextPath}/servlet/Roots" method ="post">
    <p align="center">
        <input type="text" name="username" placeholder="Username">
    </p>
    <p align="center">
        <input type="password" name="password" placeholder="Password">
    </p>
    <p align="center">
        <button type="submit">登录</button>
    </p>
</form>
</body>
</html>
