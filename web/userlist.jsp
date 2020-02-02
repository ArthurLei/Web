<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/18
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="bean.Tuser" scope="page"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="60%" border="1"cellpadding="0"  bordercolor="#9999FF" align="center" class="tab">
    <tr>
        <td><font color="#528b8b">用户名</font> </td>
        <td><font color="#528b8b">密码</font> </td>
        <td><font color="#528b8b">邮箱</font> </td>
        <td>&nbsp;</td>
    </tr>
    <%
        ResultSet rs=user.getuserList();
        while (rs.next())
        {

    %>
    <tr>
        <td><%=rs.getString("username")%></td>
        <td><%=rs.getString("password")%></td>
        <td><%=rs.getString("email")%></td>
<%--        <td><a href="ShoppinTroll.jsp?bookid=<%=bookid%>">加入购物车</a></td>--%>
    </tr>



    <%}%>
</table>
<h2 align="center"><a href="RootSuccess.jsp">返回管理员首页</a></h2>
</body>
</html>
