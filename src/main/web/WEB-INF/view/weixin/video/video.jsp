<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>
			<c:if test="${news.type == 1}">健康资讯</c:if>
			<c:if test="${news.type == 0}">疾病知识</c:if>
			<c:if test="${news.type == 2}">视频收藏</c:if>
		</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" href="css/knowledge/knowledge.css" />
		<link rel="stylesheet" href="css/science/science.css" />
	</head>
	<body>
		<div class="content">
			<header></header>
			<article id="wrapper">
				<div id="scrollBox">
					<ul class="list">
						<c:forEach var="list" items="${list}">
							<li class="list-li" onclick="collection(${list.id})">
								<div class="li-left">
									<img src="../..${list.coverImg}"/>
								</div>
								<div class="li-right">
									<h3>${list.coverTitle}</h3>
									<p>
										<c:if test="${news.type != 2}">
											${list.coverContent}
										</c:if>
										<c:if test="${news.type == 2}">
											<c:set value="${ fn:split(list.coverContent, ',') }" var="names" />
											<span class="li-name">${names[0]}</span>
											<span class="li-plice">${names[1]}</span>
											<span class="li-work">${names[2]}</span>
										</c:if>
									</p>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</article>
			<div class="foot-box">
				<footer>
				</footer>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/knowledge/iscroll.js" ></script>
	<script type="text/javascript" src="js/app.js" ></script>
	<script type="text/javascript" src="js/video/video.js" ></script>
	<script type="application/javascript">
		function collection(id){
			location.href="../news/newsById.do?openId=${news.openId}&type=${news.type}&newsId="+id;
		}
	</script>
</html>
