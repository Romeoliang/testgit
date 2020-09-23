<%--
  Created by IntelliJ IDEA.
  User: JI
  Date: 2020/9/17
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>address</title>
</head>
<body>
<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>


<div class="panel panel-default">
<!-- Default panel contents -->
<div class="panel-heading" align="center" style="font-size: 25px;color: deepskyblue">我的收货地址</div>

<!-- Table -->
    <table class="table">
        <tr>
            <th>地址</th>
            <th>收件人</th>
            <th>联系电话</th>
            <th>默认地址</th>
            <th>操作</th>
        </tr>
    </table>
</div>
</body>
</html>
