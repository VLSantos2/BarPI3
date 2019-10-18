package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Clientes;

/**
 *
 * @author MILENA
 */
public class ClientesDao {

    public static ArrayList<Clientes> encontrarClientesporId(int id) throws SQLException, ClassNotFoundException {

        ArrayList<Clientes> ClientesRetorno = new ArrayList<Clientes>();
        String sql = "SELECT p.* FROM Clientes p WHERE id =?;  id = ?;";

        try (Connection conn = interface_conexao.obterConexao();
                PreparedStatement select = conn.prepareStatement(sql);) {
            select.setInt(1, id);
            ResultSet retorno = select.executeQuery();
            //public Clientes(String nome, int id, date dt_nascimento, int telefone)
            while (retorno.next()) {
                Clientes p = new Clientes(
                        retorno.getString(1),
                        retorno.getInt(2),
                        retorno.getDate(3),
                        retorno.getInt(4)
                );

                ClientesRetorno.add(p);
            }
            conn.close();
        }
        return ClientesRetorno;
    }

}
