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
    <title>ADD USER</title>
</head>
<body>
        <h1>Добавление нового клиента</h1>

<div class="row">
    <div class="side">
        <h2>Введите данные клиента</h2>
    </div>

    <div class="main">

    <form action="addClient" method="post">

        <label for="userId">Id client:</label><br>
        <input type="text" id="userId" name="userId"><br><br>

        <label for="login">Login:</label><br>
        <input type="text" id="login" name="login"><br><br>

        <label for="password">Password:</label><br>
        <input type="text" id="password" name="password"><br><br>

        <label for="userFirstName">First name:</label><br>
        <input type="text" id="userFirstName" name="userFirstName"><br><br>

        <label for="userLastName">Last name:</label><br>
        <input type="text" id="userLastName" name="userLastName"><br><br>

        <label for="clientAccounts">Accounts:</label><br>
        <input type="text" id="clientAccounts" name="clientAccounts"><br><br>

        <label for="clientCards">Cards:</label><br>
            <input type="text" id="clientCards" name="clientCards"><br><br>

        <label for="clientCredits">Credits:</label><br>
        <input type="text" id="clientCredits" name="clientCredits"><br><br>

        <br><br>
        <input class="button" type="submit" value="Создать запись для клиента">
      </form>

    </div>
</div>
<div>
  <a href="/managePage">К списку клиентов</a><br><br>
  <a href="<c:url value='/index.jsp' />">To the main page</a>
</div>
</body>
</html>