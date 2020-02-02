<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/12
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .tab{
        font-size: x-large;
    }
</style>
<head>
    <title>登录成功</title>
</head>
<body bgcolor="#afeeee">
<%
   String S=(String)session.getAttribute("username");
%>
<%
   // out.print(S);
%>
<jsp:useBean class="bean.Book" id="book" scope="page"  ></jsp:useBean>
<%
if(session.getAttribute("username")==null||"".equals(session.getAttribute("username")))
{%>
<h1 align="center">请先登录！然后在选书！</h1>
<h2 align="center"><a href="login/login.jsp">登录</a></h2>
  <%
}
else {
%>
<br><br>
<h1 align="center">欢迎用户<%out.print(S);%>来到书店</h1>
<br><br><br>
<table width="60%" border="1"cellpadding="0"  bordercolor="#9999FF" align="center" class="tab">
    <tr>
        <td><font color="#528b8b">索书号</font> </td>
        <td><font color="#528b8b">书名</font> </td>
        <td><font color="#528b8b">作者</font> </td>
        <td><font color="#528b8b">价格</font> </td>
<%--        <td><font color="#afeeee">书名</font> </td>--%>
        <td>&nbsp;</td>
    </tr>
    <%
        ResultSet rs=book.getBookList();
        while (rs.next())
        {

                String bookid=rs.getString("bookid");

    %>
    <tr>
        <td><%=rs.getString("bookid")%></td>
        <td><a href="bookinfo.jsp?bookid=<%=bookid%>"><%=rs.getString("bookname")%></a></td>
        <td><%=rs.getString("author")%></td>
        <td><%=rs.getString("price")%></td>
        <td><a href="ShoppinTroll.jsp?bookid=<%=bookid%>">加入购物车</a></td>
    </tr>



   <%}}%>
</table>
<a href="ShoppingCart.jsp"><h2 align="center">查看购物车</h2></a>
</body>
</html>
