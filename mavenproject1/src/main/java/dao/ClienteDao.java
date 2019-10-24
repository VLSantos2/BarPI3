package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;



/**
 *
 * @author MILENA
 */
public class ClienteDao {

       public static Cliente buscar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Cliente WHERE id = ???";
        Connection conn = interface_conexao.obterConexao();
        try (
                PreparedStatement comando = conn.prepareStatement(sql);) {
                    comando.setInt(1, id);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {                
                    Cliente c = new Cliente(
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
       
       public static boolean cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conn = interface_conexao.obterConexao();
        String sql = "INSERT INTO Cliente (nome, id, dt_nascimento, telefone ) values(?,?,?,?);";
        try (
            PreparedStatement comando = conn.prepareStatement(sql); ){

            comando.setString(1, cliente.getNome());
            comando.setInt(2,cliente.getId());
            comando.setDate(3, cliente.getDt_nascimento());  
            comando.setInt(4,cliente.getTelefone());
            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }
       public static boolean atualizar(int id, Cliente c) throws SQLException, ClassNotFoundException {
    String sql = "UPDATE Cliente SET nome = ?, Id = ?, dt_nascimento = ?, telefone = ?, WHERE id = ?;"; 
    Connection conn = interface_conexao.obterConexao();
    try (           
            PreparedStatement comando = conn.prepareStatement(sql);){

            comando.setString(1, c.getNome());
            comando.setInt(2, c.getId());
            comando.setDate(3, c.getDt_nascimento());
             comando.setInt(3, c.getTelefone());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {

        } finally {
            conn.close();
        }
    return false;
}
       public static boolean excluir(int id) throws ClassNotFoundException, SQLException {
    Connection conn = interface_conexao.obterConexao();
    String sql = "DELETE FROM cliente WHERE id = ?;";
        try (PreparedStatement comando = conn.prepareStatement(sql);){
            comando.setInt(1, id);
            
            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
        } finally {

        }
        
        return false;
    }
   
}