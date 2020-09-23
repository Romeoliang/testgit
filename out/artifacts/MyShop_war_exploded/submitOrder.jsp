<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JI
  Date: 2020/9/15
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入Bootstrap静态样式CSS--%>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<html>
<head>
    <title>submitOrder</title>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>


<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading" align="center" style="font-size: 25px;color: red">请核对订单信息</div>

    <!-- Table -->
    <table class="table">
        <tr style="background-color: lightskyblue">
            <th colspan="5" align="center">收货地址</th>
        </tr>
        <tr style="background-color: lightskyblue">
            <th>详细地址</th>
            <th>收货人</th>
            <th>联系电话</th>
            <th>默认地址</th>
        </tr>
        <tr>
            <td>${defaultAddress.detail}</td>
            <td>${defaultAddress.name}</td>
            <td>${defaultAddress.phone}</td>
            <td>${defaultAddress.level}</td>
        </tr>
        <tr>
            <td align="center" colspan="4">
                <a href="#">修改或添加地址</a>
            </td>
        </tr>
    </table>
    <hr>
    <!-- Table -->
    <table class="table">
        <tr style="background-color: lightskyblue">
            <th colspan="5" align="center">送货清单</th>
        </tr>
        <tr>
            <th>图片</th>
            <th>商品</th>
            <th>价格</th>
            <th>数量</th>
            <th>小计</th>
        </tr>
        <c:set value="0" var="sum"></c:set>
        <c:forEach items="${cartList}" var="cart">
            <tr>
                <td>${cart.goods.picture}</td>
                <td>${cart.goods.name}</td>
                <td>${cart.goods.price}</td>
                <td>
                    <div class="input-group">
                        <span>
                            <input type="text" class="form-control" id="num_cid${cart.cid}" value="${cart.num}" readonly="readonly"
                                   style="width: 40px">
                        </span>
                    </div><!-- /input-group -->
                </td>
                <td style="color: red">${cart.money}</td>
            </tr>
            <c:set var="sum" value="${sum + cart.money}"></c:set>
        </c:forEach>
        <tr>
            <td colspan="6" align="center" style="color: red">
                <span>总价:</span>
                <c:out value="${sum}"/>
            </td>
        </tr>
        <tr style="height: 60px;font-size: 30px">
            <td colspan="4" align="center" style="color: red">
                <a href="order?method=addOrder&uid=${user.id}&aid=${defaultAddress.aid}&money=${sum}">提交订单</a>
            </td>
        </tr>
    </table>

</div>

</body>
</html>
