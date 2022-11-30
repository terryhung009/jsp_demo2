package com.danny.jsp_demo1.service.impl;

import com.danny.jsp_demo1.dao.UserDao;
import com.danny.jsp_demo1.dao.impl.UserDaoImpl;
import com.danny.jsp_demo1.service.UserService;
import com.danny.jsp_demo1.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> queryUsers() {
        UserDao userDao = new UserDaoImpl();



        return userDao.queryUsers();
    }
}
