<%--
  Created by IntelliJ IDEA.
  User: terry
  Date: 2022/12/1
  Time: 02:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用者管理</title>
</head>
<body>
<button type="button" onclik="addUser();">新增</button>
<table border="1">
    <tr>
        <td>ID</td>
        <td>帳號名稱</td>
        <td>姓名</td>
        <td>性別</td>
        <td>角色名稱</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${userlist}" var="l" varStatus="vs">
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

    }
    function editUser(){

    }
    function deleteUser(){

    }
</script>
