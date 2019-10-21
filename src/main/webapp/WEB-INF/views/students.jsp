<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Studenten</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">

    <h1 class="mt-3">Studenten uit de klas: ${className}</h1>
    <table class="table table-striped mt-2">
        <thead class="thead-light">
            <tr>
                <th>Voornaam</th>
                <th>Naam</th>
                <th>Mail</th>
            </tr>
        </thead>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td><a href="<c:url value='/klas/${className}/mail/${student.id}' />" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Mail student</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value='/klas/${className}/add' />" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Nieuwe student toevoegen</a>
</div>
</body>
</html>
