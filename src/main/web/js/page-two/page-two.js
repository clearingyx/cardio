$(function(){
	//滑动选择
	$('.content .btn-box').each(function(index,value){
		$(value).on('swipeRight',function(){
			$(this).css('left','.62rem');
			switch(index){
				case 0:document.getElementById("hSmk").value = 0;
					break;
				case 1:document.getElementById("hDrink").value = 0;
					break;
				case 2:document.getElementById("diet").value = 0;
					break;
				case 3:document.getElementById("activity").value = 0;
					break;
				case 4:document.getElementById("stress").value = 0;
					break;
				case 5:document.getElementById("familys").value = 0;
					break;
				default:break;
			};
		});
		$(value).on('swipeLeft',function(){
			$(this).css('left','-.7rem');
			switch(index){
				case 0:document.getElementById("hSmk").value = 1;
					break;
				case 1:document.getElementById("hDrink").value = 1;
					break;
				case 2:document.getElementById("diet").value = 1;
					break;
				case 3:document.getElementById("activity").value = 1;
					break;
				case 4:document.getElementById("stress").value = 1;
					break;
				case 5:document.getElementById("familys").value = 1;
					break;
				default:break;
			};
		});
	});
	//页面跳转
	$('.pre').on('click',function(){
		location.href='../question/backPage.do?page=2&openId='+document.getElementById("openId").value;
	})
	$('.next').on('click',function(){
		//location.href='../page-three/page-three.html';
		document.getElementById("form").submit();
	});
})