/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import model.Produto;
import dao.ProdutoDao;
import dao.FilialDao;
import dao.UsuarioDao;
import model.Filial;
import java.sql.SQLException;
import java.util.List;
import model.Usuario;

/**
 *
 * @author vitor.lsantos5
 */
public class teste {

    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ArrayList<Produto> teste;
        teste = ProdutoDao.encontrarProdutoPorId(2);

        for (Produto p : teste) {
            System.out.println(p.getNome());
        }
        
        ArrayList<Filial> x;
        x = FilialDao.listar();
        for (Filial f : x) {
            System.out.println(f.getNome());
        }

        ArrayList<Usuario> users;
        users = UsuarioDao.listarUsuarios();
        for (Usuario u : users) {
            System.out.println(u.getNome());
        }
        
    }
}
