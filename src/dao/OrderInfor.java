package dao;
// Author: Arthur
// date: 2019/12/18  20:27

import DB.dbcon;

import java.sql.*;

public class OrderInfor {
    public boolean setOrder(int OrderID,String BookList,String BookNumber,String receiveAdress,String receiveName ){
        boolean Flag=false;
        Connection connection= dbcon.getConn();
        PreparedStatement pstmt=null;
        //Statement state=null;
        //ResultSet rs=null;
        String sql="INSERT INTO orderinformation VALUES (?,?,?,?,?)";
        try {
            pstmt= connection.prepareStatement(sql);
           // pstmt.executeQuery(sql);
            pstmt.setInt(1,OrderID);
            pstmt.setString(2,BookList);
            pstmt.setString(3,BookNumber);
            pstmt.setString(4,receiveAdress);
            pstmt.setString(5,receiveName);
            int x=pstmt.executeUpdate();
            if (x==1){
                Flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Flag;
    }
}
