<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<base href="<%=basePath%>">
		<title>测试说明</title>
		<link rel="stylesheet" href="css/shouye/common.css" />
		<link rel="stylesheet" href="css/page-test/test.css" />
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
			<div class="sy-box">
				<div class="lamp"></div>
				<p class="til">血管健康风险警报器</p>
				<p class="declare">测试说明</p>
				<p class="note">1、本评估软件基于2014年全球最佳医疗健康App-Stroke Riskometer应用，由中国卒中学会授权开发；</p>
				<p class="note">2、本应用可评估测试者10年内发生心脑血管疾病的风险程度分层及相对于同龄健康人群的疾病风险倍数；</p>
				<p class="note">3、系统将会根据测试分层结果进行治疗预防管理的建议。</p>
			</div>
			<div class="next"></div>
		</div>
	</body>
	<script type="text/javascript" src="js/shouye/zepto.js" ></script>
	<script type="text/javascript" src="js/shouye/app.js" ></script>
	<script type="text/javascript" src="js/page-test/test.js" ></script>
</html>
