<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/17
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <a href="Findpassword.jsp" class="for">忘记密码...?</a>
            </div>
            <div class="clear"></div>
            <div class="btnn">
                <button type="submit">登录</button>
            </div>
        </form>
        <div class="w3layouts_more-buttn">
            <h3>还没有账号..?
                <a href="http://localhost:8090/Web_war_exploded/register/register.jsp">点击注册
                </a>
            </h3>
        </div>
    </div>
</div>
<div class="art-left-w3ls">
    <h1 class="header-w3ls">
        购书系统
    </h1>
</div>
</div>
</body>
</html>
