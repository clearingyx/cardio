<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="../jquery-1.7.1.min.js" type="application/javascript"></script>
</head>
<body>
    <form action="../sourceBiz/lastingImageTextAdd.do" method="post">
        <select name="thumbMediaId">
            <c:forEach var="list" items="${list}">
                <option value="${list.mediaId}">${list.remark}</option>
            </c:forEach>
        </select><br>
        标题：<input name="title" value="图文测试"><br>
        作者：<input name="author" value="百万俱乐部"><br>
        摘要：<input name="digest" value="这个是单独图文消息的摘要"><br>
        封面展示：<input type="radio" name="showCoverPic" value="0">不显示<input type="radio" name="showCoverPic" value="1" checked="checked">显示<br><br>
        内容：<input name="content" value="这里是内容"><br>
        详情url：<input name="contentSourceUrl" value="http://www.baidu.com"><br>
        描述：<input name="remark" value="图文描述"><br>
        <input value="submit" type="submit">
    </form>
</body>
</html>
