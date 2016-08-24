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
	<title>问卷第三页，共五页</title>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<link rel="stylesheet" href="css/page-one/page-one.css" />
	<link rel="stylesheet" href="css/page-three/page-three.css" />
</head>
<body>
	<input id="judge_sbp" value="1" type="hidden">
	<input id="judge_tc" value="1" type="hidden">
	<input id="judge_ldl" value="1" type="hidden">
	<form action="../question/answer.do" method="post" id="form">
		<input name="openId" value="${openId}" type="hidden" id="openId">
		<input name="page" value="3" type="hidden">
		<input name="sbp" value="90" id="sbp" type="hidden">
		<input name="hyprx" value="1" id="hyprx" type="hidden">
		<input name="tc" value="0" id="f_tc" type="hidden">
		<input name="ldl" value="0" id="f_ldl" type="hidden">
	</form>
	<div class="content">
	<header></header>
	<div class="problem-1 problem problem-10">
		<div class="word-1">
			<div class="circle-1 circle-big">
				<div class="circle-11 circle-smal">10</div>
			</div>
			<p class="massege1">您的收缩压(血压读数中的高值)是多少？</p>
			<p class="age" id="txt-1">90</p>
			<p class="age-w">mmHg</p>
			<p class="button shadow-inside"><i></i></p><span class="height-word">我不知道</span>
		</div>
		<div class="slide-box">
			<div class="circle-big circle-2" id="minus-1" style="float: left; clear: left;">
				<div class="circle-smal circle-3">-</div>
			</div>
			<div class="slide">
				<div class="scale bar" id="bar-1">
					<div class="bar-slide" id="blue-1"></div>
					<span class="btn" id="btn-1"></span>
				</div>
			</div>
			<div class="circle-big circle-2" id="add-1" style="float: left;">
				<div class="circle-smal circle-3">+</div>
			</div>
		</div>
		<div class="or-spacer">
			<div class="mask"></div>
		</div>
	</div>
	<div class="problem-2 problem problem-11">
		<div class="word-1 word-2">
			<div class="circle-1 circle-big">
				<div class="circle-11 circle-smal">11</div>
			</div>
			<p class="massege1">您正在服用降压药吗？</p>
		</div>
		<div class="sex-box">
			<p>是</p>
			<div class="slide sex-bar">
				<div class="scale btn-scale">
					<span class="btn-box"></span>
				</div>
			</div>
			<p>否</p>
		</div>
		<div class="or-spacer">
			<div class="mask"></div>
		</div>
	</div>
	<div class="problem-3 problem problem-12">
		<div class="word-1 word-2">
			<div class="circle-1 circle-big">
				<div class="circle-11 circle-smal">12</div>
			</div>
			<p class="massege1">您最近一次测量的血脂质是多少？</p>
		</div>
		<div class="height-box">
			<form name="form">
				<fieldset id="TC">
					<legend>总胆固醇(TC)</legend>
					<div class="TC-num">
						<p class="TC-left">
							<span class="tc-number" id="txt-2">0.0</span>
							<span class="tc-unit">mmol/L</span>
						</p>
						<div class="TC-right">
							<p class="button shadow-inside"><i></i></p><span class="height-word">我不知道</span>
							<p class="button shadow-inside"><i></i></p><span class="height-word-blue">>30</span><span class="right-unit">mmol/L</span>
						</div>
					</div>
					<div class="slide-box">
						<div class="circle-big circle-2" id="minus-2" style="float: left; clear: left;">
							<div class="circle-smal circle-3">-</div>
						</div>
						<div class="slide">
							<div class="scale" id="bar-2">
								<div class="bar-slide" id="blue-2"></div>
								<span class="btn" id="btn-2"></span>
							</div>
						</div>
						<div class="circle-big circle-2" id="add-2" style="float: left;">
							<div class="circle-smal circle-3">+</div>
						</div>
					</div>
				</fieldset>
				<fieldset class="field-mag" id="LDL">
					<legend>低密度脂蛋白胆固醇(LDL-C)</legend>
					<div class="TC-num">
						<p class="TC-left">
							<span class="tc-number" id="txt-3">0.00</span>
							<span class="tc-unit">mmol/L</span>
						</p>
						<div class="TC-right">
							<p class="button shadow-inside"><i></i></p><span class="height-word">我不知道</span>
							<p class="button shadow-inside"><i></i></p><span class="height-word-blue">>20</span><span class="right-unit">mmol/L</span>
						</div>
					</div>
					<div class="slide-box">
						<div class="circle-big circle-2" id="minus-3" style="float: left; clear: left;">
							<div class="circle-smal circle-3">-</div>
						</div>
						<div class="slide">
							<div class="scale" id="bar-3">
								<div class="bar-slide" id="blue-3"></div>
								<span class="btn" id="btn-3"></span>
							</div>
						</div>
						<div class="circle-big circle-2" id="add-3" style="float: left;">
							<div class="circle-smal circle-3">+</div>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="or-spacer">
			<div class="mask"></div>
		</div>
	</div>
	<footer>
		<div class="foot-box">
			<span class="pre">上一页</span>
			<span class="next">下一页</span>
		</div>
		<ul class="dot">
			<li class="li-dot"></li>
			<li class="li-dot"></li>
			<li class="li-dot li-active"></li>
			<li class="li-dot"></li>
			<li class="li-dot"></li>
		</ul>
	</footer>
</div>
</body>
<script type="text/javascript" src="js/zepto.js" ></script>
<script type="text/javascript" src="js/app.js" ></script>
<script type="text/javascript" src="js/page-three/page-three.js" ></script>
</html>
