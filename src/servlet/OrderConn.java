package servlet;

import bean.Book;
import dao.OrderDo;
import dao.OrderInfor;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

//@WebServlet(name = "OrderConn")
public class OrderConn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie []cookies=request.getCookies();
        String name=null;
        String number=null;
        Book B=new Book();
        for(int i=0;i<cookies.length;i++)
        {
           // cookies[i].setMaxAge(0);
            String bookid=cookies[i].getName();
            //System.out.print(bookid);
            if(bookid.startsWith("A")&&bookid.length()==6){
                try {
                    B.setBookid(bookid);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (name==null)
                {name=B.getBookname()+"|";
                number=cookies[i].getValue()+"|";
                }else
                    {
                name=name+B.getBookname()+"|";
                number=number+cookies[i].getValue()+"|";}
               // System.out.println(cookies[i].getName());
            }
        }
        System.out.println(name+"   "+number);
        boolean Flag=false;
        boolean Flag1=false;
        OrderDo Order=new OrderDo();
        OrderInfor Order1=new OrderInfor();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        int OrderID=Order.getMaxOrderID()+1;
        String receiveName=request.getParameter("receivename");
        String Orderprice=request.getParameter("Orderprice");
        String ZipCode=request.getParameter("ZipCode");
        String receiveAdress=request.getParameter("receiveAdress");
        String OrderData=dateFormat.format(new Date());
        String OrderRemark=request.getParameter("OrderRemark");
        String BookList=null;

//        String []a=null;
//        a= (String[])request.getSession().getAttribute("list");
//        for(int i=1;i<a.length;i++){
//            System.out.println(a[i]);
//        }
       // System.out.println(OrderID+receiveName+receiveAdress+ZipCode+Orderprice+OrderData+OrderRemark);
        try {
            Flag=Order.createOrder(OrderID,receiveName,receiveAdress,ZipCode,Orderprice,OrderData,OrderRemark,BookList);
            Flag1= Order1.setOrder(OrderID,name,number,receiveAdress,receiveName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (Flag&&Flag1){
           System.out.println("提交订单成功！");
           response.sendRedirect("../SuccessSubmit.jsp");
        }
        else {
            System.out.println("提交失败");
        }
    }
}
