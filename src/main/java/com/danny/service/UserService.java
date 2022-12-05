package com.danny.service;

import com.danny.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    List<User> queryUsers();

    User queryUserById(String userId) throws SQLException;
}
