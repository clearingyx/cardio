<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>答题页面</title>
</head>
<body>
    <form action="../risk/risk.do" method="get">
        用户id<input name="personId" value="6"><br>
        年龄<input name="age" value="25"><br>
        性别，1-男，0女<input name="gender" value="1"><br>
        体重，kg<input name="weight" value="60"><br>
        身高，cm<input name="height" value="172"><br>
        吸烟，0-否，1是<input name="hSmk" value="0"><br>
        喝酒<input name="hDrink" value="0"><br>
        吃水果<input name="diet" value="1"><br>
        运动<input name="activity" value="1"><br>
        压力大<input name="stress" value="0"><br>
        家庭遗传<input name="familys" value="0"><br>
        血压，低于119，等于119<input name="sbp" value="119"><br>
        正在服用降压药，1是<input name="hyprx" value="0"><br>
        总胆固醇（无用）<input name="tc" value="30"><br>
        某个胆固醇（无用）<input name="ldl" value="20"><br>
        糖尿病2曾经1是0否<input name="hDiab" value="0"><br>
        血管疾病<input name="cvd" value="0"><br>
        心室肥厚<input name="lvh" value="0"><br>
        房颤<input name="af" value="0"><br>
        痴呆<input name="cognitive" value="0"><br>
        记忆力差1是2否<input name="poorMemory" value="0"><br>
        脑损伤<input name="injury" value="0"><br>
        小中风<input name="miniStroke" value="0"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
