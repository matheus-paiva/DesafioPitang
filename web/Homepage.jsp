
<%@page import="java.util.List"%>
<%@page import="model.Telefone"%>
<%@page import="dao.TelefoneDAO"%>
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
        <h1>Seja Bem Vindo!!</h1>
        <a>
            <%
                Usuario u = (Usuario) session.getAttribute("usuarioLogado");
                if (u != null) {

                    out.println(u.getEmail());

                }
            %>
        </a>
        <a href="LogoutServlet"> Sair </a>
        <hr>
        <form method="POST" action="AdicionarTelefone">
            <p>
                <label>DDD:</label> 
                <input size="1" type="text" name="ddd" maxlength="3" required/>
                <label>Número:</label>
                <input type="tel" name="numero" maxlength="9" required/>
                <label>Tipo:</label>
                <select name="tipo"> 
                    <option value="Celular">Celular</option>
                    <option value="Fixo">Fixo</option>
                </select> 
                <input type="submit" value="Adicionar"/>
            </p>
            <p>
                <%String msg = (String) request.getAttribute("msg");
                if (msg !=null) {
                    out.println(msg);
                }
                %> 
            </p>
     </form>
        <hr>
        <h1> Minha Agenda de Telefones </h1>

        <%
            int id_usuario = u.getId();

            List<Telefone> telList = TelefoneDAO.buscarTelefone(id_usuario);

            if (telList.isEmpty()){
             out.println("Não há telefone cadastrados. Cadastre seu número!");   
                
            }
            for (Telefone t : telList) {
        %>
        <p>

            <%out.print(t.getTipo() + " | " + "( " + t + ")" );
            
            
            %>

        </p>
        <%
            }
        %> 


    </body>
</html>
