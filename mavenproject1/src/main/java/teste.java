/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import model.Produto;
import dao.ProdutoDao;
import java.sql.SQLException;
/**
 *
 * @author vitor.lsantos5
 */
public class teste {
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        ArrayList<Produto> teste;
        teste = ProdutoDao.encontrarProdutoPorId(2);
        
    }
}
