
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Raphael Thalles
 */
public class ConexaoDAO {
    public Connection conectaBD() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/estoqueleilao";
            String user = "root";
            String password = "Derpixon_96";

            conn = (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }

        return conn;
    }
}
