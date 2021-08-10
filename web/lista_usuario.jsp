

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
    </head>
    <body>
        <h1>Usuários Cadastrados</h1>
        <%
            List<Usuario> listaResultado = (List<Usuario>)request.getAttribute("usuarios");
            %>
        <table border="1">
            <tr bgcolo="#eaeaea">
                <th>Id</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Senha</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <%  
              for (Usuario u : listaResultado) {       
            %>
            <tr>
                <th><%=u.getId()%></th>
                <th><%=u.getNome()%></th>
                <th><%=u.getEmail()%></th>
                <th><%=u.getSenha()%></th>
                <th><a href="Controler?acao=alt&id=<%=u.getId()%>">Editar</a>
                <th><a href="Controler?acao=ex&id=<%=u.getId()%>">Excluir</a>
            </tr>
            <%
                }
            %>
        </table>
        <p>
            <a href="index.jsp"> Voltar para página inicial </a>
        </p>
    </body>
</html>
