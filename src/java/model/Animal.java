package model;

import dao.AnimalDAO;
import dao.RacaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Animal {

    private int codAnimal;
    private String nome;
    private float peso;
    private String dtNascimento;
    private String tipoSanguineo;
    private Raca raca;
    private Cliente dono;
    private int codRaca;
    private int codCliente;

    public Animal(int codAnimal, String nome, float peso, String dtNascimento, 
            String tipoSanguineo, Raca raca, Cliente dono) {
        this.codAnimal = codAnimal;
        this.nome = nome;
        this.peso = peso;
        this.dtNascimento = dtNascimento;
        this.tipoSanguineo = tipoSanguineo;
        this.raca = raca;
        this.dono = dono;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Raca getRaca() throws ClassNotFoundException, SQLException {
        if ((this.codRaca != 0) && (this.raca == null)) {
            this.raca = Raca.obterRaca(this.codRaca);
        }
        return this.raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    
    public Cliente getDono() throws ClassNotFoundException, SQLException {
        if ((this.codCliente != 0) && (this.dono == null)) {
            this.dono = Cliente.obterCliente(this.codCliente);
        }
        return this.dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public int getCodRaca() {
        return codRaca;
    }

    public void setCodRaca(int codRaca) {
        this.codRaca = codRaca;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public static Animal obterAnimal(int codAnimal) throws ClassNotFoundException, SQLException {
        return AnimalDAO.obterAnimal(codAnimal);
    }

    public static List<Animal> obterAnimais() throws ClassNotFoundException, SQLException {
        return AnimalDAO.obterAnimais();
    }
        
    public void gravar () throws ClassNotFoundException, SQLException {
        AnimalDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        AnimalDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        AnimalDAO.alterar(this);
    }

}
