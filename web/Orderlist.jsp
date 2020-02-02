<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/18
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="Order" class="bean.Order" scope="page"></jsp:useBean>
<html>
<head>
    <title>订单列表</title>
</head>
<body>
<table width="60%" border="1"cellpadding="0"  bordercolor="#9999FF" align="center" class="tab">
    <tr>
        <td><font color="#528b8b">订单号</font> </td>
        <td><font color="#528b8b">收获人</font> </td>
        <td><font color="#528b8b">收货地址</font> </td>
        <td><font color="#528b8b">邮政编码</font> </td>
        <td><font color="#528b8b">总价</font> </td>
        <td><font color="#528b8b">时间</font> </td>
        <td><font color="#528b8b">备注</font> </td>
        <td>&nbsp;</td>
    </tr>
    <%
        ResultSet rs=Order.getOrderList();
        while (rs.next())
        {int OrderID=rs.getInt("OrderID");
    %>    <tr>
        <td><a href="OrderInformation.jsp?OrderID=<%=OrderID%>"><%=rs.getInt("OrderID")%></a></td>
        <td><%=rs.getString("receiveName")%></td>
        <td><%=rs.getString("receiveAdress")%></td>
        <td><%=rs.getString("ZipCode")%></td>
        <td><%=rs.getString("OrderPrice")%></td>
        <td><%=rs.getString("OrderDate")%></td>
        <td><%=rs.getString("OrderRemark")%></td>
    </tr>
    <%}%>
</table>
<h2 align="center"><a href="RootSuccess.jsp">返回管理员首页</a></h2>
</body>
</html>
