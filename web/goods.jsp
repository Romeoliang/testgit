<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.qfedu.entity.PageBean" %>

<%--引入Bootstrap静态样式CSS--%>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">


<%--
  Created by IntelliJ IDEA.
  User: JI
  Date: 2020/9/14
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>goods</title>
    <style>
        .line {
            width: 190px;
            height: 205px;
            float: left;
            margin-left: 5px;
        }

        .table {
            height: 205px;
            width: 100%;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>


<div class="table">
    <c:forEach items="${pageBean.list}" var="goods">
        <div class="line">
            <a href="goodsServlet?method=showGoodsDetailsServlet&goodsId=${goods.id}">
                商品ID：${goods.id}<br>
                商品名字：${goods.name}<br>
                商品价格：${goods.price}<br>
            </a>
        </div>
    </c:forEach>
</div>

<center>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="${pageBean.currentPage==1?'disabled':''}">
                <a href="goodsServlet?method=showGoodsServlet&goodsTypeId=${param.goodsTypeId}&currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="index">
                <c:if test="${pageBean.currentPage==index}">
                    <li class="active"><a href="goodsServlet?method=showGoodsServlet&goodsTypeId=${param.goodsTypeId}&currentPage=${index}">${index}</a></li>
                </c:if>

                <c:if test="${pageBean.currentPage!=index}">
                    <li><a href="goodsServlet?method=showGoodsServlet&goodsTypeId=${param.goodsTypeId}&currentPage=${index}">${index}</a></li>
                </c:if>
            </c:forEach>

            <li class="${pageBean.currentPage==pageBean.totalPage?'disabled':''}">
                <a href="goodsServlet?method=showGoodsServlet&goodsTypeId=${param.goodsTypeId}&currentPage=${pageBean.currentPage+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</center>
</body>
</html>
