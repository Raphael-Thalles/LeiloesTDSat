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
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }

    public boolean salvar(ProdutosDTO p) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt", true))) {
        String linha = p.getId() + ";" + p.getNome() + ";" + p.getValor() + ";" + p.getStatus();
        bw.write(linha);
        bw.newLine();
        return true;
    } catch (IOException e) {
        System.out.println("Erro ao salvar produto: " + e.getMessage());
        return false;
    }
}

    
    
    
        
}

