$(function(){
	var len=$('.problem-17 .button').length;
	//页面单选
	$('.problem-17 .button').each(function(index,value){
		$(value).on('click',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-17 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("cognitive").value = 2;
					else if (index == 1) document.getElementById("cognitive").value = 1;
					else document.getElementById("cognitive").value = 0;

				}else
					$('.problem-17 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	$('.problem-19 .button').each(function(index,value){
		$(value).on('tap',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-19 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("injury").value = 2;
					else if (index == 1) document.getElementById("injury").value = 1;
					else document.getElementById("injury").value = 0;

				}else
					$('.problem-19 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	$('.problem-20 .button').each(function(index,value){
		$(value).on('tap',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-20 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("miniStroke").value = 2;
					else if (index == 1) document.getElementById("miniStroke").value = 1;
					else document.getElementById("miniStroke").value = 0;

				}else
					$('.problem-20 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	//滑动选择
	$('.btn-box').on('swipeRight',function(){
		$(this).css('left','42%');
		document.getElementById("poorMemory").value = 0;
	});
	$('.btn-box').on('swipeLeft',function(){
		$(this).css('left','-42%');
		document.getElementById("poorMemory").value = 1;
	});
	//页面跳转
	$('.pre').on('click',function(){
		location.href='../question/backPage.do?page=5&openId='+document.getElementById("openId").value;
	})
	$('.next').on('click',function(){
		//location.href='../result/result.html';
		var cognitive = document.getElementById("cognitive").value;
		var injury = document.getElementById("injury").value;
		var miniStroke = document.getElementById("miniStroke").value;
		if(cognitive != '' && injury != '' && miniStroke != ''){
			document.getElementById("form").submit();
		} else {
			alert("题目不能为空！");
		}
	});
})