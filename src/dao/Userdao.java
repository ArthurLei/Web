package dao;
// Author: Arthur
// date: 2019/12/11  16:10

import DB.dbcon;
import bean.Tuser;

import java.sql.*;

public class Userdao {
    public boolean login(String username,String password){
        boolean flag=false;
      //  Tuser user=new Tuser();
        Connection conn= dbcon.getConn();
        Statement state=null;
        ResultSet rs=null;
        try {

            String sql="select * from user where username='"+username+"' and password='"+ password + "'";
            state=conn.createStatement();
            rs=state.executeQuery(sql);
            if (rs.next())
            {
                flag=true;
//                user.setUsername(username);
//                user.setPassword(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbcon.close(rs,state,conn);
        }
        return flag;
    }
    public boolean register(String usrname, String password, String email,String date,String phone,String nation,String remark) throws SQLException {
        boolean flag=false;
        PreparedStatement pstmt=null;
        Connection con=dbcon.getConn();
        try {
            String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";//(username,password,email)
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usrname);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4,date);
            pstmt.setString(5,phone);
            pstmt.setString(6,nation);
            pstmt.setString(7,remark);
            int x = pstmt.executeUpdate();
            //System.out.println(x);
            if(x==1)
            {
                flag=true;
            }
        }
        finally {
            pstmt.close();
            dbcon.close(con);
        }
        return flag;

}
    public String Find(String username,String email){

        //  Tuser user=new Tuser();
        String password=null;
        Connection conn= dbcon.getConn();
        Statement state=null;
        ResultSet rs=null;
        try {

            String sql="select * from user where username='"+username+"' and email='"+ email + "'";
            state=conn.createStatement();
            rs=state.executeQuery(sql);
             if (rs.next())
            {
                password=rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbcon.close(rs,state,conn);
        }
        return password;
    }
}
