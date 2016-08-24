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
    <link rel="stylesheet" href="css/result/result-yellow.css" />
    <link rel="stylesheet" type="text/css" href="css/result/common.css"/>
</head>
<body>
<div class="bjtp content">
    <div class="bk">
        <div class="xx">
            <div>
                <img src="img/result/hss.png" style="width: 90%;margin-left: 5%;margin-top: -0.5rem">
                <p class="jkfx">血管健康风险</p>
                <p class="lsyj">黄色预警</p>
            </div>
            <div>
                <div class="yfcs">预防措施</div>
                <div class="ywzl"></div>
                <img src="img/result/hyw.png" class="lyw">
                <p style="color:#00849f;font-size: 0.73rem;margin-left: 3.2rem;margin-top: 1.1rem">药物治疗</p>
                <div class="kj">
                    <img src="img/result/eee.png" style="position: absolute;width:3.9rem;margin-top: -0.3rem;margin-left: 0.4rem;">
                    <p style="font-size: 0.7rem;color:#00849f;position: absolute;margin-top: 0.35rem;margin-left: 0.6rem">血脂目标值</p>
                    <p style="margin-left: 1rem;margin-top: 1.5rem;position: absolute;color: #ffffff;font-size: 1rem;"> <3.37 </p>
                    <p style="margin-left: 1.5rem;margin-top:2.5rem;position: absolute;color: #ffffff;font-size: 0.5rem;">mmol/L</p>

                    <img src="img/result/eee.png" style="position: absolute;width:3.9rem;margin-top: -0.3rem;margin-left: 5rem">
                    <p style="font-size: 0.7rem;color:#00849f;position: absolute;margin-top: 0.35rem;margin-left: 5.2rem">血压目标值</p>
                    <p style="margin-left: 5.1rem;margin-top: 1.5rem;position: absolute;color: #ffffff;font-size: 0.9rem;"> <140/90 </p>
                    <p style="margin-left: 6.2rem;margin-top:2.5rem;position: absolute;color: #ffffff;font-size: 0.5rem;">mmhg</p>

                    <img src="img/result/eee.png" style="position: absolute;width:3.9rem;margin-top: -0.3rem;margin-left: 9.8rem">
                    <p style="font-size: 0.7rem;color:#00849f;position: absolute;margin-top: 0.35rem;margin-left: 9.6rem">长期规范治疗</p>
                    <img src="img/result/cqff.png" style="width: 2.4rem;position: absolute;margin-left: 10.5rem;margin-top: 1.4rem">
                </div>
                <hr width="90%" color="#acb4af" size="1px" style="margin-top: 0rem">
                <div>
                    <div class="ywzl1"></div>
                    <img src="img/result/gssh.png" class="lyw1">
                    <p style="position: absolute;color:#00849f;font-size: 0.73rem;margin-left: 3.2rem;margin-top:0.45rem">生活方式改善</p>
                </div>
                <div class="kj1">
                    <img src="img/result/dl.png" style="position: absolute;width: 3rem;margin-left: 0.4rem;margin-top: -0.2rem">
                    <p class="dl">锻炼</p>
                    <img src="img/result/ys.png" style="position: absolute;width: 3rem;margin-left: 3.8rem;margin-top: -0.2rem">
                    <p class="ys">饮食</p>
                    <img src="img/result/jz.png" style="position: absolute;width: 3rem;margin-left: 7.1rem;margin-top: -0.2rem">
                    <p class="jz">减重</p>
                    <img src="img/result/jy.png" style="position: absolute;width: 3rem;margin-left: 10.5rem;margin-top: -0.2rem">
                    <p class="jy">禁烟</p>
                </div>
            </div>
        </div>
        <a href="result-yellow.jsp"><img src="img/result/left.png" style="width: 1.55rem;margin-top: 1rem;position: absolute;float:left"></a>
        <a href="result-yellow2.jsp"><img src="img/result/right.png" style="width: 1.55rem;float:right;margin-top: 1rem"></a>
    </div>
</div>
</body>
<script type="text/javascript" src="js/result/app.js" ></script>
</html>