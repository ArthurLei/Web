<%@ page import="dao.Bookcon" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/19
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
   String bookd=request.getParameter("bookid");
    Bookcon bookcon=new Bookcon();
   boolean Flag= bookcon.deleteBook(bookd);
   if (Flag){
       response.sendRedirect("./BookList.jsp");
   }
   else {
       out.print("下架失败！");
   }
%>
</body>
</html>
