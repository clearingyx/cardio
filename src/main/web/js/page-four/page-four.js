$(function(){
	var len=$('.problem-13 .button').length;
	//页面单选
	$('.problem-13 .button').each(function(index,value){
		$(value).on('tap',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-13 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("hDiab").value = 2;
					else if (index == 1) document.getElementById("hDiab").value = 1;
					else document.getElementById("hDiab").value = 0;

				} else
					$('.problem-13 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	$('.problem-14 .button').each(function(index,value){
		$(value).on('tap',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-14 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("cvd").value = 2;
					else if (index == 1) document.getElementById("cvd").value = 1;
					else document.getElementById("cvd").value = 0;

				}else
					$('.problem-14 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	$('.problem-15 .button').each(function(index,value){
		$(value).on('tap',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-15 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("lvh").value = 2;
					else if (index == 1) document.getElementById("lvh").value = 1;
					else document.getElementById("lvh").value = 0;

				}else
					$('.problem-15 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	$('.problem-16 .button').each(function(index,value){
		$(value).on('tap',function(){
			for(var j=0;j<len;j++){
				if(j==index){
					$('.problem-16 .button i').eq(j).addClass('h-avtive');

					if (index == 0) document.getElementById("af").value = 2;
					else if (index == 1) document.getElementById("af").value = 1;
					else document.getElementById("af").value = 0;

				}else
					$('.problem-16 .button i').eq(j).removeClass('h-avtive');
			}
		})
	});
	//页面跳转
	$('.pre').on('click',function(){
		location.href='../question/backPage.do?page=4&openId='+document.getElementById("openId").value;
	})
	$('.next').on('click',function(){
		//location.href='../page-five/page-five.html';
		var hDiab = document.getElementById("hDiab").value;
		var cvd = document.getElementById("cvd").value;
		var lvh = document.getElementById("lvh").value;
		var af = document.getElementById("af").value;
		if(hDiab != '' && cvd != '' && lvh != '' && af !=''){
			document.getElementById("form").submit();
		} else {
			alert("题目不能为空！");
		}
	});
})