package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author vitor.lsantos5
*/
public class interface_conexao {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3307/bar?useTimezone=true&serverTimezone=UTC";
    private final static String USUARIO = "root";
    private final static String SENHA = ""; //<-- lembrar de trocar essa senha
    
    protected static Connection obterConexao() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn;
    }
}
