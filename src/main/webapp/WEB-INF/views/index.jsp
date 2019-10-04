<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welkom</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">
    <div class="jumbotron mt-3">
        <h1 class="display-4">Welkom</h1>
        <div class="small text-monospace">
            <div>
                <span>Datum en tijd:</span><span>${sysdate}</span>
            </div>
            <div>
                <span>Versie:</span><span>v${version}</span>
            </div>
        </div>
        <hr class="my-4">
        <p class="lead">
            Kies een klas om van start te gaan:
        </p>
        <a class="btn btn-primary btn-lg mt-4" href="<c:url value='/klas/3APP' />" role="button">3APP</a>
        <a class="btn btn-primary btn-lg mt-4" href="<c:url value='/klas/3NET' />" role="button">3NET</a>
        <a class="btn btn-primary btn-lg mt-4" href="<c:url value='/klas/3BIT' />" role="button">3BIT</a>
    </div>
    <img src="<c:url value='/resources/images/springlogo.png' />" class="rounded mx-auto d-block" alt="Spring logo" width="200"/>
</div>
</body>
</html>
