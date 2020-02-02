package bean;
// Author: Arthur
// date: 2019/12/18  20:20

import DB.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderInformation {
    private int OrderID=0;
    private String BookList=null;
    private String BookNumber=null;
    private String receiveAdress=null;
    private String receiveName=null;

    public int getOrderID() {
        return OrderID;
    }
    public String getBookList(){
        return BookList;
    }

    public String getBookNumber() {
        return BookNumber;
    }

    public String getReceiveAdress() {
        return receiveAdress;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setOrderID(int orderID) {
        this.OrderID = orderID;
    }

    public void setBookList(String bookList) {
        this.BookList = bookList;
    }

    public void setBookNumber(String bookNumber) {
        this.BookNumber = bookNumber;
    }

    public void setReceiveAdress(String receiveAdress) {
        this.receiveAdress = receiveAdress;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public void getInform(int OrderID) throws SQLException {
        Connection conn= dbcon.getConn();
        Statement state=conn.createStatement();
        ResultSet rs=null;
        String sql="SELECT * FROM orderinformation WHERE OrderID='"+ OrderID + "'";
        rs=state.executeQuery(sql);
        while (rs.next()){
            OrderID=Integer.parseInt(rs.getString("OrderID"));
            BookList=rs.getString("BookList");
            BookNumber=rs.getString("BookNumber");
            receiveAdress=rs.getString("receiveAdress");
            receiveName=rs.getString("receiveName");
        }
        dbcon.close(rs,state,conn);
    }
    public void setInfor(int OrderID) throws SQLException {
        this.OrderID=OrderID;
        getInform(OrderID);
    }
}
