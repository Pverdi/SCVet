package model;

import dao.EstoqueDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Estoque {

    private int codEstoque;
    private String nome;
    private String lote;
    private String vencimento;
    private String tipo;

    public Estoque(int codEstoque, String nome, String lote, String vencimento, String tipo) {
        this.codEstoque = codEstoque;
        this.nome = nome;
        this.lote = lote;
        this.vencimento = vencimento;
        this.tipo = tipo;
    }

    public int getCodEstoque() {
        return codEstoque;
    }

    public void setCodEstoque(int codEstoque) {
        this.codEstoque = codEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static Estoque obterEstoque(int codEstoque) throws ClassNotFoundException, SQLException {
        return EstoqueDAO.obterEstoque(codEstoque);
    }

    public static List<Estoque> obterEstoques() throws ClassNotFoundException, SQLException {
        return EstoqueDAO.obterEstoques();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        EstoqueDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        EstoqueDAO.excluir(this);
    }
}
