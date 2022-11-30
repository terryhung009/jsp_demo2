package com.danny.jsp_demo1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {
    private final static String DB_URL = "MySQL";
    private final static String DB_DRIVER = "jdbc:mariadb://localhost:3306/userdb";
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
            if (conn != null){
                System.out.println("Connecting to the database");
            }else{
                System.out.println("Cannot connect to database;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;


    }
}
