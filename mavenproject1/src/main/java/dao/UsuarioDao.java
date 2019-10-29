package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author MILENA
 */
public class UsuarioDao {

    public static Usuario buscar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Usuario"
                + " WHERE id = ???";
        Connection conn = interface_conexao.obterConexao();
        try (
                PreparedStatement comando = conn.prepareStatement(sql);) {
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Usuario u = new Usuario(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getInt(6),
                        resultado.getInt(7)
                );

                return u;
            }

        } catch (SQLException ex) {

        } finally {
            conn.close();
        }
        return null;
    }
      public static boolean cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection conn = interface_conexao.obterConexao();
        String sql = "INSERT INTO Usuario (id, email, sexo, senha, nome, id_filial, cargo ) values(?,?,?,?,?,?,?);";
        try (
            PreparedStatement comando = conn.prepareStatement(sql); ){

            comando.setInt(1, usuario.getId());
            comando.setString(2,usuario.getEmail());
            comando.setString(3, usuario.getSexo());  
            comando.setString(4,usuario.getSenha());
            comando.setString(4,usuario.getNome());
            comando.setInt(4,usuario.getId_filial());
            comando.setInt(4,usuario.getCargo());
            
            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }
       public static boolean atualizar( Usuario u) throws SQLException, ClassNotFoundException {
    String sql = "UPDATE Usuario SET nome = ?, Id = ?, dt_nascimento = ?, telefone = ?, WHERE id = ?;"; 
    Connection conn = interface_conexao.obterConexao();
    try (           
            PreparedStatement comando = conn.prepareStatement(sql);){

             comando.setInt(1, u.getId());
            comando.setString(2,u.getEmail());
            comando.setString(3, u.getSexo());  
            comando.setString(4,u.getSenha());
            comando.setString(4,u.getNome());
            comando.setInt(4,u.getId_filial());
            comando.setInt(4,u.getCargo());
            

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
    String sql = "DELETE FROM usuario WHERE id = ?;";
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
