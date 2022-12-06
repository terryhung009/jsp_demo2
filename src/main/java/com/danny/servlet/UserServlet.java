package com.danny.servlet;

import com.danny.service.UserService;
import com.danny.service.impl.UserServiceImpl;
import com.danny.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        UserDao userDao = null;
        UserService userService = new UserServiceImpl();
        String type = request.getParameter("type");
        System.out.println("type= " + type);
        switch(type){
            case "1": //保存
                User user = new User();
                user.setUserId(request.getParameter("userId"));
                user.setUserPassword(request.getParameter("userPassword"));
                user.setUserName(request.getParameter("userName"));
                String genderStr =  request.getParameter("gender");
                if(genderStr != null){
                    user.setGender(Integer.valueOf(genderStr));
                }
                String roleId = request.getParameter("roleId");
                if(roleId==null){
                    user.setRoleId(2);
                }else{
                    user.setRoleId(Integer.valueOf(roleId));
                }
                try {
                    userService.addUser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("/userServlet?type=0").forward(request,response);
//                request.getRequestDispatcher("/pages/user/userList.jsp?type=0").forward(request,response);



                break;
            case "2"://編輯
                break;
            case "3"://刪除
                break;
            case "4"://驗證

                try {
                    String userId = request.getParameter("userId");
//                String type1 = request.getParameter("type");
                    User user2 = userService.queryUserById(userId);
                    if(user2 == null){
                        response.getWriter().print("1");
                    }else{
                        response.getWriter().print("2");
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default: // 查詢
                List<User> list= userService.queryUsers();

//        for(User user : list){
//            System.out.println(user.getUserName());
//        }
                request.setAttribute("userList",list);
                request.getRequestDispatcher("/pages/user/userList.jsp").forward(request,response);

        }



    }
}
