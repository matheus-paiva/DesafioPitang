
package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Telefone;
import model.Usuario;

public class TelefoneDAO {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    private static final String SELECT_BY_USER_ID_SQL = "SELECT * FROM desafiopitang.telefones WHERE id_usuario= ? ";
    private static final String INSERT_SQL = "INSERT INTO desafiopitang.telefones (ddd,numero,tipo,id_usuario) VALUES ( ?, ? , ? , ?)";
    private static final String DELETE_SQL = "DELETE FROM desafiopitang.telefones WHERE id = ? and id_usuario= ?";
    
    
    
    
    public static List<Telefone> buscarTelefone(int id_usuario) {

        List<Telefone> listaTel = new ArrayList();

//Database Connect
        try {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = c.prepareStatement(SELECT_BY_USER_ID_SQL);
            stmt.setInt(1,id_usuario);
            
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                int ddd = rs.getInt("ddd");
                String numero = rs.getString("numero");
                String tipo = rs.getString("tipo");

                Telefone t = new Telefone(ddd,numero,tipo,id_usuario);
                
                
                listaTel.add(t);

            }

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
       return listaTel;
    }
    
    
    public static void insertTelefone(Telefone t) {

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);

            stmt.setInt(1, t.getDdd());
            stmt.setString(2, t.getNumero());
            stmt.setString(3, t.getTipo());
            stmt.setInt(4,t.getId_usuario());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
     
     
    public static void excluirTelefone (Telefone t) {

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement stmt = c.prepareStatement(DELETE_SQL);
            
           
            stmt.setInt(1, t.getId_usuario());
            
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
}
