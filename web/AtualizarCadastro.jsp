<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cadastro </title>
    </head>
    <body>
        <%
            Usuario usuario = (Usuario) request.getAttribute("usuario");
           

        %>
        <h1>Editar Cadastro</h1>
        <form action="Controler" method="POST"> 
            <p>
                <label>ID:</label>
                <input size="1"  name="id" value="<%usuario.getId();%>" required>
            </p>
            <p>
                <label>Nome:</label>
                <input  name="nome" required value="<%usuario.getNome();%>">
            </p>
            <p>
                <label>E-mail:</label>
                <input type="email" name="email" required value="<%usuario.getEmail();%>">
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha" minlength="4" required value="<%usuario.getSenha();%>">
            </p>
            <input type="submit" value="Salvar"> 
        </form> 
    </body>
</html>
 