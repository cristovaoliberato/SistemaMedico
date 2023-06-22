<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<c:if test="${sessionScope.usuario == null}">
    <jsp:forward page="index.jsp" />
</c:if>
<c:import url="WEB-INF/cabecalho.jsp"/>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <title>MediCare</title>
</head>
<body>
<c:choose>
    <c:when test="${param.tipo eq 'pacientes' and sessionScope.usuario.medico}">
        <c:import url="WEB-INF/pacientes.jsp"/>
    </c:when>
    <c:otherwise>
        <c:import url="WEB-INF/anamneses.jsp?paciente=${param.paciente}"/>
    </c:otherwise>
</c:choose>
</body>
</html>
