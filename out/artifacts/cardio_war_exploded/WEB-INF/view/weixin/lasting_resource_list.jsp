<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
因为是微信的图片，非微信是无法展示的，所以这里只是展示url，并不做为img的src进行展示<br><br><br>
下面开始list遍历：<br>
    <c:forEach var="list" items="${list}">
        ${list.mediaId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${list.type}&nbsp;&nbsp;&nbsp;&nbsp;${list.url}
        &nbsp;&nbsp;&nbsp;&nbsp;${list.desc}
    </c:forEach>
    ${pageCount}
</body>
</html>
