package servlet;

import dao.Userdao;
import dao.mail;
import dao.mailUnitl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "FindPsaaword")
public class FindPassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username=request.getParameter("username");
       String email=request.getParameter("email");
        Userdao U=new Userdao();
        String password=U.Find(username,email);
        if(password!=null){
            mail mail = new mail();
            mail.setHost("smtp.qq.com"); // 设置邮件服务器,如果不用QQ邮箱的,自己找找看相关的
            mail.setPortNumber("465"); // 设置邮件服务器端口号,默认25
            mail.setSender("1369610671@qq.com"); // 发送人
            mail.setName("bookstore"); // 发送人昵称
            mail.setReceiver(email); // 接收人
            mail.setUsername("1369610671@qq.com"); // 登录账号,一般都是和邮箱名一样
            mail.setPassword("rnnzdpqhotxzjgjc"); // QQ邮箱登录第三方客户端时,密码框请输入“授权码”进行验证。其他的密码具体查看邮件服务器的说明
            mail.setSubject("找回密码");
            mail.setMessage("您的密码是："+password);
            //email.setSSLOnConnect(true);
            if (new mailUnitl().send(mail)) {
                System.out.println("发送成功");
            } else {
                System.out.println("发送失败");
            }
//            try {
//                wait(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            response.sendRedirect("../FindSuccess.jsp");
        }
        else {
            response.sendRedirect("../FindFiled.jsp");
        }
    }
}
