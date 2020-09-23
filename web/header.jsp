<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.qfedu.entity.User" %>
<%@ page import="com.qfedu.entity.Goodstype" %>
<%@ page import="java.util.List" %>
<%@ page import="com.qfedu.service.impl.GoodsServiceImpl" %>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: JI--%>
<%--  Date: 2020/9/11--%>
<%--  Time: 20:17--%>
<%--  To change this template use File | Settings | File Templates.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入Bootstrap静态样式CSS--%>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<html>
<head>
    <title>herder</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="page-header">
    <h1 align="center">MyShop</h1>
    <h2><a href="index.jsp">首页</a></h2>
    <span>
        <h3>
            <%!
                private List<Goodstype> allGoodsType = new GoodsServiceImpl().findAllGoodsType();
            %>
            <%application.setAttribute("allGoodsType", allGoodsType);%>
            <c:forEach items="${allGoodsType}" var="type">
                <a href="goodsServlet?method=showGoodsServlet&goodsTypeId=${type.id}&currentPage=1">${type.name}</a>
            </c:forEach>

            <%----%>
            <span style="float: right">
                <%User user = (User) session.getAttribute("user");%>
                <%
                    if (user != null) {
                        out.print("<a href='#'>"+ user.getUsername() +"</a>");
                    } else {
                        out.print("<a href='login.html'>登录</a>");
                    }
                %>
                <a href="userServlet?method=logoutServlet">退出账户</a>
                <a href="register.jsp">注册</a>
                <a href="cart?method=showCart">购物车</a>
                <a href="#">客服中心</a>
            </span>

        </h3>
    </span>
</div>
</body>
</html>
