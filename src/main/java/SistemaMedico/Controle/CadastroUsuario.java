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

@WebServlet(name = "CadastroUsuario", value = "/CadastroUsuario")
public class CadastroUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String login = request.getParameter("login");
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
        if (login != null && login.length() > 0 &&
                senha != null && senha.length() > 0 &&
                nome != null && nome.length() > 0 &&
                email != null && email.length() > 0 &&
                sexo != null && sexo.length() > 0 &&
                maenome != null && maenome.length() > 0 &&
                municipio != null && municipio.length() > 0 &&
                estado != null && estado.length() > 0 &&
                endereco != null && endereco.length() > 0 &&
                dataNascimento != null && dataNascimento.length() > 0)
        {
            Usuario u=new Usuario( login,  senha,  nome,  email,  sexo,  maenome,  municipio,  estado,  endereco,  dataNascimento, false);
            if (isDoctor != null)
            {
                if (crm != null && crm.length() > 0 && especialidade != null && especialidade.length() > 0)
                {
                    u.setMedico(true);
                    u.setCrm(crm);
                    u.setEspecialidade(especialidade);
                }
                else
                {
                    response.sendRedirect("inicio.jsp?mensagem=Dados do(a) médico(a) incompletos");
                }
            }
            try {
                UsuarioInterfaceDAO dao=new UsuarioClasseDAO();
                dao.inserir(u);
                List<Usuario> usuarios = dao.buscar();
                HttpSession session = request.getSession(true);
                session.setAttribute("usuarios", usuarios);
                dao.sair();
                response.sendRedirect("inicio.jsp?tipo=pacientes");
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            response.sendRedirect("inicio.jsp?mensagem=Dados incompletos");
        }
    }


}
