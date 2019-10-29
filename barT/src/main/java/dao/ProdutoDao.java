/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vitor.lsantos5
 */
public class ProdutoDao {
 
    public static ArrayList<Produto> encontrarProdutoPorId(int id) throws SQLException, ClassNotFoundException {
        
        ArrayList<Produto> produtoRetorno = new ArrayList<Produto>();
        String sql = "select p.* from produtos p where id = ?;";
        
        try (Connection conn = interface_conexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);) {
            select.setInt(1, id);
            ResultSet retorno = select.executeQuery();
            //public Produto(int id, String nome, int id_categoria, String tamanho, String sabor)
            while (retorno.next()) {
                System.out.println(retorno.getInt("id") );
                Produto p = new Produto(
                        retorno.getInt("id"),
                        retorno.getString("nome"),
                        retorno.getInt("id_categoria"),
                        retorno.getString("tamanho"),
                        retorno.getString("sabor")
                );
                
                produtoRetorno.add(p);
            }
            conn.close();
        }
        return produtoRetorno;
    }
}