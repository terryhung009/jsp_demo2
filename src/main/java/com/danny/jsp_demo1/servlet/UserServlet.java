package com.danny.jsp_demo1.servlet;

import com.danny.jsp_demo1.service.UserService;
import com.danny.jsp_demo1.service.impl.UserServiceImpl;
import com.danny.jsp_demo1.vo.User;

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

        UserService userService = new UserServiceImpl();
        List<User> list= userService.queryUsers();
        request.setAttribute("userList",list);
        request.getRequestDispatcher("/pages/user/userList.jsp").forward(request,response);

    }
}
