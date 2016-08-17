<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>咨询列表</title>
    <script language="javascript">
    </script>
</head>
<body>
<table border="1" bgcolor="#6495ed">
    总行数：${rowCount}<br>
    总页数：${pageCount}<br>
    <tr><td>图片</td><td>标题</td><td>内容</td><td>收藏</td></tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.coverImg}</td>
            <td>${list.coverTitle}</td>
            <td>${list.coverContent}</td>
            <td><a style="color: blue;" href="../collection/collection?news_id=${list.id}&openid=${openid}">点击收藏</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
