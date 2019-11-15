/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EnderecoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucsd
 */
public class Endereco {
    
    private int codEndereco;
    private int cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;

    public Endereco(int codEndereco, int cep, String estado, String cidade, String bairro, String logradouro) {
        this.codEndereco = codEndereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public int getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(int codEndereco) {
        this.codEndereco = codEndereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
    public static Endereco obterEndereco(int codEndereco) throws ClassNotFoundException, SQLException {
        return EnderecoDAO.obterEndereco(codEndereco);
    }

    public static List<Endereco> obterEnderecos() throws ClassNotFoundException, SQLException {
        return EnderecoDAO.obterEnderecos();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        EnderecoDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        EnderecoDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        EnderecoDAO.alterar(this);
    }
}
