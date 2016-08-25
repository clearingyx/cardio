<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>视频详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/page-tv1/page-tv1.css"/>
</head>
<body>
<div class="content">
    <header></header>
    <p class="rh">${news.coverTitle}</p>
    <p style="padding-left: 3rem;margin-top: 0.5rem;font-size: 0.72rem;margin-bottom: 0.5rem">
        <c:set value="${ fn:split(news.coverContent, ',') }" var="names" />
        ${names[0]} ${names[1]} ${names[2]}
    </p>
    <div class="wmm">
        <video style="padding-top: 1rem;padding-left: 1rem;" width="280" height="200" controls="controls">
            <source src="../..${news.videoUrl}" type="video/mp4" />
        </video>
    </div>
    <div style="border: 1px solid #bdbdbd; width: 80%;margin: 0.5rem auto;"></div>
    <div style="margin: 0 auto;width: 80%;margin-left: 12%" id="content">
        ${news.content}
    </div>
    <div style="padding-left: 55%;margin:0.5rem 0 ">
        <a class="jjk" id="collection"><img style="width: 10%" src="../../img/page-tv1/sc.png">
            <c:if test="${collectionId == 0}">收藏</c:if>
            <c:if test="${collectionId > 0}">取消收藏</c:if>
        </a>
        <a class="jjk1" href="#"><img style="width: 10%" src="../../img/page-tv1/fx.png">分享</a>
    </div>
    <div class="aabb"></div>
    <footer></footer>
</div>
</body>
<script type="text/javascript" src="js/app.js" ></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript">
    $(function(){
        $("#content img").attr("style","width:100%;display: block;");

        var collectionId = ${collectionId};
        var url;
        if (collectionId == 0){ //没有收藏
            url = "../news/collection.do?newsId=${news.id}&openId=${openId}";
        } else { //已经收藏
            url = "../news/collection.do?newsId=${news.id}&openId=${openId}&id=${collectionId}";
        }
        $("#collection").click(function(){
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