<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/19
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/FindPassword" method="post">
    <table align="center">
        <tr>
            <td width="30"><font color="#ffa07a">用户名</font></td>
            <td width="70"><input type="text" name="username" size="20"></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a">邮箱</font></td>
            <td width="70"><input type="text" name="email" size="20"></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> </font></td>
            <td width="70"><input type="submit" name="Sumbt" value="提交"></td>
        </tr>
    </table>
</form>
<h2 align="center"><a href="login/login.jsp">返回登录</a></h2>
</body>
</html>
