package com.danny.service.impl;

import com.danny.dao.UserDao;
import com.danny.dao.impl.UserDaoImpl;
import com.danny.service.UserService;
import com.danny.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryUsers() {
        UserDao userDao = new UserDaoImpl();
        return userDao.queryUsers();
    }
}
