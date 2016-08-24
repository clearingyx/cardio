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
		<base href="<%=basePath%>">
		<title>注册成功</title>
	    <link rel="stylesheet" href="css/shouye/common.css" />
	   	<link rel="stylesheet" href="css/shouye/style.css" />
	   	<link rel="stylesheet" href="css/page-zc/index.css" />
	</head>
	<body>
	<input type="hidden" value="${openId}" id="openId">
		<div class="content">
			<div class="head-img">
				<div class="img-left"></div>
				<div class="img-right">
					<div class="img-logo"></div>
				</div>
			</div>
			<div class="sy-head">
				<div class="sy-top">
					<div class="img-cloude1"></div>
					<div class="img-lamp"></div>
				</div>
				<p class="sy-word"></p>
				<div class="img-cloude2"></div>
			</div>
			<div class="sy-box">
				<p class="zc-word zc-pad">您已注册成功！</p>
				<p class="zc-word zc-line">欢迎加入</p>
				<div class="img-millions">中国<img src="img/word.png"/>计划</div>
				<p class="english">MILLION&nbsp;FOR&nbsp;MILLIONS</p>
			</div>
			<div class="nxt" id="ensure">
				<p class="strat">开始测试</p>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/shouye/zepto.js" ></script>
	<script type="text/javascript" src="js/shouye/app.js"></script>
	<script type="text/javascript" src="js/page-zc/index.js"></script>
</html>