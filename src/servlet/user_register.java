package servlet;

import dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "user_register")
public class user_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String date=request.getParameter("date");
        String phone=request.getParameter("phone");
        String nation=request.getParameter("nation");
        String remark=request.getParameter("remark");

        String temp="";
        //System.out.println(username+password+email+date+phone+nation+remark);
        switch (nation)
        {
            case "AL":temp="阿拉伯"; break;
            case "AK":temp="中国";break;
            case "AZ":temp="美国";break;
            case "AR":temp="法国";break;
            case "CA":temp="英国";break;
            case "CO":temp="德国";break;
            case "CT":temp="西班牙";break;
            case "DE":temp="俄罗斯";break;
        }
        Userdao U = new Userdao();
        boolean Flag = false;
        try {
            if (!U.register(username,password,email,date,temp,phone,remark)) {
            } else {
                Flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (Flag) {
            System.out.println("注册成功");
            response.sendRedirect("../login.jsp");
        } else {
            System.out.println("注册失败！");
        }
    }
}
