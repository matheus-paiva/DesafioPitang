
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
    </head>
    <body>
        <h1>Página inicial</h1>
        <a>
            <%
                Usuario u = (Usuario) session.getAttribute("usuarioLogado");
                if (u != null) {

                    out.print(u.getEmail());
                }
            %>
        </a>
        <a href="LogoutServlet"> Sair </a>
    </body>
</html>
