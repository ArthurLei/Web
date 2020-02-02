package servlet;

import com.mysql.cj.Session;
import dao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "user_login")
public class user_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharaterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        session.setAttribute("username",username);
        Userdao U = new Userdao();
        boolean Flag = U.login(username, password);
        if (Flag) {
            System.out.println("登陆成功！");
                        response.sendRedirect("../success.jsp");
        } else {
            System.out.println("登陆失败！");
            response.sendRedirect("../fail.jsp");
        }
    }
}