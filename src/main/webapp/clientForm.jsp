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
    <title>USER</title>

</head>
<body>
        <h1>Hello, Client!</h1>

<div class="row">
    <div class="side">
        <h2>Личный кабинет клиента</h2>
    </div>

    <div class="main">

    <a href="/accountsClient">Мои счета</a><br><br>

        <a href="/cardsClient">Мои карты</a><br><br>

        <a href="/creditsClient">Мои кредиты</a><br><br>

        <a href="/mainClient">Перейти в профиль</a><br><br>

        <a href="/authorization" class="right">Выйти</a>

    </div>
</div>

</body>
</html>