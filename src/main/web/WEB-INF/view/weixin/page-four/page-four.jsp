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
		<title>问卷第四页，共五页</title>
		<base href="<%=basePath%>">
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" href="css/page-one/page-one.css" />
		<link rel="stylesheet" href="css/page-four/page-four.css" />
	</head>
	<body>
	<form action="../question/answer.do" method="post" id="form">
		<input name="openId" value="${openId}" type="hidden" id="openId">
		<input name="page" value="4" type="hidden">
		<input name="hDiab" value="" id="hDiab" type="hidden">
		<input name="cvd" value="" id="cvd" type="hidden">
		<input name="lvh" value="" id="lvh" type="hidden">
		<input name="af" value="" id="af" type="hidden">
	</form>
		<div class="content">
			<header></header>
			<div class="problem-13 problem">
				<div class="word-1">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">13</div>
					</div>
					<p class="massege1">您曾被医生诊断为糖尿病吗？</p>
				</div>
				<div class="select-box">
					<div class="">
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
			<div class="problem-14 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">14</div>
					</div>
					<p class="massege1" style="width: 11.67rem;">您曾被医生诊断患有心血管/外周血管疾病吗？</p>
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
			<div class="problem-15 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">15</div>
					</div>
					<p class="massege1" style="width: 11.67rem;">您曾被医生诊断为左心室肥厚吗？</p>
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
			<div class="problem-16 problem">
				<div class="word-1 word-2">
					<div class="circle-1 circle-big">
						<div class="circle-11 circle-smal">16</div>
					</div>
					<p class="massege1" style="width: 11.67rem;">您曾被医生诊断为房颤吗？</p>
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
					<span class="next">下一页</span>
				</div>
				<ul class="dot">
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot"></li>
					<li class="li-dot li-active"></li>
					<li class="li-dot"></li>
				</ul>
			</footer>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/app.js" ></script>
	<script type="text/javascript" src="js/page-four/page-four.js" ></script>
</html>
