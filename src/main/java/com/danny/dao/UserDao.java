package com.danny.dao;

import com.danny.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> queryUsers();

    User queryUserById(String userId) throws SQLException;

    void addUser(User user) throws SQLException;

}
