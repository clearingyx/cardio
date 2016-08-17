<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>答题页面</title>
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
    <input name="page" value="5" type="hidden">
    <table border="1px" id="address" style="width: 21%">
        <tr>
            <td>题干</td>
            <td style="width: 42%">数据</td>
        </tr>
        <%--<tr>--%>
            <%--<td>年龄20-90</td>--%>
            <%--<td><input name="age" value="25"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>性别，1-男，0女</td>--%>
            <%--<td><input name="gender" value="1"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>体重，kg</td>--%>
            <%--<td><input name="weight" value="60"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>身高，cm</td>--%>
            <%--<td><input name="height" value="172"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>吸烟，0-否，1是</td>--%>
            <%--<td><input name="hSmk" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>喝酒,0-否，1是</td>--%>
            <%--<td><input name="hDrink" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>吃水果,0-否，1是</td>--%>
            <%--<td><input name="diet" value="1"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>运动,0-否，1是</td>--%>
            <%--<td><input name="activity" value="1"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>压力大,0-否，1是</td>--%>
            <%--<td><input name="stress" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>家庭遗传,0-否，1是</td>--%>
            <%--<td><input name="familys" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>血压，低于119，等于119</td>--%>
            <%--<td><input name="sbp" value="119"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>正在服用降压药，,0-否，1是</td>--%>
            <%--<td><input name="hyprx" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>总胆固醇（测评无用）</td>--%>
            <%--<td><input name="tc" value="30"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>某个胆固醇（测评无用）</td>--%>
            <%--<td><input name="ldl" value="20"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>糖尿病2曾经1是0否</td>--%>
            <%--<td><input name="hDiab" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>血管疾病2曾经1是0否</td>--%>
            <%--<td><input name="cvd" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>心室肥厚2曾经1是0否</td>--%>
            <%--<td><input name="lvh" value="0"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>房颤2曾经1是0否</td>--%>
            <%--<td><input name="af" value="0"></td>--%>
        <%--</tr>--%>
        <tr>
            <td>痴呆2曾经1是0否</td>
            <td><input name="cognitive" value="0"></td>
        </tr>
        <tr>
            <td>记忆力差1是2否</td>
            <td><input name="poorMemory" value="0"></td>
        </tr>
        <tr>
            <td>脑损伤2曾经1是0否</td>
            <td><input name="injury" value="0"></td>
        </tr>
        <tr>
            <td>小中风2曾经1是0否</td>
            <td><input name="miniStroke" value="0"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
