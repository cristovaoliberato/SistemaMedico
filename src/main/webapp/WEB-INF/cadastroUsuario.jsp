<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro</title>
</head>
<body>
<c:if test="${sessionScope.usuario.medico != true}">
    <jsp:forward page="../inicio.jsp?mensagem=Acesso negado"></jsp:forward>
</c:if>
<div class="welcome">
    <h1>Formulário de Cadastro</h1>
</div>
<div class="container-cadastro">
    <div class="content">
        <form action="CadastroUsuario" method="post">
            <div class="input-group">
                <label>Login:
                    <input type="text" name="login" required>
                </label>
            </div>
            <div class="input-group">
                <label>Senha:
                    <input type="password" name="senha" required>
                </label>
            </div>
            <div class="input-group">
                <label>Nome:
                    <input type="text" name="nome" required>
                </label>
            </div>
            <div class="input-group">
                <label>Email:
                    <input type="text" name="email" required>
                </label>
            </div>
            <div class="input-group">
                <label class="radio-label">Sexo:</label>
                <label><input type="radio" name="sexo" value="masculino" required>Masculino</label>
                <label><input type="radio" name="sexo" value="feminino" required>Feminino</label>
            </div>
            <div class="input-group">
                <label>Nome da Mãe:
                    <input type="text" name="maenome" required>
                </label>
            </div>
            <div class="input-group">
                <label>Estado:</label>
                <select id="estado" name="estado" required onchange="atualizarCidades()">
                    <option value="">Selecione</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espírito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>
            </div>
            <div class="input-group">
                <label>Cidade:</label>
                <select id="cidade" name="cidade" required>
                    <option value="">Selecione o estado primeiro</option>
                </select>
            </div>
            <div class="input-group">
                <label>Endereço:
                    <input type="text" name="endereco" required>
                </label>
            </div>
            <div class="input-group">
                <label>Data de Nascimento:
                    <input type="date" name="dataNascimento" required>
                </label>
            </div>
            <div class="input-group">
                <label class="checkbox-label">É médico?</label>
                <label><input type="checkbox" id="isDoctorCheckbox" value="true" name="isDoctorCheckbox" onclick="mostrarCampos()"> Sim</label>
            </div>
            <div id="crmField" class="input-group" style="display: none;">
                <label>CRM:
                    <input type="text" name="crm" disabled>
                </label>
            </div>
            <div id="especialidadeField" class="input-group" style="display: none;">
                <label>Especialidade:
                    <input type="text" name="especialidade" disabled>
                </label>
            </div>
            <button type="submit">Salvar</button>
        </form>
    </div>
</div>
</body>
</html>
