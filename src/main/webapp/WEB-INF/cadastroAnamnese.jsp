<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${sessionScope.usuario.medico != true}">
  <jsp:forward page="../index.jsp?mensagem=Acesso negado"></jsp:forward>
</c:if>
<div class="welcome">
  <h1>Formulário de Consulta</h1>
</div>
<div class="container-cadastro">
  <form action="CadastroAnamnese" method="post">
    <div class="input-group" >
      <label>Login:
        <input type="text" name="login_paciente" value="${param.paciente}" required>
      </label>
    </div>
    <div class="input-group">
      <label>Exame Físico:</label>
      <textarea name="exame_fisico" rows="4" cols="50" required></textarea>
    </div>
    <div class="input-group">
      <label>Exames Complementares:</label>
      <textarea name="exames_complementares" rows="4" cols="50" required></textarea>
    </div>
    <div class="input-group">
      <label>Resultados dos Exames:</label>
      <textarea name="resultados_exames" rows="4" cols="50" required></textarea>
    </div>
    <div class="input-group">
      <label>Hipóteses Diagnósticas:</label>
      <textarea name="hipoteses_diagnosticas" rows="4" cols="50" required></textarea>
    </div>
    <div class="input-group">
      <label>Diagnóstico Definitivo:</label>
      <textarea name="diagnostico_definitivo" rows="4" cols="50" required></textarea>
    </div>
    <div class="input-group">
      <label>Tratamento Efetuado:</label>
      <textarea name="tratamento_efetuado" rows="4" cols="50" required></textarea>
    </div>
    <div class="input-group">
      <button type="submit">Enviar</button>
    </div>
  </form>
</div>
</body>
</html>
