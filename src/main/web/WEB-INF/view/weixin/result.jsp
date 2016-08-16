<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>结果页</title>
</head>
<body>
    危险等级：<c:if test="${risk.risk_level==0}">低危险</c:if>
    <c:if test="${risk.risk_level==1}">中危险</c:if>
    <c:if test="${risk.risk_level==2}">高危险</c:if>
    <c:if test="${risk.risk_level==3}">极高危险</c:if>
    <br>
    患病百分比：${risk.risk_correct}%<br>
    <br>
    倍数：${risk.multiple}<br>
    <br>
    以下是展示选项
    <br>
    吸烟： <c:if test="${risk.hSmk == 0}">不吸烟，不展示</c:if><c:if test="${risk.hSmk == 1}">吸烟，展示</c:if><br>
    血压值： <c:if test="${risk.sbp == 0}">血压正常，不展示</c:if><c:if test="${risk.sbp == 1}">血压偏高，展示</c:if><br>
    胆固醇值： <c:if test="${risk.tc == 0}">胆固醇正常，不展示</c:if><c:if test="${risk.tc == 1}">胆固醇超高，展示</c:if><br>
    糖尿病： <c:if test="${risk.hDiab == 0}">没有糖尿病，不展示</c:if><c:if test="${risk.hDiab == 1}">有糖尿病，展示</c:if><br>
    bmi：<c:if test="${risk.bmi == 0}">正常，不展示</c:if><c:if test="${risk.hDiab == 1}">超重，展示</c:if><br>
</body>
</html>
