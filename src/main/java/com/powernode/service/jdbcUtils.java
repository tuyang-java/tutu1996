package com.powernode.service;



import java.sql.*;

/**
 * ty
 * 2020/9/16
 * 数据库连接
 */
public class jdbcUtils {
    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection(){

        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "970524");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭流
    public static void  close(Connection connection,PreparedStatement ps,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
