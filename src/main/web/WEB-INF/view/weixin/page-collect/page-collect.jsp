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
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>健康资讯</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/page-collect/page-collect.css"/>
</head>
<body style="font-family: 微软雅黑">
<div class="content">
    <header></header>
    <div style="padding-left: 13%">
        <div class="wc">
            <h1 class="qdyz">${news.coverTitle}</h1>
            <div class="wzjs">${news.content}</div>
            <%--<h2 class="dys">1.多饮水</h2>--%>
            <%--<p class="wzjs">高血脂患者血液粘稠度增高、血流速度减慢,促使血小板在局部沉积,易形成血栓.</p>--%>
            <%--<div class="tp"></div>--%>
            <div style="padding-left: 45%;margin:0.2rem 0 ;">
                <a class="lj" id="collection"><img src="../../img/page-collect/sc.png" style="width: 10%">
                    <c:if test="${collectionId == 0}">收藏</c:if>
                    <c:if test="${collectionId > 0}">取消收藏</c:if>
                </a>
                <a class="lj1"><img style="width: 10%" src="../../img/page-collect/fx.png">分享</a>
            </div>
            <div class="xian"></div>
            <%--<h2 style="color:#1c538a;font-size: 0.8rem">相关推荐</h2>--%>
            <%--<div class="tj">.&nbsp;</div><div  class="yfqd">防治高血脂的七大饮食原则</div>--%>
            <%--<div class="tj">.&nbsp;</div><div  class="yfqd">7大食物养生降血脂可有效预防高血脂病</div>--%>
            <%--<div class="tj">.&nbsp;</div><div  class="yfqd">血脂高的症状及治疗</div>--%>
        </div>
    </div>
    <footer style="margin-top: 25.2rem"></footer>
</div>
</body>
<script type="text/javascript" src="js/app.js" ></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript">
    $(function(){
        $("div.wc div:first img").attr("style","width:100%;display: block;");
        $("#collection").click(function(){
            var collectionId = ${collectionId};
            var url;
            if (collectionId == 0){ //没有收藏
                url = "../news/collection.do?newsId=${news.id}&openId=${openId}";
            } else { //已经收藏
                url = "../news/collection.do?newsId=${news.id}&openId=${openId}&id=${collectionId}";
            }

            $.get(url,
                function(data){
                    if (data.data == "success"){
                        location.reload();
                    } else {
                        alert(data.msg);
                    }
                }
            )
        })
    })
</script>
</html>