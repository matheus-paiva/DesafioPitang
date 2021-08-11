<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cadastro </title>
    </head>
    <body>
        <h1>Realizar Cadastro</h1>
        <form method ="POST" action="SalvarCadastro.jsp">
            <p>
                <label>Nome:</label>
                <input  name="nome" required/>
            </p>
            <p>
                <label>E-mail:</label>
                <input type="email" name="email" required/>
            </p>
            <p>
                <label>Senha:</label>
                <input type="password" name="senha" minlength="6" required/>
            </p>
            <input type="submit" value="Cadastrar"/>
        </form>
        <p>
            <a href="index.jsp"> Voltar para página inicial </a>
        </p>
    </body>
</html>
