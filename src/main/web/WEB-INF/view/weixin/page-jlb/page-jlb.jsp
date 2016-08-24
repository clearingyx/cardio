<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>俱乐部介绍</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/page-jlb/page-jlb.css"/>
</head>
<body>
<div class="content" style="background-color:#ececec;">
    <div style="width: 90%;margin: 0 auto;height: auto">
    <header></header>
          <%--<p class="yi">中国百万计划患者俱乐部，是由中国卒中学会发起、辉瑞制药企业赞助的慢病患者健康教育平台。</p>--%>
             <%--<div class="ling"></div>--%>
          <%--<p class="er">中国百万计划患者俱乐部，是由中国卒中学会发起、辉瑞制药企业赞助的慢病患者健康教育平台。</p>--%>
            ${content}
        </div>
       <footer></footer>
</div>
</body>
   <script type="text/javascript" src="js/app.js" ></script>
    <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        $(function(){
            $("img").attr("style","width:100%;display: block;");
        })
    </script>
</html>