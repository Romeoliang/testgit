<%--
  Created by IntelliJ IDEA.
  User: JI
  Date: 2020/9/10
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>register</title>
</head>
<style>
    div {
        position: absolute;
        top: 200px;
        left: 500px;
    }
</style>
<body>
<form action="userServlet?method=registerServlet" method="post">
    <div>
        <h1 align="center">注册</h1>
        <table width="300" align="center">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" placeholder="请输入用户名"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="againPassword" placeholder="请再一次输入密码"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" placeholder="请输入邮箱"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="radio" checked="checked" name="gender" value="1"/>男
                    <input type="radio" name="gender" value="0"/>女
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <c:choose>
                        <c:when test="${result == false}">
                            两次密码不一致
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${result == true}">
                            注册成功<br>
                            <a href="login.html">去登陆</a>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
