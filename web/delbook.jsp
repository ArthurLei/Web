<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/17
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    for (int i=0;i<cookies.length;i++)
    {
        //C[i]=cookies[i].getValue();
        if (request.getParameter("bookid").equals(cookies[i].getName())) {
            if (Integer.parseInt(cookies[i].getValue()) > 1) {
                int x = Integer.parseInt(cookies[i].getValue()) - 1;
                String s = Integer.toString(x);
                Cookie cookie=new Cookie(request.getParameter("bookid"),s);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                //response.sendRedirect("ShoppingCart.jsp");
            }
            else {
                Cookie cookie=new Cookie(request.getParameter("bookid"),"0");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
               // response.sendRedirect("ShoppingCart.jsp");
            }
        }
        }
    response.sendRedirect("ShoppingCart.jsp");
//    Cookie[] cookies=request.getCookies();
//
//    for(Cookie cookie: cookies){
//
//        cookie.setMaxAge(0);
//
//        cookie.setPath("/");  //
//
//        response.addCookie(cookie);
//
//    }



//    if (null==cookies) {
//        System.out.println("没有cookie==============");
//    } else {
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals(request.getParameter("bookid"))){
//                cookie.setValue(null);
//                cookie.setMaxAge(0);// 立即销毁cookie
//                cookie.setPath("/");
//                System.out.println("被删除的cookie名字为:"+cookie.getName());
//               response.addCookie(cookie);
//
//            //    break;
//            }
//        }response.sendRedirect("ShoppingCart.jsp");
//    }
//    if (request.getParameter("bookid")!=null){
//        Cookie cookie=new Cookie(request.getParameter("bookid"),"0");
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
//        response.sendRedirect("ShoppingCart.jsp");
//    }
%>
<html>
<head>
    <title>删除图书</title>
</head>
<body>
已删除
<a href="ShoppingCart.jsp">返回购物车</a>
</body>
</html>
