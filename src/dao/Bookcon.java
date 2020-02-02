package dao;
// Author: Arthur
// date: 2019/12/15  9:56

import DB.dbcon;
import com.mysql.cj.result.BinaryStreamValueFactory;
import java.io.*;
import java.sql.*;

public class Bookcon {
    public boolean insert(String bookid,String bookname,String author,String price,String intro,String path) throws SQLException {
        boolean Flag=false;
        PreparedStatement pstmt=null;
        Connection con= dbcon.getConn();
        Statement state=null;
        ResultSet res=null;
        try {
            String sql="INSERT INTO book VALUES (?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,bookid);
            pstmt.setString(2,bookname);
            pstmt.setString(3,author);
            pstmt.setString(4,price);
            pstmt.setString(5,intro);
            File F=new File(path);
            InputStream input=new FileInputStream(F);
            pstmt.setBinaryStream(6,input,(int)F.length());
            int x=pstmt.executeUpdate();
            if(x==1)
            {
                Flag=true;
            }
            input.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pstmt.close();
            dbcon.close(con);
        }
        return Flag;
    }
    public boolean picture(String bookid){
        boolean Flag=false;
        PreparedStatement pstmt=null;
        Connection conn= dbcon.getConn();
        Statement state=null;
        ResultSet rs=null;
        try {
            String sql="SELECT picture FROM book WHERE bookid='"+ bookid + "'";
            //pstmt.setString(1,bookid);
            state=conn.createStatement();
            rs=state.executeQuery(sql);
            if(rs.next()){
                InputStream input=rs.getBinaryStream(1);
                FileOutputStream out=null;
                out =new FileOutputStream(new File("D:\\IntelliJ IDEA 2019.1.3\\IdeaProjects\\Web\\web\\resources\\"+bookid+".jpg"));
                int temp=0;
                while ((temp=input.read())!=-1)
                {
                    out.write(temp);
                }
                input.close();
                out.close();
                Flag=true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
        return Flag;
    }
    public  boolean deleteBook(String BookID){
        boolean Flag=false;
        String sql="delete from book where bookid='"+BookID+"'";
        Connection conn=dbcon.getConn();
        Statement statement=null;
        ResultSet rs=null;
        try {
            statement=conn.createStatement();
            int x=statement.executeUpdate(sql);
            if (x>0)
            {
                Flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Flag;
    }
}
