package com.qunincey.bbs.util;

import java.sql.*;
import java.util.Properties;


public class DBconn {
   public static Connection conn=null;
    public static Properties prop=null;

    public static  String url = null;
    public static  String name = null;
    public static  String user =null;
    public static  String password =null ;

   public static void setConn(){
       prop= ReadPop.readpop();
       url=prop.getProperty("url");
       name=prop.getProperty("name");
       user=prop.getProperty("user");
       password=prop.getProperty("password");
   }

    public static Statement getStatement(Connection conn, String sql){
        Statement statement=null;
        try {
            statement= conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static Connection conn(){
        if (prop==null){
            setConn();
        }
        conn = null;
        try {
            Class.forName(name);
           conn= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;

    }
    public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void close(PreparedStatement pstm){
        if (pstm!=null){
            try {
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public static void close(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
