<%--
  Created by IntelliJ IDEA.
  User: suneee
  Date: 2018/12/11
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/db/req.action" method="post">
    <input type="text" name="userName">
    <input type="password" name="password">
    <input type="submit" value="提交">
</form>
<br>
<form action="/db/path/customer/001.action" method="post">
    <input type="submit" value="提交">
</form>
<form action="/db/simple.action" method="post">
    <input type="text" name="userName">
    <input type="password" name="password">
    <input type="submit" value="提交">
</form>
<form action="/db/req.action" method="post">
    <input type="text" name="userName">
    <input type="password" name="password">
    <input type="submit" value="提交">
</form>
<form action="/db/jb.action" method="post">
    <input type="text" name="userName">
    <input type="password" name="password">
    <input type="submit" value="提交">
</form>
<form action="/db/jbjb.action" method="post">
    <input type="text" name="userName">
    <input type="password" name="password">
    <input type="text" name="role.id">
    <input type="text" name="role.name">
    <input type="submit" value="提交">
</form>
<form action="/db/con.action" method="post">
    <input type="text" name="birth">
    <input type="submit" value="提交">
</form>
<form action="/db/arr.action" method="post">
    <input type="checkbox" name="like" value="1">学习<br>
    <input type="checkbox" name="like" value="2">锻炼<br>
    <input type="checkbox" name="like" value="3">看书<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
