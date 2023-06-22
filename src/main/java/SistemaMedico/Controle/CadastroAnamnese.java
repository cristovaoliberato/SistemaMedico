package SistemaMedico.Controle;

import SistemaMedico.Modelo.Anamnese;
import SistemaMedico.Modelo.Usuario;
import SistemaMedico.Persistencia.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CadastroAnamnese", value = "/CadastroAnamnese")
public class CadastroAnamnese extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String loginPaciente = request.getParameter("login_paciente");
        String exameFisico = request.getParameter("exame_fisico");
        String examesComplementares = request.getParameter("exames_complementares");
        String resultadosExames = request.getParameter("resultados_exames");
        String hipotesesDiagnosticas = request.getParameter("hipoteses_diagnosticas");
        String tratamentoEfetuado = request.getParameter("tratamento_efetuado");
        String diagnosticoDefinitivo = request.getParameter("diagnostico_definitivo");
        HttpSession session = request.getSession(true);
        Usuario medico = (Usuario) session.getAttribute("usuario");
        if (loginPaciente != null && loginPaciente.length() > 0 &&
                exameFisico != null && exameFisico.length() > 0 &&
                examesComplementares != null && examesComplementares.length() > 0 &&
                resultadosExames != null && resultadosExames.length() > 0 &&
                hipotesesDiagnosticas != null && hipotesesDiagnosticas.length() > 0 &&
                tratamentoEfetuado != null && tratamentoEfetuado.length() > 0 &&
                diagnosticoDefinitivo != null && diagnosticoDefinitivo.length() > 0)
        {
            if (medico.isMedico())
            {
                Anamnese consulta = new Anamnese(loginPaciente, medico.getLogin(), exameFisico, examesComplementares, resultadosExames, hipotesesDiagnosticas, tratamentoEfetuado, diagnosticoDefinitivo);
                try {
                    AnamneseInterface dao=new AnamneseClasseDao();
                    dao.inserir(consulta);
                    List<Anamnese> anamneses = dao.buscar(loginPaciente);
                    session.setAttribute("consultas", anamneses);
                    dao.sair();
                    response.sendRedirect("inicio.jsp?paciente="+loginPaciente);
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                response.sendRedirect("inicio.jsp?mensagem=Acesso negado");
            }
        }
        else
        {
            response.sendRedirect("formularioAnamnese.jsp?paciente=" + loginPaciente);
        }
    }
}
