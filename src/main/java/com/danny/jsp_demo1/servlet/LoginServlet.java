package com.danny.jsp_demo1.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username:  " +username);
        System.out.println("Password:  " + password);
        /**TODO
         * 根據用戶查詢數據庫，如果沒有結果，表示帳號不存在
         * 如果有結果再比對密碼，密碼不對，回傳錯誤訊息
         * 密碼正確，跳轉到系統主頁
         */
        if("admin".equals(username) && "666666".equals(password)){
            //密碼正確
            request.setAttribute("username",username);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            //用戶名或密碼錯誤
            request.setAttribute("username",username);
            request.setAttribute("error","帳號或密碼錯誤，請重新輸入");
//            request.setAttribute("password",password);
            request.getRequestDispatcher("/").forward(request,response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
