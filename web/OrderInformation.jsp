<%@ page import="bean.OrderInformation" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/18
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%int OrderID=Integer.parseInt(request.getParameter("OrderID"));
    //out.print(OrderID);
    OrderInformation orderInformation=new OrderInformation();
    orderInformation.setInfor(OrderID);

    String booklist=orderInformation.getBookList();
    String receiveadress=orderInformation.getReceiveAdress();
    String booknumber=orderInformation.getBookNumber();
    String receivename=orderInformation.getReceiveName();
    String[] bookArray=booklist.split("\\|");
    String[] numberArray=booknumber.split("\\|");
    for (int i=0;i<bookArray.length;i++)
    {
        System.out.println(bookArray[i]);
    }
   // System.out.println(orderInformation.getOrderID()+orderInformation.getReceiveAdress()+orderInformation.getBookList());
%>
<h1 align="center">订单<%=OrderID%></h1>
<table width="60%" border="1"cellpadding="0"  bordercolor="#9999FF" align="center">
    <tr>
        <td><font color="#528b8b">书名</font> </td>
        <td><font color="#528b8b">数量</font> </td>
    </tr>
    <%
        for(int i=0;i<bookArray.length;i++)
        {
         %>
    <tr>
        <td><font color="#528b8b"><%=bookArray[i]%></font> </td>
        <td><font color="#528b8b"><%=numberArray[i]%></font> </td>
    </tr>
    <%}%>
</table>
<h2 align="center">收货人：<%=receivename%></h2>
<h2 align="center">收货地址：<%=receiveadress%></h2>
</body>
</html>
