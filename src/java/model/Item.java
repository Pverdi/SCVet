/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ItemDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author penel
 */
public class Item {

    private int codItem;
    private String nome;
    private int quantidade;
    private String lote;
    private String tipo;
    private String vencimento;
    private Fornecedor fornecedor;
    private int codFornecedor;

    public Item(int codItem, String nome, String lote, int quantidade, String tipo, String vencimento, Fornecedor fornecedor) {
        this.codItem = codItem;
        this.nome = nome;
        this.quantidade = quantidade;
        this.lote = lote;
        this.tipo = tipo;
        this.vencimento = vencimento;
        this.fornecedor = fornecedor;
    }

    /**
     * @return the codItem
     */
    public int getCodItem() {
        return codItem;
    }

    /**
     * @param codItem the codItem to set
     */
    public void setCodItem(int codItem) {
        this.codItem = codItem;
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    public static Item obterItem(int codItem) throws ClassNotFoundException, SQLException {
        return ItemDAO.obterItem(codItem);
    }

    public static List<Item> obterItens() throws ClassNotFoundException, SQLException {
        return ItemDAO.obterItens();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        ItemDAO.gravar(this);
    }

    /**
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() throws ClassNotFoundException, SQLException {
        if ((this.codFornecedor != 0) && (this.fornecedor == null)) {
            this.fornecedor = Fornecedor.obterFornecedor(this.codFornecedor);
        }
        return this.fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the codFornecedor
     */
    public int getCodFornecedor() {
        return codFornecedor;
    }

    /**
     * @param codFornecedor the codFornecedor to set
     */
    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ItemDAO.excluir(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException {
        ItemDAO.alterar(this);
    }


}
