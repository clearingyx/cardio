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
		<title>问卷第二页，共五页</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/page-one/page-one.css" />
		<link rel="stylesheet" href="css/page-two/page-two.css" />
	</head>
	<body>
	<form action="../question/answer.do" method="post" id="form">
		<input name="openId" value="${openId}" type="hidden" id="openId">
		<input name="page" value="2" type="hidden">
		<input name="hSmk" value="1" id="hSmk" type="hidden">
		<input name="hDrink" value="1" id="hDrink" type="hidden">
		<input name="diet" value="0" id="diet" type="hidden">
		<input name="activity" value="0" id="activity" type="hidden">
		<input name="stress" value="1" id="stress" type="hidden">
		<input name="familys" value="1" id="familys" type="hidden">
	</form>
		<div class="box">
		<div class="content">
			<header></header>
			<div class="problem-1 problem problem-4">
				<div class="word-1">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">4</div>
					</div>
					<p class="massege2">您目前(或曾经)吸烟吗？</p>
				</div>
				<div class="smoke-box">
					<p>是</p>
					<div class="slide smoke-bar">
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
			<div class="problem-5 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">5</div>
					</div>
					<p class="massege2">您每天饮酒的酒精含量超过10g吗(约相当于1听330毫升啤酒)？</p>
				</div>
				<div class="smoke-box">
					<p>是</p>
					<div class="slide smoke-bar">
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
			<div class="problem-5 problem problem-6">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">6</div>
					</div>
					<p class="massege2">您每天食用的水果和蔬菜能达到6份(每份约150g)吗？</p>
				</div>
				<div class="smoke-box">
					<p>是</p>
					<div class="slide smoke-bar">
						<div class="scale btn-scale">
							<span class="btn-box" style="left: -.7rem;"></span>
						</div>
					</div>
					<p>否</p>
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<div class="problem-5 problem problem-7">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">7</div>
					</div>
					<p class="massege2">您每周至少进行2小时30分钟的体育锻炼吗？</p>
				</div>
				<div class="smoke-box">
					<p>是</p>
					<div class="slide smoke-bar">
						<div class="scale btn-scale">
							<span class="btn-box" style="left: -.7rem;"></span>
						</div>
					</div>
					<p>否</p>
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<div class="problem-5 problem problem-8">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">8</div>
					</div>
					<p class="massege2">在过去的一年，您是否曾有过巨大的精神或情感压力？</p>
				</div>
				<div class="smoke-box">
					<p>是</p>
					<div class="slide smoke-bar">
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
			<div class="problem-5 problem problem-9">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">9</div>
					</div>
					<p class="massege2">您的母亲/父亲在65岁之前是否有过中风或心脏病发作？</p>
				</div>
				<div class="smoke-box">
					<p>是</p>
					<div class="slide smoke-bar">
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
			<div class="btm-box">
				<footer>
					<div class="foot-box">
						<span class="pre">上一页</span>
						<span class="next">下一页</span>
					</div>
				</footer>
				<ul class="dot">
					<li class="li-dot"></li>
					<li class="li-dot li-active"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
				</ul>
			</div>
		</div>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/app.js" ></script>
	<script type="text/javascript" src="js/page-two/page-two.js" ></script>
</html>
