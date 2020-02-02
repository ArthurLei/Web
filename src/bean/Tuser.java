package bean;
// Author: Arthur
// date: 2019/12/15  17:17

import DB.dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tuser {
    private String username;
    private String password;
    private String email;
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public ResultSet getuserList(){
        Connection conn= dbcon.getConn();
        Statement state=null;
        ResultSet rs=null;
        try {
            state=conn.createStatement();
            String sql="Select username,password,email from user";
            rs=state.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
//    static public void main(String args[]) throws SQLException {
//        Tuser tuser=new Tuser();
//        ResultSet resultSet=tuser.getuserList();
//        while (resultSet.next()){
//          System.out.println(  resultSet.getString("username")+
//            resultSet.getString("password")+
//            resultSet.getString("email"));
//        }
//    }

}
