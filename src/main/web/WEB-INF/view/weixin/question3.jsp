<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第三页</title>
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
    <input name="page" value="3" type="hidden">
    <table border="1px" id="address" style="width: 21%">
        <tr>
            <td>题干</td>
            <td style="width: 42%">数据</td>
        </tr>
        <tr>
            <td>血压，低于119，等于119</td>
            <td><input name="sbp" value="119"></td>
        </tr>
        <tr>
            <td>正在服用降压药，,0-否，1是</td>
            <td><input name="hyprx" value="0"></td>
        </tr>
        <tr>
            <td>总胆固醇（测评无用）</td>
            <td><input name="tc" value="30"></td>
        </tr>
        <tr>
            <td>某个胆固醇（测评无用）</td>
            <td><input name="ldl" value="20"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
