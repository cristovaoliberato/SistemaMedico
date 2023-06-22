<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>MediCare - Login</title>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
<c:if test="${sessionScope.usuario != null}">
    <jsp:forward page="inicio.jsp" />
</c:if>
<div class="container-login">
    <div class="content">
        <h1>Bem-vindo ao MediCare</h1>
        <p>Faça login para acessar o sistema de prontuário médico.</p>
        <form action="Logar" method="POST">
            <div class="input-group">
                <label for="username">Login:
                    <input type="text" id="username" name="login" required>
                </label>
            </div>
            <div class="input-group">
                <label for="password">Senha:
                    <input type="password" id="password" name="senha" required>
                </label>
            </div>
            <c:if test="${not empty param.mensagem}">
                <div class="mensagem">
                        ${param.mensagem}
                </div>
            </c:if>
            <button type="submit">Entrar</button>
        </form>
    </div>
</div>
</body>
</html>
