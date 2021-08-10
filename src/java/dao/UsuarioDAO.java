package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String SELECT_SQL = "SELECT * FROM desafiopitang.usuario;";
    private static final String SELECT_BY_EMAIL_SQL = "SELECT * FROM desafiopitang.usuario WHERE email= ?";
    private static final String INSERT_SQL = "INSERT INTO desafiopitang.usuario (nome, email, senha) VALUES ( ?, ? , ?)";
    private static final String UPTADE_SQL = "UPDATE usuario SET nome= ? , email= ?, senha= ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM desafiopitang.usuario WHERE id = ?";

    //Listar
    public static List<Usuario> buscarUsuarios(Usuario u) {

        List<Usuario> usuario = new ArrayList<Usuario>();
        

//Database Connect
        try {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(SELECT_SQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Usuario usu = new Usuario();
                usu.setId(id);
                usu.setNome(nome);
                usu.setEmail(email);
                usu.setSenha(senha);

                usuario.add(usu);

            }

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return usuario;
    }

    //Buscando por email
    public static Usuario buscarUsuarioPorEmail(String email) {
        Usuario usu = null;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(SELECT_BY_EMAIL_SQL);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String senha = rs.getString("senha");

                usu = new Usuario();
                usu.setId(id);
                usu.setEmail(email);
                usu.setSenha(senha);

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return usu;
    }

    //Inserir
    public static void insertUsuarios(Usuario u) {
       
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());

            stmt.execute();
            stmt.close();
            

        } catch (SQLException e) {
            e.printStackTrace();

        }
       
    }

    //Atualizar
    public static void atualizarUsuarios(Usuario usuario) {
     
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = c.prepareStatement(UPTADE_SQL);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());

            stmt.execute();
            stmt.close();

           
      
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Deletar
    public static void deletarUsuarios(Usuario u) {
       
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = c.prepareStatement(DELETE_SQL);

            stmt.setInt(1, u.getId());
            stmt.execute();
            stmt.close();
            
           
        } catch (SQLException e) {
            e.printStackTrace();

}  
    }
    
    
    public  Usuario buscarporId (Integer id){
        Usuario usuRetorno = null;
        try{
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = c.prepareStatement(SELECT_SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                usuRetorno = new Usuario();
                usuRetorno.setId(rs.getInt("id"));
                usuRetorno.setNome(rs.getString("nome"));
                usuRetorno.setEmail(rs.getString("email"));
                usuRetorno.setSenha(rs.getString("senha"));
                
                
                
            }
                
        } catch(SQLException e){
            
        }
        
        return usuRetorno;
    }

}

   

