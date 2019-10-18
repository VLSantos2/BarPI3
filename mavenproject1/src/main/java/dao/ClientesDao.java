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
       public boolean cadastrar(Clientes clientes) throws ClassNotFoundException, SQLException {
        Connection conn = interface_conexao.obterConexao();
        String sql = "INSERT INTO Clientes (nome, id, dt_nascimento, telefone ) values(?,?,?,?);";
        try (
            PreparedStatement comando = conn.prepareStatement(sql); ){

            comando.setString(1, clientes.getNome());
            comando.setInt(2,clientes.getId());
            comando.setDate(3, clientes.getDt_nascimento());  
            comando.setInt(4,clientes.getTelefone());
            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }
   
}