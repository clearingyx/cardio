var docEl = document.documentElement,
    resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
    recalc = function() {
        var myfontSize = 20 * (docEl.clientWidth/360);
        if(myfontSize > 40){
        	docEl.style.fontSize = "40px";
        }else{
        	docEl.style.fontSize = 20 * (docEl.clientWidth/360) + 'px'; 
        }    
	};
	
window.addEventListener(resizeEvt, recalc, false);
document.addEventListener('DOMContentLoaded', recalc, false);