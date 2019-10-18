
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
public boolean cadastrar(Filial filial) throws ClassNotFoundException, SQLException {
        Connection conn = interface_conexao.obterConexao();
        String sql = "INSERT INTO filiais (nome, id, id_endereco) values(?,?,?);";
        try (
            PreparedStatement comando = conn.prepareStatement(sql); ){

            comando.setString(1, filial.getNome());
            comando.setInt(2, filial.getId());
            comando.setInt(3, filial.getId_endereco());            
            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }
   
public boolean atualizar(int id, Filial f) throws SQLException, ClassNotFoundException {
    String sql = "UPDATE filiais SET nome = ?, Id_endereco = ?, WHERE id = ?;"; 
    Connection conn = interface_conexao.obterConexao();
    try (           
            PreparedStatement comando = conn.prepareStatement(sql);){

            comando.setString(1, f.getNome());
            comando.setInt(2, f.getId_endereco());
            comando.setInt(3, f.getId());

            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {

        } finally {
            conn.close();
        }
    return false;
}
}

