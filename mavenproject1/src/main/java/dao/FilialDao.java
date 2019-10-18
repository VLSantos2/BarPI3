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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Filial;

/**
 *
 * @author matheus.jmaia
 */
public class FilialDao {  
    
    public Filial buscar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM filiais WHERE id = ???";
        Connection conn = interface_conexao.obterConexao();
        try (
                PreparedStatement comando = conn.prepareStatement(sql);) {
                    comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                    Filial f = new Filial(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getInt(3)
                );
                
                return f;
            }           
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        return null;
    }
    
    
    
}

