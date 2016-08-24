<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的信息</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/page-my/page-my.css"/>
</head>

<body >
<div class="content" style="background-color:#ececec ">
    <header></header>
    <div style="width: 100%;height: auto">
      <div class="yuan" style="background-image: url('${person.headimgurl}');background-size: 100% 100%"></div>
        <div class="yy" style="margin-left: 32%"></div>
      <p class="cx">${person.phone}</p>
    </div>
    <div style="margin-top: 2rem">
        <p style="color: #aabbcb;font-size: 1.2rem"><a href="../riskJump/myRisk.do?openId=${person.openId}" class="tan">评估结果  </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&gt;     </p>

        <div class="or-spacer">
            <div class="mask" style="background-size: 30% 30%"></div>
        </div>

        <p style="color: #aabbcb;font-size: 1.2rem"><a href="../news/userCollectionList.do?type=0&openId=${person.openId}" class="tan">文章收藏  </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&gt;</p>


        <div class="or-spacer">
            <div class="mask"></div>
        </div>

        <p style="color: #aabbcb;font-size: 1.2rem;padding-bottom: 0.8rem"><a href="../news/userCollectionList.do?type=2&openId=${person.openId}" class="tan">视频收藏  </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&gt;</p>

    </div>
    <footer></footer>
</div>
</body>
<script type="text/javascript" src="js/app.js" ></script>
</html>