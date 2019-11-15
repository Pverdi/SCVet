package model;

import dao.AnimalDAO;
import dao.ProcedimentoDAO;
import dao.ProntuarioDAO;
import dao.VacinaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iago
 */
public class Prontuario {

    private int codProntuario;
    private String data;
    private int hora;
    private String descricao;
    private Vacina vacina;
    private Animal animal;
    private Procedimento procedimento;
    private int codAnimal;
    private int codVacina;
    private int codProcedimento;

    public Prontuario(int codProntuario, String data, int hora, String descricao,
            Vacina vacina, Animal animal, Procedimento procedimento) {
        this.codProntuario = codProntuario;
        this.animal = animal;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.vacina = vacina;
        this.procedimento = procedimento;
    }

    public int getCodProntuario() {
        return codProntuario;
    }

    public void setCodProntuario(int codProntuario) {
        this.codProntuario = codProntuario;
    }

    public String getData() {
        return data;
    }

    public void setString(String data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Prontuario obterProntuario(int codProntuario) throws ClassNotFoundException, SQLException {
        return ProntuarioDAO.obterPronturario(codProntuario);
    }

    public static List<Prontuario> obterProntuarios() throws ClassNotFoundException, SQLException {
        return ProntuarioDAO.obterProntuarios();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        ProntuarioDAO.gravar(this);
    }

    public Animal getAnimal() throws ClassNotFoundException, SQLException {
        if ((this.codAnimal != 0) && (this.animal == null)) {
            this.animal = Animal.obterAnimal(this.codAnimal);
        }
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) throws ClassNotFoundException, SQLException {
        this.codAnimal = codAnimal;
    }

    public Vacina getVacina() throws ClassNotFoundException, SQLException {
        if ((this.codVacina != 0) && (this.vacina == null)) {
            this.vacina = Vacina.obterVacina(this.codVacina);
        }
        return this.vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public int getCodVacina() {
        return codVacina = codVacina;
    }
    
    public Procedimento getProcedimento() throws ClassNotFoundException, SQLException {
        if ((this.codProcedimento != 0) && (this.procedimento == null)) {
            this.procedimento = Procedimento.obterProcedimento(this.codProcedimento);
        }
        return this.procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public int getCodProcedimento() {
        return codProcedimento;
    }

    public void setCodProcedimento(int codProcedimento) throws ClassNotFoundException, SQLException {
        this.codProcedimento = codProcedimento;
    }

    public void setCodVacina(int codVacina) throws ClassNotFoundException, SQLException {
        this.codVacina = codVacina;
    }

    public static Animal obterAnimal(int codAnimal) throws ClassNotFoundException, SQLException {
        return AnimalDAO.obterAnimal(codAnimal);
    }

    public static List<Animal> obterAnimais() throws ClassNotFoundException, SQLException {
        return AnimalDAO.obterAnimais();
    }
    public static Procedimento obterProcedimento(int codProcedimento) throws ClassNotFoundException, SQLException {
        return ProcedimentoDAO.obterProcedimento(codProcedimento);
    }

    public static List<Procedimento> obterProcedimentos() throws ClassNotFoundException, SQLException {
        return ProcedimentoDAO.obterProcedimentos();
    }

    public static Vacina obterVacina(int codVacina) throws ClassNotFoundException, SQLException {
        return VacinaDAO.obterVacina(codVacina);
    }

    public static List<Vacina> obterVacinas() throws ClassNotFoundException, SQLException {
        return VacinaDAO.obterVacinas();
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ProntuarioDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        ProntuarioDAO.alterar(this);
    }
}
