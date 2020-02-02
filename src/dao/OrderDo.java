package dao;
// Author: Arthur
// date: 2019/12/17  20:44

import DB.dbcon;
import bean.Order;

import java.sql.*;

public class OrderDo {
    public boolean createOrder(int OrderID,String receiveName,String receiveAdress,String ZipCode,String OrderPrice,String OrderDate,String OrderRemark,String BookList) throws SQLException {
        boolean Flag=false;
        Connection connection= dbcon.getConn();
        PreparedStatement pstmt=null;
        try {
            //Statement stae=connection.createStatement();
            String sql="INSERT INTO _Order VALUES (?,?,?,?,?,?,?,?)";
            pstmt=connection.prepareStatement(sql);
            pstmt.setInt(1,OrderID);
            //pstmt.setString(2,userID);
            pstmt.setString(2,receiveName);
            pstmt.setString(3,receiveAdress);
            pstmt.setString(4,ZipCode);
            pstmt.setString(5,OrderPrice);
            pstmt.setString(6,OrderDate);
            pstmt.setString(7,OrderRemark);
            pstmt.setString(8,BookList);
            int x=pstmt.executeUpdate();
            if (x>0){
                Flag=true;
            }
        } finally {
            pstmt.close();
            dbcon.close(connection);
        }
    return Flag;
    }
    public int getMaxOrderID() {
        int Flag=0;
        Connection conn=dbcon.getConn();
        Statement state=null;
        ResultSet res=null;
        try{ state=conn.createStatement();
            String sql="select max(OrderID) from _order;";
        res=state.executeQuery(sql);
        while (res.next()) {
            Flag = res.getInt("max(OrderID)");
        }} catch (SQLException e) {
           e.printStackTrace();
       }finally {
           dbcon.close(res,state,conn);
       }
        return  Flag;
    }
    /*
    测试
    */
    static public void main(String args []) throws SQLException {
        OrderDo o=new OrderDo();
        o.getMaxOrderID();
        System.out.println(o.getMaxOrderID());
    }
}
