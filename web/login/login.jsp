<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/11
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <!-- Meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content=""
    />
    <script>
        addEventListener("load", function () { setTimeout(hideURLbar, 0); }, false); function hideURLbar() { window.scrollTo(0, 1); }
    </script>
    <!-- Meta tags -->
    <!--stylesheets-->
    <link href="${pageContext.request.contextPath} css/style.css" rel='stylesheet' type='text/css' media="all">
    <!--//style sheet end here-->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600,700" rel="stylesheet">
</head>
<body>
<div class="mid-class">
    <div class="art-right-w3ls">
        <h2>Sign In and Sign Up</h2>
        <form action="${pageContext.request.contextPath}/servlet/user_login" method="post">
            <div class="main">
                <div class="form-left-to-w3l">
                    <input type="text" name="username" placeholder="Username" required="">
                </div>
                <div class="form-left-to-w3l ">
                    <input type="password" name="password" placeholder="Password" required="">
                    <div class="clear"></div>
                </div>
            </div>
            <div class="right-side-forget">
<%--                <a href="http://localhost:8090/Findpassword.jsp" class="for">忘记密码...?</a>--%>
    <a href="http://28327846f2.eicp.vip/Findpassword.jsp" class="for">忘记密码...?</a>
            </div>
            <div class="clear"></div>
            <div class="btnn">
                <button type="submit">登录</button>
            </div>
        </form>
        <div class="w3layouts_more-buttn">
            <h3>还没有账号..?
<%--                <a href="http://localhost:8090/register/register.jsp">点击注册--%>
<%--                </a>--%>
                <a href="http://28327846f2.eicp.vip/register/register.jsp">点击注册
                </a>
            </h3>
        </div>
    </div>
<%--</div>--%>
<%--<div class="art-left-w3ls">--%>
<%--    <h1 class="header-w3ls">--%>
<%--        购书系统--%>
<%--    </h1>--%>
<%--</div>--%>
<%--</div>--%>
</body>
</html>
