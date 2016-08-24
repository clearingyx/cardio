<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>疾病知识</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" href="css/disease/disease.css" />
	</head>
	<body>
		<div class="content">
			<header></header>
			<ul class="dise-list">
				<li class="dise-li" onclick="jumpNewsList(3,'${news.openId}','${news.type}')">
					<div class="li-word">极高危疾病知识
						<div class="li-circle">
							<div class="li-smal"></div>
						</div>
					</div>
				</li>
				<li class="dise-li" onclick="jumpNewsList(2,'${news.openId}','${news.type}')">
					<div class="li-word li-2">高危疾病知识
						<div class="li-circle">
							<div class="li-smal"></div>
						</div>
					</div>
				</li>
				<li class="dise-li" onclick="jumpNewsList(1,'${news.openId}','${news.type}')">
					<div class="li-word li-3">中危疾病知识
						<div class="li-circle">
							<div class="li-smal"></div>
						</div>
					</div>
				</li>
				<li class="dise-li" onclick="jumpNewsList(0,'${news.openId}','${news.type}')">
					<div class="li-word li-4">低危疾病知识
						<div class="li-circle">
							<div class="li-smal"></div>
						</div>
					</div>
				</li>
				<div class="dise-box">
					<div class="white-box"></div>
				</div>
			</ul>
			<footer>
			</footer>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/app.js" ></script>
	<script type="application/javascript">
		function jumpNewsList(riskLevel, openId, type){
			location.href = "../viewBiz/news.do?riskLevel="+riskLevel+"&openId="+openId+"&type="+type;
		}
	</script>
</html>
