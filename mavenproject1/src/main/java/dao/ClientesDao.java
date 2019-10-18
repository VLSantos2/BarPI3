package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Clientes;



/**
 *
 * @author MILENA
 */
public class ClientesDao {

       public Clientes buscar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Clientes WHERE id = ???";
        Connection conn = interface_conexao.obterConexao();
        try (
                PreparedStatement comando = conn.prepareStatement(sql);) {
                    comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                    Clientes c = new Clientes(
                        resultado.getString(1),
                        resultado.getInt(2),
                        resultado.getDate(3),
                        resultado.getInt(4)
                );
                
                return c;
            }           
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        return null;
    }
}