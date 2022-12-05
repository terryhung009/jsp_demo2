package com.danny.dao.impl;

import com.danny.dao.UserDao;
import com.danny.db.MysqlDB;
import com.danny.vo.User;

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
//        PreparedStatement pps = null; //SQL injection




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
//                rs.close();
//                statement.close();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return list;
    }
}
