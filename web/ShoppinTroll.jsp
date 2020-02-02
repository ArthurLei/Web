<%@ page import="java.sql.SQLSyntaxErrorException" %><%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/17
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>加入购物车成功</title>
    <%
    //    String bookid=request.getParameter("bookid");
//    out.print(bookid);
    Cookie[] cookies=request.getCookies();
//        for (int i=0;i<cookies.length;i++)
//        {
//            System.out.println(cookies[i].getName()+"  "+cookies[i].getValue());
//        }
 //   String[] C=new String[cookies.length];

    for (int i=0;i<cookies.length;i++)
    {
        //C[i]=cookies[i].getValue();
        if (request.getParameter("bookid").equals(cookies[i].getName())){
           // System.out.println(cookies[i].getName()+cookies[i].getValue());
            int x=Integer.parseInt(cookies[i].getValue())+1;
          //  System.out.println("x的值"+x);
            String s=Integer.toString(x);
            //cookies[i].setValue(s);
            Cookie cookie=new Cookie(request.getParameter("bookid"),s);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            //response.addCookie(cookies[i]);
           // System.out.println(x);
          //  System.out.println(cookies[i].getValue());
        }
        else {
            Cookie cookie=new Cookie(request.getParameter("bookid"),"1");
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
        }

    }


//    boolean Flag=temp.get(request.getParameter("bookid"),C);
//    if(request.getParameter("bookid")!=null)
//    {
//        if(Flag){
//
//        }else {
//            Cookie cookie=new Cookie(request.getParameter("bookid"),"1");
//            cookie.setMaxAge(60*60*24*30);
//            response.addCookie(cookie);}
//    }
%>
</head>

<body>
<h1 align="center">图书已放在购物车中</h1>
<h1 align="center"><a href="ShoppingCart.jsp">查看购物车</a></h1>
<h2 align="center"><a href="success.jsp">返回商城</a></h2>
</body>
</html>
