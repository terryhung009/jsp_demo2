package com.danny.servlet;

import com.danny.pojo.User;
import com.danny.service.UserService;
import com.danny.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username:  " + username);
        System.out.println("Password:  " + password);
        /**TODO
         * 根據用戶查詢數據庫，如果沒有結果，表示帳號不存在
         * 如果有結果再比對密碼，密碼不對，回傳錯誤訊息
         * 密碼正確，跳轉到系統主頁
         */


        try {
            //調用UserService進行查詢數據庫
            UserService userService = new UserServiceImpl();
            User user = userService.queryUserById(username);

            //將數據庫返回的User封裝的資料跟前端進來的資料比對
            if(user != null && user.getUserPassword().equals(password)){
                //密碼正確
                request.setAttribute("username",username);
                request.getRequestDispatcher("/userServlet?type=0").forward(request,response);
            }else{
                //用戶名或密碼錯誤
                request.setAttribute("username",username);
                request.setAttribute("error","帳號或密碼錯誤，請重新輸入");
                request.getRequestDispatcher("/").forward(request,response);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
