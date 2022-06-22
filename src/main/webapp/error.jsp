<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8"
isELIgnored="false"
%>
<%
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
%>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>NOT FOUND</title>

</head>
<body>
        <h1>К сожалению, вы ошиблись, нет пользователя с такими данными:(</h1>

<div class="row">
    <div class="side">
        <h2>Проверьте логин и пароль и попробуйте ещё раз!</h2>
    </div>

    <div class="main">

        <a href="<c:url value='/index.jsp' />">To the main page</a>

    </div>
</div>

</body>
</html>