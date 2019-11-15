package model;

import dao.RacaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Raca {

    private int codRaca;
    private String nome;
    private String porte;
    private String personalidade;
    private Especie especie;
    private int codEspecie;

    public Raca(int codRaca, String nome, String porte, String personalidade, Especie especie) {
        this.codRaca = codRaca;
        this.nome = nome;
        this.porte = porte;
        this.personalidade = personalidade;
        this.especie = especie;
    }

    public int getCodRaca() {
        return codRaca;
    }

    public void setCodRaca(int codRaca) {
        this.codRaca = codRaca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getPersonalidade() {
        return personalidade;
    }

    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }

    public Especie getEspecie() throws ClassNotFoundException, SQLException {
        if ((this.codEspecie != 0) && (this.especie == null)) {
            this.especie = Especie.obterEspecie(this.codEspecie);
        }
        return this.especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getCodEspecie() {
        return codEspecie;
    }

    public void setCodEspecie(int codEspecie) {
        this.codEspecie = codEspecie;
    }

    public static Raca obterRaca(int codRaca) throws ClassNotFoundException, SQLException {
        return RacaDAO.obterRaca(codRaca);
    }

    public static List<Raca> obterRacas() throws ClassNotFoundException, SQLException {
        return RacaDAO.obterRacas();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        RacaDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        RacaDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        RacaDAO.alterar(this);
    }
}
