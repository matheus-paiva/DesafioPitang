package Servlet;

import dao.TelefoneDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Telefone;
import model.Usuario;

@WebServlet(name = "ExcluirTelefone", urlPatterns = {"/ExcluirTelefone"})
public class ExcluirTelefone extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();

        Usuario u = (Usuario) ses.getAttribute("usuarioLogado");

        int id_usuario = u.getId();
        
       
       String ddd = request.getParameter("ddd");
       String numero = request.getParameter("numero");
       String tipo = request.getParameter("tipo");
       
       Telefone t = new Telefone(Integer.parseInt(ddd),numero,tipo,id_usuario);
       
       
 
        TelefoneDAO.excluirTelefone(t);
        
      request.setAttribute("msg","Telefone excluido com sucesso!");
      RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
      rd.forward(request, response);
       

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
