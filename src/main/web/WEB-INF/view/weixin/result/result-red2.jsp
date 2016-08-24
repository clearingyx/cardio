<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>评估结果</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="css/result/result-red.css" />
    <link rel="stylesheet" type="text/css" href="css/result/common.css"/>
</head>
<body>
<div class="bjtp content">
    <div class="bk">
        <div class="xx">
            <div>
                <img src="img/result/hss1.png" style="width: 90%;margin-left: 5%;margin-top: -0.5rem">
                <p class="jkfx">血管健康风险</p>
                <p class="lsyj">红色预警</p>
            </div>
            <div>
                <div class="yfcs">积极预防治疗胜利于住院和手术</div>
                <div class="ywzl3"></div>
                <img src="img/result/hyw1.png" class="lyw3">
                <img src="img/result/jt.png" class="jt">
                <p style="position: absolute;color:#00849f;font-size: 0.8rem;margin-left: 3.2rem;margin-top:1rem">积极药物治疗</p>
                <img src="img/result/li.png" style="position: absolute;width: 0.9rem;margin-top: 3rem;margin-left: 1rem">
                <p class="sq"><img src="img/result/3000.png" class="sq1">进口阿托伐他汀 X 1年 ≈ </p>
                <p class="yqw"><img src="img/result/1500.png" class="yqw1">进口氨氯地平&nbsp;&nbsp; X 1年 ≈ </p>
                <p style="margin-top: -2.3rem;" class="yuan">3000元</p>
                <p style="margin-top: -1.2rem;" class="yuan">1500元</p>
                <p style="font-size: 0.35rem;color:#00849f;margin-left: 2rem;margin-bottom: 0.3rem">* 具体药物花费请参考当地价格及医保政策</p>
            </div>
            <hr width="90%" color="#acb4af" size="1px" style="margin-top: 0rem">
            <div>
                <div class="ywzl2"></div>
                <img src="img/result/zyzl3.png" class="lyw2">
                <p style="position: absolute;color:#00849f;font-size: 0.73rem;margin-left: 3.2rem;margin-top: 0.34rem">住院治疗</p>
                <img src="img/result/jt1.png" class="jt1">
                <p class="lws"><img src="img/result/zyjg.png" class="lws1">住院 X 1年 ≈ </p>
                <p class="lws2">24000元</p>
                <p style="color: #00849f;font-size:0.4rem;position: absolute;margin-top: 3.3rem;margin-left: 2.5rem">* 数据出自 《中国心血管病报告2015》</p>
            </div>
            <hr width="90%" color="#acb4af" size="1px" style="margin-top: 4.5rem">
            <div>
                <div class="ywzl4"></div>
                <img src="img/result/zjzl3.png" class="lyw4">
                <p style="position: absolute;color:#00849f;font-size: 0.73rem;margin-left: 3.2rem;margin-top: 0.5rem">支架治疗</p>
                <img src="img/result/jt1.png" class="jt1">
                <p class="jkzj"><img src="img/result/zjjg.png" class="jkzj1">进口=支架 X 1年 ≈ </p>
                <p style="position: absolute;font-size: 0.8rem;color:#ec0004;margin-top: 2rem;margin-left: 11rem">20000元</p>
            </div>
        </div>
        <a href="result-red1.jsp"><img src="img/result/left.png" style="width: 1.55rem;margin-top: 1rem;position: absolute;float:left"></a>
        <a href="../../page-tv/page-tv.html"><img src="img/result/sp.png" style="width: 1.55rem;float:right;margin-top: 1rem"></a>
    </div>
</div>

</body>
<script type="text/javascript" src="js/result/app.js" ></script>
</html>