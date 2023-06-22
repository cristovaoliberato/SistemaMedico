<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<div class="header">
    <div class="left-buttons">
        <a href="inicio.jsp?tipo=pacientes">Início</a>
        <c:if test="${sessionScope.usuario != null and sessionScope.usuario.medico}">
            <a href="formularioUsuario.jsp?tipo=cadastrar">Cadastrar Usuário</a>
            <a href="formularioAnamnese.jsp">Realizar Consulta</a>
        </c:if>
    </div>
    <div class="right-text">
        <c:choose>
            <c:when test="${sessionScope.usuario != null}">
                <a href="EditarUsuario?login=${sessionScope.usuario.login}">${sessionScope.usuario.nome}</a>
                <a href="Sair"><i class="fas fa-sign-out-alt"></i></a>
            </c:when>
            <c:otherwise>
                <p>Desconectado</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
