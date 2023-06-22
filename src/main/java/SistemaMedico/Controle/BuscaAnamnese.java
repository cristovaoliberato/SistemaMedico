package SistemaMedico.Controle;

import SistemaMedico.Modelo.Anamnese;
import SistemaMedico.Modelo.Usuario;
import SistemaMedico.Persistencia.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuscaAnamnese", value = "/BuscaAnamnese")
public class BuscaAnamnese extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String login = request.getParameter("paciente");
        String idConsulta = request.getParameter("idConsulta");
        String dataFiltro = request.getParameter("dataFiltro");

        if (login != null && !login.isEmpty() && dataFiltro == null) {
            try {
                AnamneseInterface dao = new AnamneseClasseDao();
                List<Anamnese> anamneses = dao.buscar(login);
                session.setAttribute("consultas", anamneses);
                response.sendRedirect("inicio.jsp?paciente="+login);
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        }

        else if (idConsulta != null && idConsulta.length() > 0)
        {
            try {
                AnamneseInterface dao = new AnamneseClasseDao();
                Anamnese anamnese = dao.buscar(Integer.parseInt(idConsulta));
                session.setAttribute("consulta", anamnese);
                response.sendRedirect("formularioAnamnese.jsp?tipo=visualizar");
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        }
        else if(dataFiltro != null && dataFiltro.length() > 0)
        {
            try {
                AnamneseInterface dao = new AnamneseClasseDao();
                List<Anamnese> anamneses = dao.buscarAnamnesesAposData(login, dataFiltro);
                session.setAttribute("consultas", anamneses);
                response.sendRedirect("inicio.jsp?paciente="+login);
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        }
        else {
            response.sendRedirect("index.jsp?mensagem=Erro ao acessar");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
