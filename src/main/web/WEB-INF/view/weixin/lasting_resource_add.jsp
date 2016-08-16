<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
图片（image）: 2M，支持JPG格式<br>

语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式<br>

视频（video）：10MB，支持MP4格式<br>

缩略图（thumb）：64KB，支持JPG格式<br>
<br>
    <form action="../sourceBiz/lastingResourceAdd.do" enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <select name="type">
            <option value="image">image</option>
            <option value="voice">voice</option>
            <option value="video">video</option>
            <option value="thumb">thumb</option>
        </select>
        <input name="remark" value="素材描述">
        <input value="submit" type="submit">
    </form>
</body>
</html>
