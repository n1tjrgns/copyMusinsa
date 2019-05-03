<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019-04-28
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
<h1>회원가입하기</h1>
<form action="signUp.do" method="post" name="signupForm" id="signupForm">
    <p>이메일 : <input type="email" name="userEmail"></p>
    <p>비밀번호 : <input type="password" name="userPassword"></p>
    <p>이름: <input type="text" name="userName"></p>
    <p><input type="submit" value="회원가입"/></p>
</form>

</body>
</html>

