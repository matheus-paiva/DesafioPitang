<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String erro = (String) request.getAttribute("erro");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login </title>
    </head>
    <body>
        <h1>Faça o login</h1>
        <form method="POST" action="LoginServlet">
            <p>
                <label>Email:</label>
                <input type="email" name="email" required/>
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha" required/>
            </p>
            <input type="submit" value="Entrar"/>
            <p> <%  if (erro != null) {
                    out.print(erro);
                }
                %> </p>
        </form>
    </body>
</html>
