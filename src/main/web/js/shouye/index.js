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
				var time = 30;
				console.log('mfbnjs');
				function timeCountDown(){
					if(time==0){
						clearInterval(timer);
						$('#psw-btn').removeClass('pwd-active').html("发送验证码");
					}
					else{
						$('#psw-btn').addClass('pwd-active').html(time+"S后再次发送");	
					}
					time--;
					console.log(time);
				}
				timeCountDown();
				var timer = setInterval(timeCountDown,1000);
			}
		}
	});
	//页面跳转
	$('#reg_button').on('click',function(){
		var txt=$('#code').val();
		if (txt.length ==0) {
			alert('您输入的验证码不能为空！');
		} else {
			$("form").submit();
		}
	})
})