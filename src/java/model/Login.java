package model;

import dao.LoginDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Login {

    private int codLogin;
    private String id;
    private String senha;

    public Login(int codLogin, String id, String senha) {
        this.codLogin = codLogin;
        this.id = id;
        this.senha = senha;
    }

    /**
     * @return the codLogin
     */
    public int getCodLogin() {
        return codLogin;
    }

    /**
     * @param codLogin the codLogin to set
     */
    public void setCodLogin(int codLogin) {
        this.codLogin = codLogin;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Login obterLogin(int codLogin) throws ClassNotFoundException, SQLException {
        return LoginDAO.obterLogin(codLogin);
    }

    public static List<Login> obterLogins() throws ClassNotFoundException, SQLException {
        return LoginDAO.obterLogins();
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        LoginDAO.excluir(this);
    }
}
