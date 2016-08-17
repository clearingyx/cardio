<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.title}</td>
            <td>${list.thumbMediaId}</td>
            <td>${list.author}</td>
            <td>${list.digest}</td>
            <td>${list.showCoverPic}</td>
            <td>${list.content}</td>
            <td>${list.contentSourceUrl}</td>
        </tr>
    </c:forEach>
</table>


    ${pageCount}
</body>
</html>
