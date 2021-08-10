<%-- 
    Document   : SalvarCadastro
    Created on : 10/08/2021, 11:27:44
    Author     : mbaca
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salvar Cadastro</title>
    </head>
    <body>
        <%
            String snome = request.getParameter("nome");
            String semail = request.getParameter("email");
            String ssenha = request.getParameter("senha");

            Usuario usu = new Usuario();
            usu.setNome(snome);
            usu.setEmail(semail);
            usu.setSenha(ssenha);

            UsuarioDAO usuDAO = new UsuarioDAO();
            usuDAO.insertUsuarios(usu);

            RequestDispatcher rd = request.getRequestDispatcher("cadastrar_sucesso.jsp");
            rd.forward(request, response);

        %>

    </body>
</html>

