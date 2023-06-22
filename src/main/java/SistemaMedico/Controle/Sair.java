package SistemaMedico.Controle;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Sair", value = "/Sair")
public class Sair extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao=request.getSession();
        if(sessao.getAttribute("usuario")!=null)
        {
            sessao.removeAttribute("usuario");
            sessao.removeAttribute("usuarios");
        }
        response.sendRedirect("index.jsp");
    }
}
