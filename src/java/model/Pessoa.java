package model;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public abstract class Pessoa {

    private String nome;
    private int numeroEndereco;
    private String email;
    private String complementoEndereco;
    private String telefone;
    private int cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String logradouro;
    

    public Pessoa(String nome, int numeroEndereco, String email, String complementoEndereco, String telefone,
            int cep, String cidade, String estado, String bairro, String logradouro){
        this.nome = nome;
        this.numeroEndereco = numeroEndereco;
        this.email = email;
        this.complementoEndereco = complementoEndereco;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.logradouro = logradouro;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }


    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
//    public void excluir() throws ClassNotFoundException, SQLException {
//        PessoaDAO.excluir(this);
//    }
}
