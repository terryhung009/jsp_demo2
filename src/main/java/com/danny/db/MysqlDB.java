package com.danny.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {
    private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/userdb?useUnicode=true&characterEncoding=utf8";
    private final static String DB_USER = "wilson";
    private final static String DB_PASSWORD = "password";

    public Connection getConnect(){

        Connection conn = null;


        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(
                    DB_URL,
                    DB_USER,
                    DB_PASSWORD
            );
            if(conn != null){
                System.out.println("資料庫已經連接");
            }else{
                System.out.println("資料庫連接失敗");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;


    }
}
