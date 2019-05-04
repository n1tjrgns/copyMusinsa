<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019-05-02
  Time: 오전 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("selectProduct")==null){
    %>
    <script>
        console.log('값 없음');
    </script>
<%
}else{%>
<script>
    console.log('값 있음');
</script>
<%}%>
<html>
<head>
    <title>메인 페이지</title>
    <h1>메인 페이지</h1>

    <p><h3>상품</h3></p>

    <table border="1">
        <thead>
        <tr>
            <th>종류</th>
            <th>이름</th>
            <th>가격</th>
            <th>상세내용</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="result" items="${selectProduct}">
        <tr>
            <td>${result.product_category}</td>
            <td>${result.product_name}</td>
            <td>${result.product_price}</td>
            <td>${result.product_detail}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</head>
<body>

</body>
</html>

