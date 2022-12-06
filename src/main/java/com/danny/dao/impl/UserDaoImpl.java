package com.danny.dao.impl;

import com.danny.dao.UserDao;
import com.danny.db.MysqlDB;
import com.danny.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> queryUsers() {
        String sql = "select u.*,r.roleName from userInfo u left join roleInfo r on r.roleId = u.roleId;";
        List<User> list = new ArrayList<>();
        MysqlDB mysqlDB = new MysqlDB();
        Connection connection = mysqlDB.getConnect();
        Statement statement = null;
        ResultSet rs = null;




        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);


            while(rs.next()){
                User user = new User();
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setRoleId(rs.getInt("roleId"));
                user.setRoleName(rs.getString("roleName"));
                list.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                statement.close();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public User queryUserById(String userId) throws SQLException {
        String sql = "SELECT u.* FROM userInfo u where u.userId = '" + userId + "'";
        User user = null;
        MysqlDB mysqlDB = new MysqlDB();
        Connection connection = mysqlDB.getConnect();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);


            while(rs.next()){
                user = new User();
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setRoleId(rs.getInt("roleId"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                statement.close();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        StringBuffer sql = new StringBuffer("insert into userInfo (userId,userName,userPassword,gender,roleId) values (" );
        sql.append("' " + user.getUserId() + " ',");
        sql.append("' " + user.getUserName() + " ',");
        sql.append("' " + user.getUserPassword() + " ',");
        sql.append("' " + user.getGender() + " ',");
        sql.append("' " + user.getRoleId() + " ' ");
        sql.append(")");
        System.out.println(sql);
//        String sql = "SELECT u.* FROM userInfo u where u.userId = '" + userId + "'";

        MysqlDB mysqlDB = new MysqlDB();
        Connection connection = mysqlDB.getConnect();
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
//            rs = statement.executeQuery(sql);
            statement.execute(sql.toString());

//            while(rs.next()){
//                user = new User();
//                user.setUserId(rs.getString("userId"));
//                user.setUserName(rs.getString("userName"));
//                user.setGender(rs.getInt("gender"));
//                user.setUserPassword(rs.getString("userPassword"));
//                user.setRoleId(rs.getInt("roleId"));
//
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
//                rs.close();
//                statement.close();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        System.out.println("insert success!");
    }
}
