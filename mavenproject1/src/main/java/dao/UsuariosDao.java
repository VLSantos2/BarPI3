
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuarios;


/**
 *
 * @author MILENA
 */
public class UsuariosDao {
     public static ArrayList<Usuarios> encontrarUsuariosId(int id) throws SQLException, ClassNotFoundException {
        
        ArrayList<Usuarios> UsuariosRetorno = new ArrayList<Usuarios>();
        String sql = "SELECT p.* FROM Usuarios p WHERE id =?;  id = ?;";
        
        try (Connection conn = interface_conexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);) {
            select.setInt(1, id);
            ResultSet retorno = select.executeQuery();
            while (retorno.next()) {
                Usuarios p = new Usuarios(
                       
                        retorno.getInt(1),
                        retorno.getString(2),
                        retorno.getString(3),
                        retorno.getInt(4),
                        retorno.getString(5),
                        retorno.getInt(6),
                        retorno.getInt(7)
                );
                
                UsuariosRetorno.add(p);
            }
            conn.close();
        }
        return UsuariosRetorno;
    }
        
        
}


