package servelet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FilialDao;
import dao.UsuarioDao;
import model.Filial;
import model.Usuario;

@WebServlet(name = "CadastrarUsuario", urlPatterns = "/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {
            ArrayList<Filial> filiais = FilialDao.listar();
            request.setAttribute("listaFiliais", filiais);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("action", "cadastroUsuario");
        request.setAttribute("pagina", "CADASTRO DE USUARIO");

        request.getRequestDispatcher("/WEB-INF/jsp/CadastroUsuario.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String email = request.getParameter("emailUsuario");
        String sexo = request.getParameter("sexoUsuario");
        String senha = request.getParameter("senhaUsuario");
        String nome = request.getParameter("nomeUsuario");
        int id_filial = Integer.valueOf(request.getParameter("filial"));
        int cargo = Integer.valueOf(request.getParameter("nivelAcessoUsuario"));

        try {
            Usuario user = new Usuario(email, sexo, senha, nome, id_filial, cargo);
            UsuarioDao.inserirUsuario(user);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CadastroUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("visualizarUsuarios").forward(request, response);
    }

}
