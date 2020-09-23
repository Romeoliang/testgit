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
    <title>cart</title>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>


<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading" align="center" style="font-size: 25px;color: deepskyblue">购物车</div>

    <!-- Table -->
    <table class="table">
        <tr>
            <th>图片</th>
            <th>商品</th>
            <th>价格</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        <c:set value="0" var="sum"></c:set>
        <c:forEach items="${cartList}" var="cart">
            <tr>
                <td>${cart.goods.picture}</td>
                <td>${cart.goods.name}</td>
                <td>${cart.goods.price}</td>
                <td>
                    <div class="input-group">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"
                                    onclick="subtract(${cart.cid},${cart.num},${cart.goods.price})">-</button>
                            <script>
                                function subtract(cid, num, price) {
                                    if (num === 1) {
                                        if (confirm("目前此商品在购物车中只有一个,确定要移除吗?")) {
                                            location.href = "cart?method=delete&cid=" + cid;
                                        }
                                    } else {
                                        num--;
                                        location.href = "cart?method=modify&cid=" + cid + "&num=" + num + "&price=" + price;
                                    }
                                }
                            </script>
                        </span>
                        <span>
                            <input type="text" class="form-control" id="num_cid${cart.cid}" value="${cart.num}"
                                   readonly="readonly"
                                   style="width: 40px">
                        </span>
                        <span>
                            <button class="btn btn-default" type="button"
                                    onclick="addNum(${cart.cid},${cart.num},${cart.goods.price})">+</button>
                            <script>
                                function addNum(cid, num, price) {
                                    num++;
                                    location.href = "cart?method=modify&cid=" + cid + "&num=" + num + "&price=" + price;
                                }
                            </script>
                        </span>
                    </div><!-- /input-group -->
                </td>
                <td style="color: red">${cart.money}</td>
                <td>
                    <button class="btn btn-default" type="button" onclick="delCart(${cart.cid})">删除</button>
                    <script>
                        function delCart(cid) {
                            if (confirm("确认删除?")) {
                                location.href = "cart?method=delete&cid=" + cid;
                            }
                        }
                    </script>
                </td>
            </tr>
            <c:set var="sum" value="${sum + cart.money}"></c:set>
        </c:forEach>
        <tr>
            <td colspan="6" align="center" style="color: red">
                <span>总价:</span>
                <c:out value="${sum}"/>
            </td>
        </tr>
        <c:choose>
            <c:when test="${cartList.size() != 0}">
                <tr style="height: 60px;font-size: 30px">
                    <td colspan="4" align="center" style="color: red">
                        <a href="order?method=submitOrder">去结算</a>
                    </td>
                    <td colspan="2" align="center" style="color: red">
                        <a href="javascript:void(0);" onclick="clearCart()">清空购物车</a>
                        <script>
                            function clearCart() {
                                if (confirm("确定要清空购物车吗?")) {
                                    location.href = "cart?method=clearCart";
                                }
                            }
                        </script>
                    </td>
                </tr>
            </c:when>
            <c:when test="${cartList.size() == 0}">
                <tr>
                    <td colspan="6" align="center">
                        <a href="index.jsp">购物车里什么也没有,快去购买商品吧!!</a>
                    </td>
                </tr>
            </c:when>
        </c:choose>
    </table>
</div>

</body>
</html>
