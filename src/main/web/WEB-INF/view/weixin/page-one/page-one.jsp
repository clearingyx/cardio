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
		<title>问卷第一页，共五页</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" href="css/page-one/page-one.css" />
	</head>
	<body>

		<input id="judge_height" value="1" type="hidden"><!-- 如果是0，则传到后台是默认值99，input内默认是1 -->
		<input id="judge_weight" value="1" type="hidden"><!-- 如果是0，则传到后台是默认值40，input内默认是1 -->
		<form action="../question/answer.do" method="post" id="form">
			<input name="openId" value="${openId}" type="hidden" id="openId">
			<input name="page" value="1" type="hidden">
			<input name="age" value="20" type="hidden" id="age">
			<input name="gender" value="1" type="hidden" id="gender">
			<input name="weight" value="40" type="hidden" id="weight">
			<input name="height" value="99" type="hidden" id="height">
		</form>

		<div class="content">
			<header></header>
			<div class="problem-1 problem">
				<div class="word-1">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">1</div>
					</div>
					<p class="massege1">您多大年龄？</p>
					<p class="age" id="txt-1">20</p>
					<p class="age-w" style="line-height: 3.9rem;">岁</p>
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
					<div class="circle-big circle-2" style="float: left;">
						<div class="circle-smal circle-3" id="add-1">+</div>
					</div>
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<div class="problem-2 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">2</div>
					</div>
					<p class="massege1">您的性别？</p>
				</div>
				<div class="sex-box">
					<p>男</p>
					<div class="slide sex-bar">
						<div class="scale btn-scale">
							<span class="btn-box"></span>
						</div>
					</div>
					<p>女</p>
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<div class="problem-3 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">3</div>
					</div>
					<p class="massege1">您的身高和体重？</p>
				</div>
				<div class="height-box">
					<form name="form">
						<fieldset>
							<legend>体重:<span class="weight" id="txt-2">40</span><span class="h-unit">kg</span>
								<p class="button shadow-inside"><i></i></p><span class="height-word">我不知道</span>
							</legend>
							<div class="slide-box">
								<div class="circle-big circle-2 circle-minus" id="minus-2" style="float: left; clear: left;">
									<div class="circle-smal circle-3">-</div>
								</div>
								<div class="slide">
									<div class="scale" id="bar-2">
										<div class="bar-slide" id="blue-2"></div>
										<span class="btn" id="btn-2"></span>
									</div>
								</div>
								<div class="circle-big circle-2 circle-add" id="add-2" style="float: left;">
									<div class="circle-smal circle-3">+</div>
								</div>
							</div>
						</fieldset>
						<fieldset class="field-mag">
							<legend>身高:<span class="weight" id="txt-3">99</span><span class="h-unit">cm</span>
								<p class="button shadow-inside"><i></i></p><span class="height-word">我不知道</span>
							</legend>
							<div class="slide-box">
								<div class="circle-big circle-2" style="float: left; clear: left;">
									<div class="circle-smal circle-3 circle-minus" id="minus-3">-</div>
								</div>
								<div class="slide">
									<div class="scale bar" id="bar-3">
										<div class="bar-slide" id="blue-3"></div>
										<span class="btn" id="btn-3"></span>
									</div>
								</div>
								<div class="circle-big circle-2" id="add-3" style="float: left;">
									<div class="circle-smal circle-3 circle-add">+</div>
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
					<li class="li-dot li-active"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
				</ul>
			</footer>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/app.js" ></script>
	<script type="text/javascript" src="js/page-one/page-one.js" ></script>
</html>
