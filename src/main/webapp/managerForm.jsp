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
    <title>ADMIN</title>
</head>
<body>

<h1>Hello, ADMIN!</h1><br><br>

<a href="/managePage">К списку клиентов</a><br><br>

<a href="<c:url value='/clientAdd.jsp' />">Добавить клиента</a><br><br>

<a href="<c:url value='/index.jsp' />">To the main page</a>
</body>
</html>