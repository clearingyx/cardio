<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一页</title>
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
<body onload="btnclick()">
<form action="../question/answer.do" method="post">
    <input name="openid" value="${openid}" type="hidden">
    <input name="page" value="1" type="hidden">
    <table border="1px" id="address" style="width: 21%">
        <tr>
            <td>题干</td>
            <td style="width: 42%">数据</td>
        </tr>
        <tr>
            <td>年龄20-90</td>
            <td><input name="age" value="25"></td>
        </tr>
        <tr>
            <td>性别，1-男，0女</td>
            <td><input name="gender" value="1"></td>
        </tr>
        <tr>
            <td>体重，kg</td>
            <td><input name="weight" value="60"></td>
        </tr>
        <tr>
            <td>身高，cm</td>
            <td><input name="height" value="172"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
