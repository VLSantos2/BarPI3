package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuarios;

/**
 *
 * @author MILENA
 */
public class UsuariosDao {

    public Usuarios buscar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Usuarios WHERE id = ???";
        Connection conn = interface_conexao.obterConexao();
        try (
                PreparedStatement comando = conn.prepareStatement(sql);) {
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Usuarios u = new Usuarios(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getInt(4),
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
      public boolean cadastrar(Usuarios usuarios) throws ClassNotFoundException, SQLException {
        Connection conn = interface_conexao.obterConexao();
        String sql = "INSERT INTO Usuarios (id, email, sexo, senha, nome, id_filial, cargo ) values(?,?,?,?,?,?,?);";
        try (
            PreparedStatement comando = conn.prepareStatement(sql); ){

            comando.setInt(1, usuarios.getId());
            comando.setString(2,usuarios.getEmail());
            comando.setString(3, usuarios.getSexo());  
            comando.setInt(4,usuarios.getSenha());
            comando.setString(4,usuarios.getNome());
            comando.setInt(4,usuarios.getId_filial());
            comando.setInt(4,usuarios.getCargo());
            
            comando.execute();
            
            return true;
            
        } catch (SQLException ex) {
            
        } finally {
            conn.close();
        }
        
        return false;
    }
       public boolean atualizar( Usuarios u) throws SQLException, ClassNotFoundException {
    String sql = "UPDATE Usuarios SET nome = ?, Id = ?, dt_nascimento = ?, telefone = ?, WHERE id = ?;"; 
    Connection conn = interface_conexao.obterConexao();
    try (           
            PreparedStatement comando = conn.prepareStatement(sql);){

             comando.setInt(1, u.getId());
            comando.setString(2,u.getEmail());
            comando.setString(3, u.getSexo());  
            comando.setInt(4,u.getSenha());
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
       public boolean excluir(int id) throws ClassNotFoundException, SQLException {
    Connection conn = interface_conexao.obterConexao();
    String sql = "DELETE FROM usuarios WHERE id = ?;";
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
