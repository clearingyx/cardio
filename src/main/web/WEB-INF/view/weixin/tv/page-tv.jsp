<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>中国百万计划</title>
    <base href="<%=basePath%>">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/tv/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/tv/page-tv.css"/>
</head>
<body>
<div class="content" style="background-color: #f7f7f7;">
    <header></header>
    <%--<div style=";position:absolute; height:25rem;overflow-y: auto;margin-left: 1rem;padding-right: 0.5rem">--%>

        <hr width="300rem" color="1a4f86" size="1">

        <form action="../randomQuestion/anwser.do" id="form" method="get">

            <h3 style="font-size: 1rem;color: #1a4f83;font-weight: 100;margin-left: 1.5rem;">健康知识问答</h3>
            <p style="padding-left: 2rem;" class="zswd">1、${list[0].stem}</p>
            <div style="font-size: 0.73rem;color:#5d5e62;margin-left: 3rem;margin-top: 0.3rem">
                <input type="radio" name="question_1" value="${list[0].optionA}" style="width:0.7rem;height:0.7rem;">${list[0].optionA}
                <input type="radio" name="question_1" value="${list[0].optionB}"
                       style="width:0.7rem;height:0.7rem;margin-left: 2rem">${list[0].optionB}
            </div>
            <p style="padding-left: 2rem;" class="zswd">2、${list[1].stem}</p>
            <div style="font-size: 0.73rem;color:#5d5e62;margin-left: 3rem;margin-top: 0.3rem">
                <input type="radio" name="question_2" value="${list[1].optionA}" style="width:0.7rem;height:0.7rem;">${list[1].optionA}
                <input type="radio" name="question_2" value="${list[1].optionB}"
                       style="width:0.7rem;height:0.7rem;margin-left: 2rem">${list[1].optionB}
            </div>
            <div class="tj tjlj" onclick = "questionSubmit()">提交</div>
        </form>

        <hr width="300rem" color="1a4f86" size="1">

    <%--</div>--%>
    <%--<img class="xljt" id="bbb" src="img/tv/0.png" type="button" onclick="DivShow()">--%>
    <%--<div id="aaa" style="display: none">--%>

        <%--<p class="gys">该医生的其他的视频</p>--%>
        <%--<div style="margin-left: 5%;padding-bottom: 2rem">--%>
            <%--<img style="width: 7.9rem;" src="img/tv/jjt.png">--%>
            <%--<img style="width: 7.9rem;" src="img/tv/jjt.png">--%>
            <%--<img style="width: 7.9rem;" src="img/tv/jjt.png">--%>
            <%--<img style="width: 7.9rem;" src="img/tv/jjt.png">--%>
        <%--</div>--%>
    <%--</div>--%>
    <footer style="margin-top: -0.5rem;"></footer>
</div>
</body>
<script type="text/javascript" src="js/tv/app.js"></script>
<script type="text/javascript" src="js/tv/xl.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="application/javascript">
    function questionSubmit(){
        var check_flg = 0
        for (var i=0; i < document.getElementsByName("question_1").length; i++) {
            if(document.getElementsByName("question_1")[i].checked==true) {
                check_flg = 1;
                break
            }
        }
        if (check_flg == 0) {
            alert("题目一不能为空！");
            return false;
        } else {
            check_flg = 0
            for (var j=0; j < document.getElementsByName("question_2").length; j++) {
                if(document.getElementsByName("question_2")[j].checked==true) {
                    check_flg = 1;
                    break
                }
            }
            if (check_flg == 0) {
                alert("题目二不能为空！");
                return false;
            } else {
                $(document).ready(function(){
                    var url = "http://chinamillionclubs.hongshouhuan.com/randomQuestion/anwser.do?openId=${openId}&id_1=${list[0].id}"+
                             "&id_2=${list[1].id}&question_1=" + $('input[name="question_1"]:checked').val() +
                            "&question_2=" + $('input[name="question_2"]:checked').val();
                    $.ajax({
                        url:url,
                        dataType:'jsonp',
                        processData: false,
                        type:'get',
                        success:function(data){
                            alert(data.data.data);
                        },
                        error:function(e) {
                            alert(e);
                        }});
                });
            }
        }
    }
</script>
</html>