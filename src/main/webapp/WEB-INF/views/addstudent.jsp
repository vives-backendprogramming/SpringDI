<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Add new student</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">

</head>
<body>
<div class="container">

    <h1 class="mt-3">Voeg nieuwe student toe aan: ${className}</h1>
    <form:form action="savestudent" modelAttribute="student" method="POST">
        <div class="form-group">
            <form:label path="firstName">Voornaam</form:label>
            <form:input path="firstName" class="form-control"/>
            <form:errors path="firstName" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <form:label path="lastName">Familienaam</form:label>
            <form:input path="lastName" class="form-control"/>
            <form:errors path="lastName" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <form:label path="email">Emailadres</form:label>
            <form:input path="email" class="form-control"/>
            <form:errors path="email" cssClass="alert-danger" />

        </div>
        <button type="submit" class="btn btn-primary">Opslaan</button>
    </form:form>
</div>
</body>
</html>
