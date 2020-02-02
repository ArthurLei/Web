<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/19
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="">新增图书</h2>
<h4 align="">输入图书信息:</h4>

<form action="${pageContext.request.contextPath}/servlet/BookAdd" method="post"  enctype="multipart/form-data" >
<%--    enctype="multipart/form-data"--%>
    <table width="100%" border="0">
        <tr>
            <td width="30"><font color="#ffa07a"> 索书号</font></td>
            <td width="70"><input type="text" name="BookID" size="20" maxlength="10"></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> 书名</font></td>
            <td width="70"><input type="text" name="Bookname" size="20"></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> 作者</font></td>
            <td width="70"><input type="text" name="author" size="20" ></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> 价格</font></td>
            <td width="70"><input type="text" id="price" name="price" size="20" maxlength="60"></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> 介绍</font></td>
            <td width="70"><textarea name="intro" cols="60" rows="6"></textarea></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> 选择照片</font></td>
            <td width="70"><input type="file" name="file" size="40" maxlength="40"></td>
        </tr>
        <tr>
            <td width="30"><font color="#ffa07a"> </font></td>
            <td width="70"><input type="submit" name="Sumbt" value="提交">${msg}</td>
        </tr>

    </table></form>
<h2 align="center"><a href="BookList.jsp">返回图书列表</a></h2>
<h2 align="center"><a href="RootSuccess.jsp">返回管理员首页</a></h2>
</body>
</html>
