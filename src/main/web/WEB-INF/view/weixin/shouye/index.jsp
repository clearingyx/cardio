<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
	<html lang="en">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<head>
		<meta charset="UTF-8">
		<title>百万计划</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" href="css/shouye/common.css" />
		<link rel="stylesheet" href="css/shouye/style.css">
	</head>
	<body>
	<input type="hidden" id="openId" value="${openId}" />
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
				<!--<p class="sy-word">血管健康风险警报器</p>-->
				<p class="sy-word"></p>
				<div class="img-cloude2"></div>
			</div>
			<div class="sy-box">
				<div class="list">
					<div class="list-con"></div>
					<span class="list-til">请注册</span>
					<input class="end inp" type="text" name="firstname" placeholder="手机号" id="phone"/>
					<div class="inp-box">
						<input class="endl inp" type="text" name="lastname" placeholder="验证码" id="code"/>
						<div class="psw-btn" id="psw-btn">
							<div class="list-pwd">获取验证码</div>
						</div>
					</div>
					<div class="next nxt" id="ensure">确定</div>
					<!--<li>
						<input  class="two end shadow-inside" type="text" name="firstname" placeholder="输入手机号">
					</li>
					<li style="z-index: 1500;position: relative;">
						<input  placeholder="输入验证码" class="two end1 shadow-inside" type="text" name="lastname">
						<div class="psw-btn" id="psw-btn" >获取验证码</div>
					</li>-->
				</div>
			</div>
			<!--<div class="bg-box beitp">
				<a href="page-zc/zhccg.jsp"><img src="img/qran.png" style="width: 40%; position: absolute;margin-top: 8rem;margin-left: 30%"></a>
			</div>-->
		</div>
	</body>
	<!--<script type="text/javascript" src="js/zepto.js" ></script>-->
	<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
	<script type="text/javascript" src="js/shouye/app.js" ></script>
	<script type="text/javascript" src="js/shouye/index.js" ></script>
	</html>