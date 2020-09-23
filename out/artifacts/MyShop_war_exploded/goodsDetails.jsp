<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JI
  Date: 2020/9/15
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入Bootstrap静态样式CSS--%>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">


<html>
<head>
    <title>goodsDetails</title>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>
<div class="page-header">
    <h3><a href="goodsServlet?method=showGoodsServlet&goodsTypeId=${goods.typeid}&currentPage=1">继续购买此类商品</a></h3>
</div>

<div align="center" style="font-size: 25px" >
    商品ID：${goods.id}<br>
    商品名字：${goods.name}<br>
    商品价格：${goods.price}<br>
    商品信息：${goods.info}<br>
    商品图片：${goods.picture}<br>
    <a href="#">立即购买</a>
    <a href="cart?method=addCart&goodId=${goods.id}">加入购物车</a>
</div>
</body>
</html>
