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

@WebServlet(name = "Logar", value = "/Logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        if (login != null && login.length() > 0 && senha != null && senha.length() > 0)
        {
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senha);
            try {
                UsuarioInterfaceDAO dao = new UsuarioClasseDAO();
                Usuario usuarioEncontrado = dao.buscar(usuario);
                if (usuarioEncontrado != null)
                {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("usuario", usuarioEncontrado);
                    if(usuarioEncontrado.isMedico())
                    {
                        List<Usuario> usuarios = dao.buscar();
                        session.setAttribute("usuarios", usuarios);
                        response.sendRedirect("inicio.jsp?tipo=pacientes");
                    }
                    else
                    {
                        response.sendRedirect("BuscaAnamnese?paciente="+usuarioEncontrado.getLogin());
                    }
                } else {
                    response.sendRedirect("index.jsp?mensagem=Login ou senha incorretos");
                }
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        } else
        {
            response.sendRedirect("index.jsp?mensagem=Dados incompletos");
        }
    }
}
