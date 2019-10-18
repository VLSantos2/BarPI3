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
}
