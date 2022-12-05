package com.danny.service.impl;

import com.danny.dao.UserDao;
import com.danny.dao.impl.UserDaoImpl;
import com.danny.service.UserService;
import com.danny.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryUsers() {
        //將controller層(或servlet層)的請求傳遞到Dao層，在Dao層處理
        UserDao userDao = new UserDaoImpl();
        List<User> result = userDao.queryUsers();
        return result;
    }

    @Override
    public User queryUserById(String userId) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User result = userDao.queryUserById(userId);
        return result;
    }


}
