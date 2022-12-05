package com.danny.servlet;

import com.danny.service.UserService;
import com.danny.service.impl.UserServiceImpl;
import com.danny.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        UserDao userDao = null;
        UserService userService = new UserServiceImpl();
        List<User> list= userService.queryUsers();

        for(User user : list){
            System.out.println(user.getUserName());
        }


        request.setAttribute("userList",list);
        request.getRequestDispatcher("/pages/user/userList.jsp").forward(request,response);

    }
}
