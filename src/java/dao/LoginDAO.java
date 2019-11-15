package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Login;

/**
 *
 * @author lucsd
 */
public class LoginDAO {

    public static Login obterLogin(int codLogin) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Login login = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from login where codLogin = " + codLogin);
            rs.first();
            login = instanciarLogin(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return login;
    }

    public static List<Login> obterLogins()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Login> logins = new ArrayList<Login>();
        Login login = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from login");
            while (rs.next()) {
                login = instanciarLogin(rs);
                logins.add(login);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return logins;
    }

    public static void gravar(Login login) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into login (codLogin, id, senha)"
                    + " values (?,?,?)");
            comando.setInt(1, login.getCodLogin());
            comando.setString(2, login.getId());
            comando.setString(3, login.getSenha());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Login login) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from login where codLogin = " + login.getCodLogin();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Login instanciarLogin(ResultSet rs) throws SQLException {
        Login login = new Login(rs.getInt("codLogin"),
                rs.getString("id"),
                rs.getString("senha"));
        return login;
    }
}
