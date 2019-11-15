package model;

import dao.EspecieDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Especie {

    private int codEspecie;
    private String nome;

    public Especie(int codEspecie, String nome) {
        this.codEspecie = codEspecie;
        this.nome = nome;
    }

    public int getCodEspecie() {
        return codEspecie;
    }

    public void setCodEspecie(int codEspecie) {
        this.codEspecie = codEspecie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Especie obterEspecie(int codEspecie) throws ClassNotFoundException, SQLException {
        return EspecieDAO.obterEspecie(codEspecie);
    }

    public static List<Especie> obterEspecies() throws ClassNotFoundException, SQLException {
        return EspecieDAO.obterEspecies();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        EspecieDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        EspecieDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        EspecieDAO.alterar(this);
    }
}
