package Controler;

import dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet(name = "Controler", urlPatterns = {"/Controler"})
public class Controler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario u = new Usuario();
        String acao = request.getParameter("acao");
        UsuarioDAO usuDAO = new UsuarioDAO();

        if (acao != null && acao.equals("lis")) {
            List<Usuario> usuarios = UsuarioDAO.buscarUsuarios(u);

            request.setAttribute("usuarios", usuarios);
            RequestDispatcher saida = request.getRequestDispatcher("lista_usuario.jsp");
            saida.forward(request, response);

        } else if (acao != null && acao.equals("ex")) {
            String id = request.getParameter("id");
            u.setId(Integer.parseInt(id));
            usuDAO.deletarUsuarios(u);
            response.sendRedirect("Controler?acao=lis");

        } else if (acao != null && acao.equals("alt")) {

            String id = request.getParameter("id");
            Usuario usuario = usuDAO.buscarporId(Integer.parseInt(id));
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("AtualizarCadastro.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid = request.getParameter("id");
        String snome = request.getParameter("nome");
        String semail = request.getParameter("email");
        String ssenha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setNome(snome);
        usuario.setEmail(semail);
        usuario.setSenha(ssenha);
        usuario.setId(Integer.parseInt(sid));

        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.atualizarUsuarios(usuario);
        response.sendRedirect("Controler?acao=lis");

    }

}
