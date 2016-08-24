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
            <img src="img/result/xhr.png" style="height:2.63rem;margin-left: 1.5rem">
           <p class="bf">18.3%</p>
           <p class="gl">心脑血管发生事件概率</p>
           <img src="img/result/TB.png" style="position: absolute;height: 1.43rem;margin-left: 8.5rem">
           <hr width="90%" color="#acb4af" size="1px" style="margin-top: 0rem">
         </div>
         <div>
            <img src="img/result/xhr1.png" style="height: 2.9rem;margin-left: 1.5rem">
             <div class="sb">3倍</div>
             <p class="dyh"> > </p>
             <img style="height: 2.9rem;margin-left: 3.2rem" src="img/result/xr3.png">
             <p class="sbwz">相比同龄健康人风险超过3倍</p>

         </div>
         <div style="height:2.2rem;margin-top: -0.4rem">
            <div class="xgwx"></div>
             <img style="z-index: 100;position: absolute;margin-top: -2rem;width: 2.2rem;margin-left: 0.8rem;" src="img/result/hswx.png">
             <hr width="33%" color="#00849f" size="2px" style="margin-top: 0rem;position: absolute;margin-left: 51%;margin-top: -0.8rem">
             <p style="color:#00849f;font-size: 0.75rem;position: absolute;margin-top: -1.3rem;margin-left: 3rem">血管健康危险因素</p>
         </div>
         <div>
            <img src="img/result/gtgc.png" style="width:2.1rem;margin-left: 1.7rem;">
             <p style="position: absolute;color: #0099b8;font-size: 0.9rem;margin-left: 4rem;margin-top: -2rem">高胆固醇</p>
             <img src="img/result/gxy.png" style="width:2.1rem;margin-left: 4.5rem;">
             <p style="position: absolute;color: #0099b8;font-size: 0.9rem;margin-left: 11rem;margin-top: -2rem">高血压</p>
         </div>
         <hr width="90%" color="#acb4af" size="1px" style="margin-top: 0rem">
         <div>
             <img src="img/result/gxt.png" style="height: 2.36rem;margin-left: 1.7rem">
             <p style="color:#00849f;font-size: 0.8rem;position: absolute;margin-left: 1.4rem">高血糖</p>
             <img src="img/result/xy.png" style="height: 2.3rem;margin-left: 1.2rem">
             <p style="color:#00849f;font-size: 0.8rem;position: absolute;margin-left: 5rem">吸烟</p>
             <img src="img/result/fp.png" style="height: 2.36rem;margin-left: 1rem">
             <p style="color:#00849f;font-size: 0.8rem;position: absolute;margin-left:9rem">肥胖</p>
             <img src="img/result/jzs.png" style="height: 2.36rem;margin-left: 1.7rem">
             <p style="color:#00849f;font-size: 0.8rem;position: absolute;margin-left: 12.4rem">家族史</p>
         </div>
       </div>
       <a href="result-yellow1.jsp"><img src="img/result/right.png" style="width: 1.55rem;float:right;margin-top: 1rem"></a>
   </div>
 </div>
</body>
<script type="text/javascript" src="js/result/app.js" ></script>
</html>