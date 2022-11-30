package com.danny.jsp_demo1.dao.impl;

import com.danny.jsp_demo1.dao.UserDao;
import com.danny.jsp_demo1.db.MysqlDB;
import com.danny.jsp_demo1.vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> queryUsers() {
        String sql = "select u.*,r.roleName from userInfo u left join roleInfo r on r.roleId = u.rolrId;";
        List<User> list =new ArrayList<>();

        MysqlDB mysqlDB = new MysqlDB();
        Connection connection = mysqlDB.getConnect();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setGender(resultSet.getInt("gender"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setRoleId(resultSet.getInt("roleId"));
                user.setRoleName(resultSet.getString("roleName"));
                list.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                statement.close();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return list;
    }
}
