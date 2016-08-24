$(function(){
	//指示标
	var flag1=false;
	var flag2=true;
	var flag3=false;
	var flag4=false;
	//第一题
	function Silding($bar,$btn,$txt,$minus,$add,$left,$blue,min,max,$flag,$judge){
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
			if($judge)//如未被禁止时
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
			val=Math.round(Math.max(min,min+left/x*num));//四舍五入获得设置数值
			slide(left,val,$flag);
		});
		$($minus).on('tap',function(){
			if($judge)
				val-=1;
			else
				val-=0;
			val=Math.max(min,val);
			//获得滑动的百分比
			left=x/num*(val-min);
			slide(left,val,$flag);
		});
		$($add).on('tap',function(){
			if($judge)
				val+=1;
			else
				val+=0;
			val=Math.min(max,val);
			left=x/num*(val-min);
			slide(left,val,$flag);
		});
		//设置页面的变化数值
		function slide(left,val,flag)
		{
			$($txt).html(val);
			$($blue).css('width',left+'px');
			$($btn).css('left',left+'px');
			switch(flag){
				case 1:flag1=true;break;
				case 3:flag3=true;break;
				case 4:flag4=true;break;
				default:break;
			}
		};
	};
	var left1=Number(document.getElementById('btn-1').style.left);//获得当前的滑块的left
	//实参分别为：滑轨                   滑块                       数值块                       减号按钮                 加号按钮          滑块的left值   滑轨的颜色变化块
	Silding($('#bar-1'),$('#btn-1'),$('#txt-1'),$('#minus-1'),$('#add-1'),left1,$('#blue-1'),20,90,1,true);//最小值       最大值
	//滑动选择
	$('.btn-box').on('swipeRight',function(){
		$(this).css('left','43%');
		//form表单的性别设为女
		document.getElementById("gender").value = 0;
		//flag2=true;
	});
	$('.btn-box').on('swipeLeft',function(){
		$(this).css('left','-42%');
		//form表单的性别设为男
		document.getElementById("gender").value = 1;
		//flag2=true;
	});
	//单选
	var left2=Number(document.getElementById('btn-2').style.left);//获得当前的滑块的left
	Silding($('#bar-2'),$('#btn-2'),$('#txt-2'),$('#minus-2'),$('#add-2'),left2,$('#blue-2'),40,250,3,true);//最小值       最大值
	var left3=Number(document.getElementById('btn-1').style.left);//获得当前的滑块的left
	Silding($('#bar-3'),$('#btn-3'),$('#txt-3'),$('#minus-3'),$('#add-3'),left3,$('#blue-3'),99,231,4,true);//最小值       最大值
	$('.height-box fieldset .button').each(function(index,value){
		$(value).on('click',function(){
			var left22=parseInt(document.getElementById('btn-2').style.left);
			var left33=parseInt(document.getElementById('btn-3').style.left);
			if(!left22){
				left22=0;
			}
			if(!left33){
				left33=0;
			}
			if($('.height-box fieldset .button i').eq(index).hasClass('h-avtive'))
			{
				$('.height-box fieldset .button i').eq(index).removeClass('h-avtive');
				$('.height-box fieldset .weight').eq(index).removeClass('gay');
				$('.height-box fieldset .h-unit').eq(index).removeClass('gay');
				$('.height-box fieldset .btn').eq(index).removeClass('gay3');
				$('.height-box fieldset .bar-slide').eq(index).removeClass('gay4');
				switch(index){
					case 0:Silding($('#bar-2'),$('#btn-2'),$('#txt-2'),$('#minus-2'),$('#add-2'),left22,$('#blue-2'),40,250,3,true);//最小值       最大值
						document.getElementById("judge_weight").value = 1;
						break;
					case 1:Silding($('#bar-3'),$('#btn-3'),$('#txt-3'),$('#minus-3'),$('#add-3'),left33,$('#blue-3'),99,231,4,true);//最小值       最大值
						document.getElementById("judge_height").value = 1;
						break;
					default:break;
				};
			}
			else
			{
				$('.height-box fieldset .button i').eq(index).addClass('h-avtive');
				$('.height-box fieldset .weight').eq(index).addClass('gay');
				$('.height-box fieldset .h-unit').eq(index).addClass('gay');
				$('.height-box fieldset .btn').eq(index).addClass('gay3');
				$('.height-box fieldset .bar-slide').eq(index).addClass('gay4');
				switch(index){
					case 0:Silding($('#bar-2'),$('#btn-2'),$('#txt-2'),$('#minus-2'),$('#add-2'),left22,$('#blue-2'),40,250,3,false);//最小值       最大值
						document.getElementById("judge_weight").value = 0;
						break;
					case 1:Silding($('#bar-3'),$('#btn-3'),$('#txt-3'),$('#minus-3'),$('#add-3'),left33,$('#blue-3'),99,231,4,false);//最小值       最大值
						document.getElementById("judge_height").value = 0;
						break;
					default:break;
				};
			}
		})
	});
	//页面跳转
	$('.pre').on('click',function(){
		location.href='../base/pageText.do?openId='+$("#openId").val();
	});
	$('.next').on('click',function(){
		//if(flag1&&flag2&&flag3&&flag4)
		//	location.href='../page-two/page-two.html';
		//else
		//	alert('请将题目答完，再进行下一页');
		document.getElementById("age").value = document.getElementById("txt-1").innerHTML;
		if(document.getElementById("judge_weight").value == 0){
			document.getElementById("weight").value = 40;
		}else{
			document.getElementById("weight").value = document.getElementById("txt-2").innerHTML;
		}
		if(document.getElementById("judge_height").value == 0){
			document.getElementById("height").value = 99;
		}else{
			document.getElementById("height").value = document.getElementById("txt-3").innerHTML;
		}
		document.getElementById("form").submit();
	});
})