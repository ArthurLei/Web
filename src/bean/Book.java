package bean;
// Author: Arthur
// date: 2019/12/15  20:55

import DB.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {
    private String bookid=null;
    private String bookname=null;
    private String author=null;
    private String price=null;
    private String intro=null;

    private void getbookInfo(String bookid) throws SQLException {
       Connection conn=dbcon.getConn();
       Statement state=conn.createStatement();
       ResultSet rs=null;
       String sql="SELECT * FROM book WHERE bookid='"+ bookid + "'";
       rs=state.executeQuery(sql);
       while (rs.next()){
           //bookid=rs.getString("bookid");
           bookname=rs.getString("bookname");
           author=rs.getString("author");
           price=rs.getString("price");
           intro=rs.getString("intro");
       }
        dbcon.close(rs,state,conn);
    }
    public ResultSet getBookList(){
        Connection conn=dbcon.getConn();
        Statement state=null;
        ResultSet rs=null;
        try {
            state=conn.createStatement();
            String sql="Select bookid,bookname,author,price from book";
            rs=state.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public  void setBookid(String bookid) throws SQLException {
        this.bookid=bookid;
        getbookInfo(bookid);
    }
    public String getBookid(){
        return bookid;
    }
    public String getBookname(){
        return bookname;
    }
    public String getAuthor(){return author;}
    public String getPrice(){
        return  price;
    }
    public String getIntro(){
        return intro;
    }
    /*
    测试Bookbean程序
    */
//    public static void main(String args[]) throws SQLException {
//        Book book=new Book();
//        book.setBookid("A00002");
//        System.out.print(book.bookid+book.getBookname()+book.getPrice()+book.getIntro());
//    }
}
