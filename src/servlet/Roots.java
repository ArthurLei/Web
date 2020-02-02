package servlet;

import DB.dbcon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//@WebServlet(name = "Roots")
public class Roots extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            Connection connection= dbcon.getConn();
            Statement state=null;
            ResultSet rs=null;
            try {
                String sql="select * from root where username='"+username+"' and password='"+ password + "'";
                state=connection.createStatement();
                rs=state.executeQuery(sql);
                if (rs.next()){
                    System.out.println("Root用户登录成功！");
                    response.sendRedirect("../RootSuccess.jsp");
                }
                else {
                    System.out.println("登录失败！");
                    response.sendRedirect("../fail.jsp");
                }

    } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
