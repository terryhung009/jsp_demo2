<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/11/30
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系統登入</title>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
</head>
<body>
    <form action="/userServlet" id="form" method="post">
        <input type="hidden" value="0" name="type"/>
         <input type="text" id="username" name="username" value="${username}" placeholder="請輸入帳號">
         <input type="password" id="password" name="password"  placeholder="請輸入密碼">
         <button type="button" name="loginButton" onclick="loginVerify();" >登入 </button>
            ${error}
    </form>

</body>
</html>
<script>
    function loginVerify(){
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        if(username == ""){
            alert('帳號不能為空，請輸入');
            return;
        }
        if(password == ""){
            alert('密碼不能為空，請輸入');
            return;
        }
        //調用後端servlet，並將data進行傳遞
        document.getElementById("form").submit();



    }
</script>
