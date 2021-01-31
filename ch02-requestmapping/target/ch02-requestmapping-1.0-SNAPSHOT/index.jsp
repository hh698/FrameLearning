<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>第一个springmvc请求</p>
    <p><a href="/some.do">发起some.do的get请求</a> </p>
    <form action="/other.do" method="post">
        <input type="submit" value="发起other.do的post请求">
    </form>
</body>
</html>
