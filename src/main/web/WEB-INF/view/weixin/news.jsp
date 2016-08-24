<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>资讯列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <script language="javascript">
        function btnclick() {
            var address = document.getElementById("address");
            var trs = address.getElementsByTagName("tr");

            for (var i = 0; i < trs.length; i++) {
                var tr = trs[i];
                if (i % 2 == 0) {
                    tr.style.background = "cornflowerblue";
                }
                else {
                    tr.style.background = "white";
                }
            }
        }
    </script>
</head>
<body>
总行数：${rowCount}<br>
总页数：${pageCount}<br>
openId：${openId}<br>
<table border="1px" id="address" style="width: 100%">
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
