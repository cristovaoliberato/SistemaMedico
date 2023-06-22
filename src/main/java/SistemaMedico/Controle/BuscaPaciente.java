package SistemaMedico.Controle;

import SistemaMedico.Modelo.Usuario;
import SistemaMedico.Persistencia.ErroDao;
import SistemaMedico.Persistencia.UsuarioClasseDAO;
import SistemaMedico.Persistencia.UsuarioInterfaceDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BuscaPaciente", value = "/BuscaPaciente")
public class BuscaPaciente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        try {
            UsuarioInterfaceDAO dao = new UsuarioClasseDAO();
            HttpSession session = request.getSession(true);
            List<Usuario> usuarios = dao.buscar(nome, "");
            session.setAttribute("usuarios", usuarios);
            response.sendRedirect("inicio.jsp?tipo=pacientes");
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
    }
}
