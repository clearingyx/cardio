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
		<title>问卷第五页，共五页</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" href="css/page-one/page-one.css" />
		<link rel="stylesheet" href="css/page-five/page-five.css" />
	</head>
	<body>
	<form action="../question/answer.do" method="post" id="form">
		<input name="openId" value="${openId}" type="hidden" id="openId">
		<input name="page" value="5" type="hidden">
		<input name="cognitive" value="" id="cognitive" type="hidden">
		<input name="poorMemory" value="1" id="poorMemory" type="hidden">
		<input name="injury" value="" id="injury" type="hidden">
		<input name="miniStroke" value="" id="miniStroke" type="hidden">
	</form>
		<div class="content">
			<header></header>
			<div class="problem-17 problem">
				<div class="word-1">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">17</div>
					</div>
					<p class="massege1">您曾被医生告知具有认知问题或患有痴呆吗？</p>
				</div>
				<div class="select-box">
					<div class="button-box">
						<p class="button shadow-inside"><i></i></p>
						<span class="select-word">是的，一年前</span>
					</div>
					<div class="button-box button-mag">
						<p class="button shadow-inside"><i></i></p>
						<span class="select-word">是的，一年内</span>
						<p class="button button-mar shadow-inside"><i></i></p>
						<span class="select-word">没有</span>
					</div>	
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<div class="problem-18 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">18</div>
					</div>
					<p class="massege1 massege3">您或您周围的人认为您记忆力差吗？</p>
				</div>
				<div class="sex-box select-box">
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
			<div class="problem-19 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">19</div>
					</div>
					<p class="massege1 massege3">您曾被医生诊断为创伤性脑损伤吗？</p>
				</div>
				<div class="select-box">
					<div class="button-box">
						<p class="button shadow-inside"><i></i></p>
						<span class="select-word">是的，一年前</span>
					</div>
					<div class="button-box button-mag">
						<p class="button shadow-inside"><i></i></p>
						<span class="select-word">是的，一年内</span>
						<p class="button button-mar shadow-inside"><i></i></p>
						<span class="select-word">没有</span>
					</div>	
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<div class="problem-20 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">20</div>
					</div>
					<p class="massege1 massege3" style="letter-spacing: -1px;">您曾被医生诊断为中风或短暂性脑缺血发作(小中风)吗？</p>
				</div>
				<div class="select-box">
					<div class="button-box">
						<p class="button shadow-inside"><i></i></p>
						<span class="select-word">是的，一年前</span>
					</div>
					<div class="button-box button-mag">
						<p class="button shadow-inside"><i></i></p>
						<span class="select-word">是的，一年内</span>
						<p class="button button-mar shadow-inside"><i></i></p>
						<span class="select-word">没有</span>
					</div>	
				</div>
				<div class="or-spacer">
				    <div class="mask"></div>
				</div>
			</div>
			<footer>
				<div class="foot-box">
					<span class="pre">上一页</span>
					<span class="next">查看结果</span>
				</div>
				<ul class="dot">
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot li-active"></li>
				</ul>
			</footer>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/app.js" ></script>
	<script type="text/javascript" src="js/page-five/page-five.js" ></script>
</html>
