<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/17
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="bookinfo" class="bean.Book" scope="page"></jsp:useBean>
<%
//    response.setHeader("Pragma","No-cache");
//    response.setHeader("Cache-Control","no-cache");
//    response.setDateHeader("Expires",0);

//    Cookie[] cookies=request.getCookies();
//    for(int i=0;i<cookies.length;i++)
//    {
//        if(request.getParameter("bookid")==cookies[i].getName())
//        {
//            int x=Integer.parseInt(cookies[i].getValue())+1;
//            cookies[i].setValue("5");
//            System.out.print(x);
//            System.out.print(cookies[i].getValue());
//        }
//
//    }
%>
<html>
<style>
    .tab{
        font-size: x-large;
    }

</style>
<head>
    <title>购物车</title>
</head>
<body>
<form>
<table width="60%" border="1"cellpadding="0"  bordercolor="#9999FF" align="center" class="tab">
    <tr>
        <td><font color="#528b8b">索书号</font> </td>
        <td><font color="#528b8b">书名</font> </td>
        <td><font color="#528b8b">单价</font> </td>
        <td><font color="#528b8b">数量</font> </td>
        <td>&nbsp;</td>
    </tr>
<%
    Cookie[] cookies=request.getCookies();
   // int money=0;
    for(int i=0;i<cookies.length;i++)
    {
        cookies[i].setMaxAge(0);
        String bookid=cookies[i].getName();
        //System.out.print(bookid);
        if(bookid.startsWith("A")&&bookid.length()==6){
            //cookies[i].setValue("5");
        String num=cookies[i].getValue();
        try {
            bookinfo.setBookid(bookid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //money+=(Integer.parseInt(bookinfo.getPrice())*Integer.parseInt(num));
        //out.print(bookinfo.getPrice()+" "+num);
  %>
    <tr>
        <td><font color="#528b8b"><%=bookinfo.getBookid()%></font> </td>
        <td><font color="#528b8b"><a href="bookinfo.jsp?bookid=<%=bookid%>"><%=bookinfo.getBookname()%></a></font> </td>
        <td><font color="#528b8b"><%=bookinfo.getPrice()%></font> </td>
        <td><font color="#528b8b"><input size="5" type="text" maxlength="5" value="<%=num%>" name="num" ></font> </td>
        <td><font color="#528b8b"><a href="delbook.jsp?bookid=<%=bookid%>">删除</a></font> </td>
    </tr>
    <%  }
    }
%>
</table>
</form>
<a href="success.jsp" ><h2 align="center">返回商城</h2></a>
<a href="OrderForm.jsp"><h2 align="center">提交订单</h2></a>
</body>
</html>
