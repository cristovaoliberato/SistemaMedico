<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edição</title>
</head>
<body>
<c:if test="${sessionScope.usuario.medico != true and sessionScope.usuario.login != sessionScope.usuarioEdita.login }">
    <jsp:forward page="../inicio.jsp?mensagem=Acesso negado"></jsp:forward>
</c:if>
<div class="welcome">
    <h1>Formulário de Edição</h1>
</div>
<div class="container-cadastro">
    <div class="content">
        <form action="EditarUsuario" method="post">
            <div class="input-group">
                <label>Login:
                    <input type="text" name="login" value="${sessionScope.usuarioEdita.login}" disabled>
                </label>
            </div>
            <div class="input-group">
                <label>Senha:
                    <input type="password" name="senha" required value="${sessionScope.usuarioEdita.senha}">
                </label>
            </div>
            <div class="input-group">
                <label>Nome:
                    <input type="text" name="nome" ${sessionScope.usuario.medico ? '' : 'disabled'} required value="${sessionScope.usuarioEdita.nome}">
                </label>
            </div>
            <div class="input-group">
                <label>Email:
                    <input type="text" name="email" ${sessionScope.usuario.medico ? '' : 'disabled'} required value="${sessionScope.usuarioEdita.email}">
                </label>
            </div>
            <div class="input-group">
                <label class="radio-label">Sexo:</label>
                <label><input type="radio" name="sexo" ${sessionScope.usuario.medico ? '' : 'disabled'}${sessionScope.usuarioEdita.medico ? '' : 'disabled'}required value="masculino" ${sessionScope.usuarioEdita.sexo == 'masculino' ? 'checked' : ''} >Masculino</label>
                <label><input type="radio" name="sexo" ${sessionScope.usuario.medico ? '' : 'disabled'} required value="feminino" ${sessionScope.usuarioEdita.sexo == 'feminino' ? 'checked' : ''} >Feminino</label>
            </div>
            <div class="input-group">
                <label>Nome da Mãe:
                    <input type="text" ${sessionScope.usuario.medico ? '' : 'disabled'} name="maenome" required value="${sessionScope.usuarioEdita.maenome}">
                </label>
            </div>
            <div class="input-group">
                <label>Estado:</label>
                <select id="estado" name="estado" ${sessionScope.usuario.medico ? '' : 'disabled'} required onchange="atualizarCidades()">
                    <option value="${sessionScope.usuarioEdita.estado}">${sessionScope.usuarioEdita.estado}</option>
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
                <select id="cidade" value="${sessionScope.usuarioEdita.municipio}" ${sessionScope.usuario.medico ? '' : 'disabled'} required name="cidade">
                    <option value="${sessionScope.usuarioEdita.municipio}">${sessionScope.usuarioEdita.municipio}</option>
                </select>
            </div>
            <div class="input-group">
                <label>Endereço:
                    <input type="text" name="endereco" required value="${sessionScope.usuarioEdita.endereco}">
                </label>
            </div>
            <div class="input-group">
                <label>Data de Nascimento:
                    <input type="date" ${sessionScope.usuario.medico ? '' : 'disabled'} name="dataNascimento" required value="${sessionScope.usuarioEdita.dataNascimento}">
                </label>
            </div>
            <div class="input-group">
                <label class="checkbox-label">É médico?</label>
                <label>
                    <input type="checkbox" ${sessionScope.usuario.medico ? '' : 'disabled'} id="isDoctorCheckbox" value="true" name="isDoctorCheckbox" ${sessionScope.usuarioEdita.medico ? 'checked' : ''} onclick="mostrarCampos()"> Sim
                </label>
            </div>
            <div id="crmField" class="input-group" style="display: none;">
                <label>CRM:
                    <input type="text" name="crm" value="${sessionScope.usuarioEdita.crm}" disabled>
                </label>
            </div>
            <div id="especialidadeField" class="input-group" style="display: none;">
                <label>Especialidade:
                    <input type="text" name="especialidade" value="${sessionScope.usuarioEdita.especialidade}" disabled>
                </label>
            </div>
            <button type="submit">Salvar</button>
        </form>
    </div>
</div>
</body>
</html>
