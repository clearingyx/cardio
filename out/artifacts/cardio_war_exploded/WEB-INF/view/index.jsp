<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <img src="${img}">
    <!-- http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=As4G9HxoVckmW0yFNXuYGsliQsrydA_bKTkaeK45QWlU03rcBbgSS8eI2iFdCQz6vsVpw0yHKEuZfunIqLnusfH8LKm5mFMDnkYF13PzQsHicxJ9HwIUGD1OhBQP10H1EHHgAAAORR&type=imageResp -->
    <form action="../weixin/upload.do" method="post" enctype="multipart/form-data">
        <input type="file" required="true" data-type="file" method="POST" name="file">
        <input type="submit" value="button">
    </form>
</body>
</html>
