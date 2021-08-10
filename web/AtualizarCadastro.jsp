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
            Usuario usu = (Usuario)request.getAttribute("usuario");
            
            %>
        <h1>Editar Cadastro</h1>
        <form action="Controler" method="POST"> 
            <input type="hidden" name="acao" value="salvar">
            <p>
                <label>ID:</label>
                <input  name="id" value="<%=usu.getId()%>" required>
            </p>
            <p>
                <label>Nome:</label>
                <input  name="nome" required value="<%=usu.getNome()%>">
            </p>
            <p>
                <label>E-mail:</label>
                <input type="email" name="email" required value="<%=usu.getEmail()%>">
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha" minlength="6" required value="<%=usu.getSenha()%>">
            </p>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
