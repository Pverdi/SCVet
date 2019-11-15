package model;

import dao.AgendaDAO;
import dao.AnimalDAO;
import dao.ClienteDAO;
import dao.FuncionarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;


public class Agenda {

    private int codAgenda;
    private String data;
    private int hora;
    private int numeroSala;
    private String tipoAtendimento;
    private Cliente cliente;
    private Animal animal;
    private Funcionario veterinario;
    private int codCliente;
    private int codAnimal;
    private int codFuncionario;

    public Agenda(int codAgenda, String data, int hora, int numeroSala,String tipoAtendimento, Cliente cliente, Animal animal, Funcionario veterinario) {
        this.codAgenda = codAgenda;
        this.data = data;
        this.hora = hora;
        this.numeroSala = numeroSala;
        this.tipoAtendimento = tipoAtendimento;
        this.cliente = cliente;
        this.animal = animal;
        this.veterinario = veterinario;
    }

        public int getCodAgenda() {
        return codAgenda;
    }

    public void setCodAgenda(int codAgenda) {
        this.codAgenda = codAgenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    
        public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public Cliente getCliente() throws ClassNotFoundException, SQLException {
        if ((this.codCliente != 0) && (this.cliente == null)) {
            this.cliente = Cliente.obterCliente(this.codCliente);
        }
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Funcionario getVeterinario() throws ClassNotFoundException, SQLException {
        if ((this.codFuncionario != 0) && (this.veterinario == null)) {
            this.veterinario = Funcionario.obterFuncionario(this.codFuncionario);
        }
        return this.veterinario;
    }

    public void setVeterinario(Funcionario veterinário) {
        this.veterinario = veterinario;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public static Agenda obterAgenda(int codAgenda) throws ClassNotFoundException, SQLException {
        return AgendaDAO.obterAgenda(codAgenda);
    }

    public static List<Agenda> obterAgendas() throws ClassNotFoundException, SQLException {
        return AgendaDAO.obterAgendas();
    }

    public void gravar () throws ClassNotFoundException, SQLException {
        AgendaDAO.gravar(this);
    }

    public void excluir () throws ClassNotFoundException, SQLException {
        AgendaDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        AgendaDAO.alterar(this);
    }

}
