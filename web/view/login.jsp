<%@ taglib prefix="onclick" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019-04-28
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>

    <h1>로그인</h1>
    <form method="post" action="login.do">
        <p>이메일 : <input type="email" name="userEmail"></p>
        <p>비밀번호 : <input type="password" name="userPassword"></p>
        <p>
            <input type="submit" value="로그인"/>
            <input type="button" value="회원가입" onclick="location.href='/FakeSinsa/view/signup.jsp'" ;/>
        </p>


    </form>
</head>
<body>

</body>
</html>
