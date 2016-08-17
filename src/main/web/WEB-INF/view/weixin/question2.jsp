<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第二页</title>
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
    <input name="page" value="2" type="hidden">
    <table border="1px" id="address" style="width: 21%">
        <tr>
            <td>题干</td>
            <td style="width: 42%">数据</td>
        </tr>
        <tr>
            <td>吸烟，0-否，1是</td>
            <td><input name="hSmk" value="0"></td>
        </tr>
        <tr>
            <td>喝酒,0-否，1是</td>
            <td><input name="hDrink" value="0"></td>
        </tr>
        <tr>
            <td>吃水果,0-否，1是</td>
            <td><input name="diet" value="1"></td>
        </tr>
        <tr>
            <td>运动,0-否，1是</td>
            <td><input name="activity" value="1"></td>
        </tr>
        <tr>
            <td>压力大,0-否，1是</td>
            <td><input name="stress" value="0"></td>
        </tr>
        <tr>
            <td>家庭遗传,0-否，1是</td>
            <td><input name="familys" value="0"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
