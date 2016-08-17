<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第四页</title>
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
    <input name="openId" value="${openId}" type="hidden">
    <input name="page" value="4" type="hidden">
    <table border="1px" id="address" style="width: 21%">
        <tr>
            <td>题干</td>
            <td style="width: 42%">数据</td>
        </tr>
        <tr>
            <td>糖尿病2曾经1是0否</td>
            <td><input name="hDiab" value="0"></td>
        </tr>
        <tr>
            <td>血管疾病2曾经1是0否</td>
            <td><input name="cvd" value="0"></td>
        </tr>
        <tr>
            <td>心室肥厚2曾经1是0否</td>
            <td><input name="lvh" value="0"></td>
        </tr>
        <tr>
            <td>房颤2曾经1是0否</td>
            <td><input name="af" value="0"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
