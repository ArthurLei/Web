<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/18
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="book" class="bean.Book" scope="page"></jsp:useBean>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
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
        <td><a href="bookinfo1.jsp?bookid=<%=bookid%>"><%=rs.getString("bookname")%></a></td>
        <td><%=rs.getString("author")%></td>
        <td><%=rs.getString("price")%></td>
        <td><a href="deleteBook.jsp?bookid=<%=bookid%>">图书下架</a></td>
    </tr>
    <%}%>
</table>
<h1 align="center"><a href="AddBooks.jsp">添加新书</a></h1>
<h2 align="center"><a href="RootSuccess.jsp">返回管理员首页</a></h2>
</body>
</html>
