<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <title>Pacientes</title>
</head>
<body>
<form method="get" action="BuscaAnamnese">
    <div class="welcome">
        <h1>Consultas Realizadas</h1>
        <div>
            <input type="date" name="dataFiltro">
            <input type="text" value="${param.paciente}" name="paciente" hidden>
            <button class="filterButton" type="submit">Buscar</button>
            <a href="BuscaAnamnese?paciente=${param.paciente}">Limpar Filtro</a>
        </div>
    </div>
</form>
<div class="lista-paciente">
    <c:if test="${sessionScope.usuario != null and sessionScope.usuario.medico}">
        <div class="paciente">
            <a href="formularioAnamnese.jsp?paciente=${param.paciente}">REALIZAR CONSULTA</a>
        </div>
    </c:if>

    <c:forEach var="consulta" items="${sessionScope.consultas}">
        <div class="paciente">
            <h1>${consulta.loginMedico}</h1>
            <p>${consulta.data}</p>
            <p>
                <a href="BuscaAnamnese?idConsulta=${consulta.id}">Visualizar</a>
            </p>
        </div>
    </c:forEach>
</div>
</body>
</html>
