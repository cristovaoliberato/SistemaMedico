package SistemaMedico.Controle;

import SistemaMedico.Modelo.Usuario;
import SistemaMedico.Persistencia.ErroDao;
import SistemaMedico.Persistencia.UsuarioClasseDAO;
import SistemaMedico.Persistencia.UsuarioInterfaceDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditarUsuario", value = "/EditarUsuario")
public class EditarUsuario extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        try
        {
            UsuarioInterfaceDAO dao  = new UsuarioClasseDAO();
            Usuario usuarioEncontrado = dao.buscar(login);
            if (usuarioEncontrado != null)
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("usuarioEdita", usuarioEncontrado);
                request.getRequestDispatcher("formularioUsuario.jsp?tipo=editar").forward(request, response);
            }
            else
            {
                response.sendRedirect("inicio?mensagem=falha ao encontrar usuario");
            }
        } catch (ErroDao e)
        {
            throw new RuntimeException(e);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession(true);
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
        Usuario usuarioEditado = (Usuario) session.getAttribute("usuarioEdita");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String sexo = request.getParameter("sexo");
        String maenome = request.getParameter("maenome");
        String municipio = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String endereco = request.getParameter("endereco");
        String dataNascimento = request.getParameter("dataNascimento");
        String crm = request.getParameter("crm");
        String isDoctor = request.getParameter("isDoctorCheckbox");
        String especialidade = request.getParameter("especialidade");
        UsuarioInterfaceDAO dao= null;
        try {
            dao = new UsuarioClasseDAO();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        if (usuarioLogado.isMedico())
        {
            if (!usuarioEditado.isMedico())
            {
                try {
                    dao.editar(usuarioEditado.getLogin(), senha,endereco);
                    dao.sair();
                    session.removeAttribute("usuarioEdita");
                    response.sendRedirect("inicio.jsp?mensagem=Editado com sucesso");
                } catch (ErroDao | IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (usuarioEditado.isMedico() && usuarioEditado.getLogin().equals(usuarioLogado.getLogin()))
            {
                Usuario u=new Usuario( usuarioLogado.getLogin(),  senha,  nome,  email,  sexo,  maenome,  municipio,  estado,  endereco,  dataNascimento, false);
                if (isDoctor != null)
                {
                    u.setMedico(true);
                    u.setCrm(crm);
                    u.setEspecialidade(especialidade);
                }
                try {
                    dao.editar(u);
                    dao.sair();
                } catch (ErroDao e) {
                    throw new RuntimeException(e);
                }
                session.invalidate();
                response.sendRedirect("index.jsp?mensagem=Dados atualizados, realize o login novamente");
            }
        }
        else if (!usuarioLogado.isMedico() && usuarioEditado.getLogin().equals(usuarioLogado.getLogin()))
        {
            try {
                dao.editar(usuarioEditado.getLogin(), senha,endereco);
                dao.sair();
                session.invalidate();
                response.sendRedirect("index.jsp?mensagem=Dados atualizados, realize o login novamente");
            } catch (ErroDao | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
