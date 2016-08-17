<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="../reg/reg.do" method="post">
        <input value="${openid}" name="openid" type="text">
        <input value="" name="phone">
        <input name="code"><!-- 验证码 -->
        <input type="submit" value="submit">
    </form>
</body>
</html>
