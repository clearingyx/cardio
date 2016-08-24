
$(function(){
	//手机号码验证
	$('.psw-btn').on('click',function(){
		var txt=$('.end').val();
		var reg = /^1\d{10}$/;
		if(txt.length ==0){
			alert('您输入的手机号码不能为空！');
		}
		else
		{
			if(!reg.test(txt))
			{
				alert('您输入的手机号码有误！');
				$(this).val('');
			}
			else{
				var countdown = 30;
				console.log('mfbnjs');
				function timeCountDown(){
					if(countdown==0){
						clearInterval(timer);
						$('#psw-btn').removeClass('pwd-active').html("发送验证码");
					}
					else{
						$('#psw-btn').addClass('pwd-active').html(countdown+"S后再次发送");
					}
					countdown--;
					console.log(countdown);
				}
				timeCountDown();
				var timer = setInterval(timeCountDown,1000);
			}
		}
	});
//页面跳转
	$('#ensure').on('click',function(){
		location.href='page-zc/zhccg.jsp';
	})
})