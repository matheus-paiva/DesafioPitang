
package Servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;


@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
        rd.forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
       
        Usuario u = UsuarioDAO.buscarUsuarioPorEmail(email);
        
        boolean loginSucesso = false;
        
        if ( u !=null && u.getSenha().equals(senha)){
            loginSucesso=true;
              }
        
        if (loginSucesso){
            HttpSession ses = request.getSession();
            
            ses.setAttribute("usuarioLogado", u);
            
            RequestDispatcher rd= request.getRequestDispatcher("Homepage.jsp");
             rd.forward(request, response);
            
        }else {
            request.setAttribute("erro","E-mail/senha incorretos");
            
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
