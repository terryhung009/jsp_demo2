package com.danny.jsp_demo1.dao.impl;

import com.danny.jsp_demo1.dao.UserDao;
import com.danny.jsp_demo1.db.MysqlDB;
import com.danny.jsp_demo1.vo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> queryUsers() {
        String sql = "select u.*,r.roleName from userInfo u left join roleInfo r on r.roleId = u.rolrId;";
        MysqlDB mysqlDB = new MysqlDB();
        Connection connection = mysqlDB.getConnect();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
