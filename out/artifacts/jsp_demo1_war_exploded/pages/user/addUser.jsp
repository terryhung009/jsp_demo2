<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/12/6
  Time: 01:55
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增帳號</title>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
</head>
<body>
    <form id="form" method="post" action="<%=path%> /userServlet">
        <input type="hidden" value="1" name="type"/>
        使用者帳號: <input type="text" id="userId" name="userId" /><br>
        使用者密碼: <input type="password" id="userPassword" name="userPassword"/><br>
        使用者姓名: <input type="text" id="userName" name="userName" /><br>
        性別: <input type="radio" id="gender1" name="gender" value="1"/>男
            <input type="radio" id="gender2" name="gender" value="2">女<br>
        角色:<select id="roleId" name="roleId">
        <option value="">請選擇...</option>
        <option value="1">系統管理員</option>
        <option value="2">使用者</option>
    </select><br>
        <button type="button" onclick="add();" >新增</button>
            <button type="button" onclick="cancel();">取消</button>
    </form>






</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/axios@1.1.2/dist/axios.min.js"></script>

<script>
    function add(){
        let userId = document.getElementById("userId").value;
        let userPassword = document.getElementById("userPassword").value;
        let roleId = document.getElementById("roleId").value;
        if(userId == null || userId == ''){
            alert("請輸入使用者帳號")
            return;
        }
        if(userPassword == null || userPassword == ''){
            alert("請輸入使用者密碼")
            return;
        }
        if(roleId == null || roleId == ''){
            alert("請輸入使用者角色")
            return;
        }
        //判斷用戶名是否重複
        //ajax
        let url = "<%=path%>/userServlet", params='type=4&userId='+userId;
        let respones = getDataByAjax(url,params)


        if(respones == "1"){
            //submit
            document.getElementById("form").submit();

        }else{
            //return
            alert("您輸入的用戶名已經存在，請重新輸入");
            return;
        }





    }
    function cancel(){
        window.location.href = "<%=path%>/userServlet";
    }

    function getDataByAjax(url, params){
        let ajaxObj =null;
        if(window.ActiveXObject){
            ajaxObj = new ActiveXObject("Microsoft.XMLHTTP");
        }else{
            ajaxObj = new XMLHttpRequest();
        }
        ajaxObj.open('POST',url,false);
        ajaxObj.setRequestHeader("Content-Type" , "application/x-www-form-urlencoded");
        ajaxObj.send(params);
        return ajaxObj.responseText;




    }





</script>
