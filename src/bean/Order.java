package bean;
// Author: Arthur
// date: 2019/12/17  20:02

import DB.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Order {
    private int OrderID=0;
   // private String userID=null;
    private String receiveName=null;
    private String receiveAdress=null;
    private String ZipCode=null;
    private String OrderPrice=null;
    private String OrderDate=null;
    private String OrderRemark=null;
    private String BookList=null;
    public int getOrderID()
    {
        return OrderID;
    }
 /*  public String getUserID()
    {
        return userID;
    }*/
    public String getReceiveName(){
        return receiveName;
    }
    public String getReceiveAdress(){
        return receiveAdress;
    }
    public String getZipCode()
    {
        return  ZipCode;
    }
    public String getOrderPrice()
    {
        return OrderPrice;
    }
    public String getOrderDate(){
        return  OrderDate;
    }
    public String getOrderRemark(){
        return OrderRemark;
    }
    public String getBookList(){
        return BookList;
    }

    public void setOrderID(int OrderID){
        this.OrderID=OrderID;
    }
    /*public void setUserID(String userID){
        this.userID=userID;
    }*/
    public void setReceiveName(String receiveName){
        this.receiveName=receiveName;
    }
    public void setReceiveAdress(String receiveAdress)
    {
        this.receiveAdress=receiveAdress;
    }
    public void setZipCode(String ZipCode){
        this.ZipCode=ZipCode;
    }
    public void setOrderPrice(String OrderPrice){
        this.OrderPrice=OrderPrice;
    }
    public void setOrderDate(String OrderDate){
        this.OrderDate=OrderDate;
    }
    public void setOrderRemark(String OrderRemark){
        this.OrderRemark=OrderRemark;
    }
    public void setBookList(String Booklist){
        this.BookList=BookList;
    }

    public void createOrder(){
        Connection conn=dbcon.getConn();

    }
    public ResultSet getOrderList(){
        Connection conn=dbcon.getConn();
        Statement state=null;
        ResultSet rs=null;
        try {
            state=conn.createStatement();
            String sql="Select OrderID,receiveName,receiveAdress,ZipCode,OrderPrice,OrderDate,OrderRemark from _ORDER ";
            rs=state.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
