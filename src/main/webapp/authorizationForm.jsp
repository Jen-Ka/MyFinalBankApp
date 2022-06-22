<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"
isELIgnored="false"
session="true"
%>
<%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
%>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <div class="form">

        <h1>Вход в систему</h1><br>
        <form method="post" action="authorization">

        <label for="login"><b>Логин</b></label>
        <input type="text" required placeholder="login" name="login"><br><br>

        <label for="password"><b>Пароль</b></label>
        <input type="password" required placeholder="password" name="password"><br><br>


        <input class="button" type="submit" value="Войти">

        </form>
    </div>
</body>
</html>