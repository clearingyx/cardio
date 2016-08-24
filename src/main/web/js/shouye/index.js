
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
				$('.end').val('');
			}
			else{
				var countdown = 30;
				console.log('mfbnjs');
				function timeCountDown(){
					if(countdown==0){
						clearInterval(timer);
						$('.list-pwd').removeClass('pwd-active').html("发送验证码");
					}
					else{
						$('.list-pwd').addClass('pwd-active').html(countdown+"S后再次发送");
					}
					countdown--;
					console.log(countdown);
				}
				timeCountDown();
				var timer = setInterval(timeCountDown,1000);

				$.post("../sms/sendSms.do",{"mobiles":$("#phone").val()},function(data){
					if(data.data=='success'){
						alert("验证码发送成功");
					} else {
						alert("发送错误，请联系管理员或者重新尝试");
					}
				});
			}
		}
	});
//页面跳转
	$('#ensure').on('click',function(){
		//location.href='page-zc/zhccg.jsp';
		var txt=$('#code').val();
		if (txt.length ==0) {
			alert('您输入的验证码不能为空！');
		} else {
			$.post("../reg/reg.do",{"openId":$("#openId").val(),"phone":$("#phone").val(),
				"code":$("#code").val()},function(data){
				if(data=='success'){
					//location.href="../question/jumpPageOne.do?openId="+$("#openId").val();
					location.href='../base/pageZc.do?openId='+$("#openId").val();
				} else {
					alert("验证码错误！");
				}
			});
		}
	})
})