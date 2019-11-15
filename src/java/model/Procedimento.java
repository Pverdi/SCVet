/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ProcedimentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iago
 */
public class Procedimento {
    private int codProcedimento;
    private String nome;
    private float valor;

    public Procedimento(int codProcedimento, String nome, float valor){
        this.codProcedimento = codProcedimento;
        this.nome = nome;
        this.valor = valor;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @return the codProcedimento
     */
    public int getCodProcedimento() {
        return codProcedimento;
    }

    /**
     * @param codProcedimento the codProcedimento to set
     */
    public void setCodProcedimento(int codProcedimento) {
        this.codProcedimento = codProcedimento;
    }
    public static Procedimento obterProcedimento(int codProcedimento) throws ClassNotFoundException, SQLException {
        return ProcedimentoDAO.obterProcedimento(codProcedimento);
    }

    public static List<Procedimento> obterProcedimentos() throws ClassNotFoundException, SQLException {
        return ProcedimentoDAO.obterProcedimentos();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        ProcedimentoDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ProcedimentoDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        ProcedimentoDAO.alterar(this);
    }
    
}
