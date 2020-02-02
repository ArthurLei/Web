<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/17
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="bookinfo" class="bean.Book" scope="page"></jsp:useBean>
<html>
<head>
    <title>订单</title>
</head>
<body>
<%  double money=0;
    Cookie[] cookies=request.getCookies();
    //String []a = new String[cookies.length];
   // List<String> list = new ArrayList<String>();
    // int money=0;
    for(int i=0;i<cookies.length;i++)
    {
        //cookies[i].setMaxAge(0);
        String bookid=cookies[i].getName();
        //System.out.print(bookid);
        if(bookid.startsWith("A")&&bookid.length()==6){
            //cookies[i].setValue("5");
           // a[i]=cookies[i].getName();
            String num=cookies[i].getValue();
            int many=Integer.parseInt(num);
            try {
                bookinfo.setBookid(bookid);
            } catch (SQLException e) {
                e.printStackTrace();
            } double price=0;
                        try{
                           //price=Integer.parseInt(bookinfo.getPrice());
                           price=Double.parseDouble(bookinfo.getPrice());
                        }
                        catch (NumberFormatException e) {
                e.printStackTrace();

            }
                        //System.out.print(many+"  "+price);
            money = money + (many*price);

  }
}


   /* for(int i=0;i<a.length;i++){
        list.add(a[i]);
    }*/
    //System.out.println("a="+a);
    //session.setAttribute("list",a);
    //out.print(money);
%>
<form action="${pageContext.request.contextPath}/servlet/OrderConn" method="post">
<table width="100%" border="0">
    <tr>
        <td width="30"><font color="#ffa07a"> 收书人姓名</font></td>
        <td width="70"><input type="text" name="receivename" size="10" maxlength="10"></td>
    </tr>
    <tr>
        <td width="30"><font color="#ffa07a"> 订单总金额</font></td>
        <td width="70"><input type="text" name="Orderprice" size="10"  value="<%=money%>"></td>
    </tr>
    <tr>
        <td width="30"><font color="#ffa07a"> 邮编</font></td>
        <td width="70"><input type="text" name="ZipCode" size="6" maxlength="6"></td>
    </tr>
    <tr>
        <td width="30"><font color="#ffa07a"> 地址</font></td>
        <td width="70"><input type="text" id="receiveAdress" name="receiveAdress" size="60" maxlength="60"></td>
    </tr>
    <tr>
        <td width="30"><font color="#ffa07a"> 备注</font></td>
        <td width="70"><textarea name="OrderRemark" cols="60" rows="6"></textarea></td>
    </tr>
    <tr>
        <td width="30"><font color="#ffa07a"> </font></td>
        <td width="70"><input type="submit" name="Sumbt" value="提交订单"></td>
    </tr>

</table></form>
<h1 align="center"><a href="ShoppingCart.jsp">重新选择图书</a></h1>
</body>
</html>
