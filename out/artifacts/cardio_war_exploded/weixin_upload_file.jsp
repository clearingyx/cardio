<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="jquery-1.7.1.min.js" ></script>
		<script>
			$(function(){
				$("input[type='ButtonReq']").click(function(){
	                $.post("weixin/upload.do",{type:"imageResp"},function(data){
                        console.log(data);
	                    $("form").attr("action",data);
	                    $("form").submit();
	                });
	            });
			})
		</script>
	</head>
	<body>
	    <form action="" method="post" enctype="multipart/form-data">
	        <input type="file" required="true" data-type="file" method="POST" name="file">
	        <input type="button" value="button">
	    </form>
	</body>
</html>