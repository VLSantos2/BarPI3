package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author MILENA
 */
public class UsuarioDao {

    public static Usuario buscar(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Usuarios WHERE id = ???";
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

    public static ArrayList<Usuario> listarUsuarios() throws SQLException, ClassNotFoundException {

        ArrayList<Usuario> usuarioRetorno = new ArrayList<Usuario>();
        String sql = "select u.* from usuarios u;";

        try (Connection conn = interface_conexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);) {
            ResultSet retorno = select.executeQuery();
            //    public Usuario(int id, String email, String sexo, String senha, String nome, int id_filial, int cargo) 
            while (retorno.next()) {
                Usuario user = new Usuario(
                        retorno.getInt("id"),
                        retorno.getString("email"),
                        retorno.getString("sexo"),
                        retorno.getString("senha"),
                        retorno.getString("nome"),
                        retorno.getInt("id_filial"),
                        retorno.getInt("cargo")
                );

                usuarioRetorno.add(user);
            }
            conn.close();
        }
        return usuarioRetorno;
    }

    public static boolean atualizar(Usuario u) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Usuarios SET nome = ?, Id = ?, dt_nascimento = ?, telefone = ?, WHERE id = ?;";
        Connection conn = interface_conexao.obterConexao();
        try (
                PreparedStatement comando = conn.prepareStatement(sql);) {

            comando.setInt(1, u.getId());
            comando.setString(2, u.getEmail());
            comando.setString(3, u.getSexo());
            comando.setString(4, u.getSenha());
            comando.setString(4, u.getNome());
            comando.setInt(4, u.getId_filial());
            comando.setInt(4, u.getCargo());

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
        String sql = "DELETE FROM usuarios WHERE id = ?;";
        try (PreparedStatement comando = conn.prepareStatement(sql);) {
            comando.setInt(1, id);

            comando.execute();

            return true;

        } catch (SQLException ex) {

        } finally {

        }

        return false;
    }

    public static boolean inserirUsuario(Usuario u) throws ClassNotFoundException, SQLException {

        boolean retorno = false;

        String sql = "insert into usuarios(email, sexo, senha, nome, id_filial, cargo) values(?,?,?,?,?,?);";

        try (Connection conn = interface_conexao.obterConexao();
                PreparedStatement insert = conn.prepareStatement(sql);) {
            insert.setString(1, u.getEmail());
            insert.setString(2, u.getSexo());
            insert.setString(3, u.getSenha());
            insert.setString(4, u.getNome());
            insert.setInt(5, u.getId_filial());
            insert.setInt(6, u.getCargo());

            int linhasAfetadas = insert.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        }
        return retorno;
    }

}
