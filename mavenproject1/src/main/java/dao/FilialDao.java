/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Filial;

/**
 *
 * @author matheus.jmaia
 */
public class FilialDao {
    
    public static ArrayList<Filial> encontrarProdutoId(int id) throws SQLException, ClassNotFoundException {
        
        ArrayList<Filial> FilialRetorno = new ArrayList<Filial>();
        String sql = "SELECT p.* FROM FILIAIS p WHERE id =?;  id = ?;";
        
        try (Connection conn = interface_conexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);) {
            select.setInt(1, id);
            ResultSet retorno = select.executeQuery();
            while (retorno.next()) {
                Filial p = new Filial(
                        retorno.getInt(1),
                        retorno.getString(2),
                        retorno.getInt(3)
                );
                
                FilialRetorno.add(p);
            }
            conn.close();
        }
        return FilialRetorno;
    }
}
