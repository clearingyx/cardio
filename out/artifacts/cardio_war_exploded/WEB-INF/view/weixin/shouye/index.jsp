<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	<head>
		<base href="<%=basePath%>">
	    <meta charset="UTF-8">
	    <title>百万计划</title>
	</head>
<link rel="stylesheet" href="css/shouye/style.css">
<link rel="stylesheet" href="css/shouye/index.css">
	<body>
		<div>
			<img src="img/shouye/logo1.png" style="position: absolute;width: 17%;margin-top: 1.5rem;margin-left: 1rem">
			<img src="img/shouye/logo.png" style="width: 30%;margin: 0 auto;margin-left: 36%;margin-top: 1.5rem">
			<div class="sy-head">
	            <p class="logo">中国<img src="img/shouye/BW.png">计划</p>
	            <p class="YW">MILLION FOR MILLIONS</p>
	            <p class="FXPG">风险评估工具</p>
	        </div>

			<form action="../reg/reg.do" method="post">
				<input value="${openId}" name="openId" type="hidden">
				<div class="sy-box">
					<p class="one center">请注册!</p>
					<ul>
						<li>
							<input  class="two end shadow-inside" type="text" name="phone" id="phone" placeholder="输入手机号">
						</li>
						 <li style="position: relative; z-index: 2000;">
							<input  placeholder="输入验证码" class="two end1 shadow-inside" type="text" name="code" id="code">
							<div class="psw-btn" id="psw-btn">获取验证码</div>
						</li>
					 </ul>
				</div>
			</form>

			<div class="bg-box">
	            <img class="bg-img" src="img/shouye/yjbj1.png">
	            <img id="reg_button" src="img/shouye/qran.png" style="width: 43%; position: absolute;margin-top: -6.5rem;margin-left: 27%"></a>
	        </div>
		</div>

	</body>
	<script type="text/javascript" src="js/shouye/zepto.js" ></script>
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/shouye/app.js" ></script>
	<script type="text/javascript" src="js/shouye/index.js" ></script>
</html>