<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <title>Pacientes</title>
</head>
<body>
<c:if test="${sessionScope.usuario.medico != true}">
    <jsp:forward page="../index.jsp?mensagem=Acesso negado"></jsp:forward>
</c:if>
<form method="get" action="BuscaPaciente">
    <div class="welcome">
        <h1>Pacientes Cadastrados</h1>
        <div>
            <input type="text" placeholder="Pesquisar" name="nome">
            <button class="filterButton" type="submit">Buscar</button>
        </div>
    </div>
</form>
<div class="lista-paciente">
    <div class="paciente">
        <a href="formularioUsuario.jsp?tipo=cadastrar">CADASTRAR USUÁRIO</a>
    </div>
    <c:forEach var="usuario" items="${sessionScope.usuarios}">
        <div class="paciente">
            <h1>${usuario.nome}</h1>
            <p>${usuario.dataNascimento}</p>
            <p>
                <a href="EditarUsuario?login=${usuario.login}">Dados</a>
                <a href="BuscaAnamnese?paciente=${usuario.login}">Histórico</a>
            </p>
        </div>
    </c:forEach>
</div>
</body>
</html>
