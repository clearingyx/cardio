$(function(){
	//指示标
	var flag1=false;
	var flag2=true;
	var flag3=false;
	var flag4=false;
	//第一题
	function Silding($bar,$btn,$txt,$minus,$add,$left,$blue,min,max,step,dot,$flag,$judge){
		var startX,endX;
		var changeX=0;
		var x=$($bar).width()-$($btn).width();//获得滑轨的长度
		var val=Number($($txt).html());//获得当前文档的
		var left=$left;
		var num=max-min;
		$($btn).on('touchstart',function(e){
			e.preventDefault();
			var touch=e.touches[0];
			startX=Number(touch.pageX);//获得初始的x值(当手指接触屏幕时的，当前距离页面的值)
		});
		$($btn).on('touchmove',function(e){
			e.preventDefault();
			var touch=e.touches[0];
			endX=Number(touch.pageX);//获得当前的x值
			if($flag)//如未被禁止时
				changeX=endX-startX;//获得手指的滑动距离
			else
				changeX=0;
		});
		$($btn).on('touchend',function(e){
			e.preventDefault();
			var touch=e.touches[0];
			left+=changeX;//改变滑动位置
			if(changeX>0)//判断滑动方向
				left=Math.min(x,left);//滑动距离最大为轨道的长度
			else
				left=Math.max(0,left);//最小为0
			val=Math.max(min,min+left/x*num);//四舍五入获得设置数值
			slide(left,val,$judge);
		});
		$($minus).on('tap',function(){
			if($flag)
				val-=step;
			else
				val-=0;
			val=Math.max(min,val);
			//获得滑动的百分比
			left=x/num*(val-min);
			slide(left,val,$judge);
		});
		$($add).on('tap',function(){
			if($flag)
				val+=step;
			else
				val+=0;
			val=Math.min(max,val);
			left=x/num*(val-min);
			slide(left,val,$judge);
		});
		//设置页面的变化数值
		function slide(left,val,judge)
		{
			$($txt).html(Number(val).toFixed(dot));
			$($blue).css('width',left+'px');
			$($btn).css('left',left+'px');
			switch(judge){
				case 1:flag1=true;break;
				case 3:flag3=true;break;
				case 4:flag4=true;break;
				default:break;
			};
		};
	};
	var left1=Number(document.getElementById('btn-1').style.left);//获得当前的滑块的left
	//实参分别为：滑轨                   滑块                       数值块                       减号按钮                 加号按钮          滑块的left值   滑轨的颜色变化块
	Silding($('#bar-1'),$('#btn-1'),$('#txt-1'),$('#minus-1'),$('#add-1'),left1,$('#blue-1'),90,250,1,0,true,1);//最小值       最大值


//单选
	var num=0;
	$('.problem-10 .button').on('tap',function(){
		//获得当前的滑块的位置
		var left12=parseInt(document.getElementById('btn-1').style.left);
		if(!left12){
			left12=0;
		}
		num++;
		if(num%2==1)
		{
			$('.problem-10 .button i').addClass('h-avtive');
			$('.problem-10 .age').addClass('gay');
			$('.problem-10 .age-w').addClass('gay');
			$('.problem-10 .btn').addClass('gay3');
			$('.problem-10 .bar-slide').addClass('gay4');
			Silding($('#bar-1'),$('#btn-1'),$('#txt-1'),$('#minus-1'),$('#add-1'),left12,$('#blue-1'),90,250,1,0,false,1);//最小值       最大值
			document.getElementById("judge_sbp").value = 0;
		}
		else
		{
			$('.problem-10 .button i').removeClass('h-avtive');
			$('.problem-10 .age').removeClass('gay');
			$('.problem-10 .age-w').removeClass('gay');
			$('.problem-10 .btn').removeClass('gay3');
			$('.problem-10 .bar-slide').removeClass('gay4');
			Silding($('#bar-1'),$('#btn-1'),$('#txt-1'),$('#minus-1'),$('#add-1'),left12,$('#blue-1'),90,250,1,0,true,1);//最小值       最大值
			document.getElementById("judge_sbp").value = 1;
		}
		flag1=true;
	});
	var left2=Number(document.getElementById('btn-2').style.left);//获得当前的滑块的left
	//实参分别为：滑轨                   滑块                       数值块                       减号按钮                 加号按钮          滑块的left值   滑轨的颜色变化块
	Silding($('#bar-2'),$('#btn-2'),$('#txt-2'),$('#minus-2'),$('#add-2'),left2,$('#blue-2'),0.0,30.0,0.1,1,true,3);//最小值       最大值
	//页面单选
	var len=$('#TC .button').length;
	$('#TC .button').each(function(index,value){
		$(value).on('tap',function(){
			var left22=parseInt(document.getElementById('btn-2').style.left);
			if(!left22){
				left22=0;
			}
			if($('#TC .button i').eq(index).hasClass('h-avtive'))
			{
				$('#TC .button i').eq(index).removeClass('h-avtive');
				$('#TC .tc-number').removeClass('gay');
				$('#TC .tc-unit').removeClass('gay');
				$('#TC .btn').removeClass('gay3');
				$('#TC .bar-slide').removeClass('gay4');
				Silding($('#bar-2'),$('#btn-2'),$('#txt-2'),$('#minus-2'),$('#add-2'),left22,$('#blue-2'),0.0,30.0,0.1,1,true,3);//最小值

				document.getElementById("judge_tc").value = 1;
			}
			else
			{
				for(var j=0;j<len;j++){
					if(j==index)
					{
						$('#TC .button i').eq(j).addClass('h-avtive');
						$('#TC .tc-number').addClass('gay');
						$('#TC .tc-unit').addClass('gay');
						$('#TC .btn').addClass('gay3');
						$('#TC .bar-slide').addClass('gay4');
					}
					else
					{
						$('#TC .button i').eq(j).removeClass('h-avtive');
					}
				};
				Silding($('#bar-2'),$('#btn-2'),$('#txt-2'),$('#minus-2'),$('#add-2'),left22,$('#blue-2'),0.0,30.0,0.1,1,false,3);//最小值

				switch(index){
					case 0:document.getElementById("judge_tc").value = 0;
						break;
					case 1:document.getElementById("judge_tc").value = 2;
						break;
					default:break;
				};
			}
			flag3=true;
		});
	});

	var left3=Number(document.getElementById('btn-3').style.left);//获得当前的滑块的left
	//实参分别为：滑轨                   滑块                       数值块                       减号按钮                 加号按钮          滑块的left值   滑轨的颜色变化块
	Silding($('#bar-3'),$('#btn-3'),$('#txt-3'),$('#minus-3'),$('#add-3'),left1,$('#blue-3'),0.0,20.0,0.01,2,true,4);//最小值       最大值
	$('#LDL .button').each(function(index,value){
		$(value).on('tap',function(){
			var left33=parseInt(document.getElementById('btn-3').style.left);
			if(!left33){
				left33=0;
			}
			if($('#LDL .button i').eq(index).hasClass('h-avtive'))
			{
				$('#LDL .button i').eq(index).removeClass('h-avtive');
				$('#LDL .tc-number').removeClass('gay');
				$('#LDL .tc-unit').removeClass('gay');
				$('#LDL .btn').removeClass('gay3');
				$('#LDL .bar-slide').removeClass('gay4');
				Silding($('#bar-3'),$('#btn-3'),$('#txt-3'),$('#minus-3'),$('#add-3'),left33,$('#blue-3'),0.0,20.0,0.01,2,true,4);//最小值

				document.getElementById("judge_ldl").value = 1;
			}
			else
			{
				for(var j=0;j<len;j++){
					if(j==index)
					{
						$('#LDL .button i').eq(j).addClass('h-avtive');
						$('#LDL .tc-number').addClass('gay');
						$('#LDL .tc-unit').addClass('gay');
						$('#LDL .btn').addClass('gay3');
						$('#LDL .bar-slide').addClass('gay4');
					}
					else
					{
						$('#LDL .button i').eq(j).removeClass('h-avtive');
					}
				};
				Silding($('#bar-3'),$('#btn-3'),$('#txt-3'),$('#minus-3'),$('#add-3'),left33,$('#blue-3'),0.0,20.0,0.01,2,false,4);//最小值

				switch(index){
					case 0:document.getElementById("judge_ldl").value = 0;
						break;
					case 1:document.getElementById("judge_ldl").value = 2;
						break;
					default:break;
				};
			}
			flag4=true;
		});
	});
	//滑动选择
	$('.btn-box').on('swipeRight',function(){
		$(this).css('left','24%');
		document.getElementById("hyprx").value = 0;
	});
	$('.btn-box').on('swipeLeft',function(){
		$(this).css('left','-42%');
		document.getElementById("hyprx").value = 1;
	});
	//页面跳转
	$('.pre').on('click',function(){
		location.href='../question/backPage.do?page=3&openId='+document.getElementById("openId").value;
	})
	$('.next').on('click',function(){
		//if(flag1&&flag2&&flag3&&flag4)
		//	location.href='../page-four/page-four.html';
		//else
		//	alert('请将题目答完，再进行下一页');
		if (document.getElementById("judge_sbp").value == 0){
			document.getElementById("sbp").value = 90;
		} else {
			document.getElementById("sbp").value = document.getElementById("txt-1").innerHTML;
		}
		if (document.getElementById("judge_tc").value == 0){
			document.getElementById("f_tc").value = 0;
		} else if(document.getElementById("judge_tc").value == 2){
			document.getElementById("f_tc").value = 31;
		} else {
			document.getElementById("f_tc").value = document.getElementById("txt-2").innerHTML;
		}
		if (document.getElementById("judge_ldl").value == 0){
			document.getElementById("f_ldl").value = 0;
		} else if(document.getElementById("judge_ldl").value == 2){
			document.getElementById("f_ldl").value = 21;
		} else {
			document.getElementById("f_ldl").value = document.getElementById("txt-3").innerHTML;
		}
		document.getElementById("form").submit();
	});
})