<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"
isELIgnored="false"
session = "true"
%>
<%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
%>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Банк надежд</title>

</head>
<body>
        <h1>Добро пожаловать в наш банк! <br><br>
        Наше приложение может работать намного лучше, но не сегодня!</h1>

<div class="row">
    <div class="side">
        <h2>Чтобы попасть в личный кабинет, авторизуйтесь</h2>
    </div>

    <div class="main">

        <a href="/authorizationForm.jsp">Войти в личный кабинет</a><br><br>

    </div>
</div>

</body>
</html>