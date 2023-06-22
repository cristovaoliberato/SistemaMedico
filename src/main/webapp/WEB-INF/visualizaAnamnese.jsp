<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="welcome">
  <h1>Consulta</h1>
</div>
<div class="container-cadastro">
    <div class="input-group" >
      <label>ID Consulta:
        <input type="text" name="id_consulta" value="${sessionScope.consulta.id}" disabled>
      </label>
    </div>
    <div class="input-group" >
      <label>Login Paciente:
        <input type="text" name="login_paciente" value="${sessionScope.consulta.loginPaciente}" disabled>
      </label>
    </div>
  <div class="input-group" >
    <label>Login Médico:
      <input type="text" name="login_medico" value="${sessionScope.consulta.loginMedico}" disabled>
    </label>
  </div>
    <div class="input-group">
      <label>Exame Físico:</label>
      <textarea name="exame_fisico" rows="4" cols="50" disabled>${sessionScope.consulta.exameFisico}</textarea>
    </div>
    <div class="input-group">
      <label>Exames Complementares:</label>
      <textarea name="exames_complementares" rows="4" cols="50" disabled>${sessionScope.consulta.examesComplementares}</textarea>
    </div>
    <div class="input-group">
      <label>Resultados dos Exames:</label>
      <textarea name="resultados_exames" rows="4" cols="50" disabled>${sessionScope.consulta.resultadosExames}</textarea>
    </div>
    <div class="input-group">
      <label>Hipóteses Diagnósticas:</label>
      <textarea name="hipoteses_diagnosticas" rows="4" cols="50" disabled>${sessionScope.consulta.hipotesesDiagnosticas}</textarea>
    </div>
    <div class="input-group">
      <label>Diagnóstico Definitivo:</label>
      <textarea name="diagnostico_definitivo" rows="4" cols="50" disabled> ${sessionScope.consulta.diagnosticoDefinitivo}</textarea>
    </div>
    <div class="input-group">
      <label>Tratamento Efetuado:</label>
      <textarea name="tratamento_efetuado" rows="4" cols="50" disabled>${sessionScope.consulta.tratamentoEfetuado}</textarea>
    </div>
</div>
</body>
</html>
