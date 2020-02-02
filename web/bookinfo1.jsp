<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/18
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .photo{
        float:left;
        width:30%;
    }
    .word{
        float:right;
        width:60%; /*background-color: aquamarine*/
    }
    pre{
        font-size: x-large;
    }
    /*h3{*/
    /*    font-size: x-large;*/
    /*}*/
</style>
<head>
    <title>Title</title>
</head>
<body>
<body bgcolor="#afeeee">
<jsp:useBean id="Book" class="bean.Book" scope="page"></jsp:useBean>
<%
    // String path = request.getContextPath();
    //String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String bookid = request.getParameter("bookid");//用request得到 
    Book.setBookid(bookid);
    // out.print(basePath+"    ");
    // out.print(name);
    String path=bookid+".jpg";
    String bookname=Book.getBookname();
    String author=Book.getAuthor();
    String price=Book.getPrice();
    String infor=Book.getIntro();
%> 

<div class="bookinfo">
    <div class="photo">
        <br>
        <img src="resources/<%=path%>" width="500" height="700">
    </div>
    <div class="word">
        <br><br><br><br>
        <h1 align="center"><%out.print(bookname);%></h1>
        <h2 align="center"><%out.print(author);%></h2>
        <h3> <%=infor%></h3><br>
    </div>
</div>
</body>
</body>
</html>
