<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/12/1
  Time: 02:16
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用者管理</title>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
</head>
<body>
<button type="button" onclick="addUser();">新增</button>
<table border="1">
    <tr>
        <td>ID</td>
        <td>帳號名稱</td>
        <td>姓名</td>
        <td>性別</td>
        <td>角色名稱</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userList}" var="l" varStatus="vs">
        <tr>
            <td>${vs.index + 1}</td>
            <td>${l.userId}</td>
            <td>${l.userName}</td>
            <td>${l.gender == 1 ? '男' : '女'}</td>
            <td>${l.roleName}</td>
            <td>
                <button type="button" onclik="editUser();">編輯</button>
                <button type="button" onclik="deleteUser();">刪除</button>
            </td>



        </tr>



    </c:forEach>



</table>

</body>
</html>

<script>
    function addUser(){
        window.location.href = "<%=path%>/pages/user/addUser.jsp"
    }
    function editUser(){

    }
    function deleteUser(){

    }
</script>
