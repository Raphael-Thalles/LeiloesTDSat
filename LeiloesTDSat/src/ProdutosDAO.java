/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;



public class ProdutosDAO {
private Connection conexao;
   
public ProdutosDAO() throws SQLException {
    this.conexao = conectaDAO.getConnection(); 
}
    public List<ProdutosDTO> listarProdutos() {
        List<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos Where status = 'A Venda'";

        try (Connection conn = conectaDAO.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ProdutosDTO p = new ProdutosDTO();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setStatus(rs.getString("status"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }
  public boolean salvar(ProdutosDTO produto) {
    String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

    try (Connection conn = conectaDAO.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getValor());
        stmt.setString(3, produto.getStatus());

        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Erro ao salvar produto: " + e.getMessage());
        return false;
    }
}

  public void venderProduto(int idProduto) {
        Connection conn = conectaDAO.getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idProduto);
                stmt.executeUpdate();

                // Se quiser, pode fechar os recursos aqui
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar produto: " + e.getMessage());
            }
        } else {
            System.out.println("Falha na conexão com o banco.");
        }
    }
  
  public List<ProdutosDTO> listarProdutosVendidos() throws SQLException {
    List<ProdutosDTO> vendidos = new ArrayList<>();
    String sql = "SELECT id, nome, valor, status FROM produtos WHERE status = 'Vendido'";

    try (Connection con = conectaDAO.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            ProdutosDTO p = new ProdutosDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getInt("valor")); 
            p.setStatus(rs.getString("status")); 
            vendidos.add(p);
        }
    }

    return vendidos;
}

}
