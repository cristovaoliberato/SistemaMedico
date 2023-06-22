<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<c:import url="WEB-INF/cabecalho.jsp"/>
<head>
    <meta charset="UTF-8">
    <script src="script.js"></script>
    <link rel="stylesheet" href="stylesheet.css">
    <title>Formulário de Usuário</title>
</head>
<body>
<c:choose>
    <c:when test="${param.tipo eq 'cadastrar'}">
        <c:import url="WEB-INF/cadastroUsuario.jsp"/>
    </c:when>
    <c:otherwise>
        <c:import url="WEB-INF/editarUsuario.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>
