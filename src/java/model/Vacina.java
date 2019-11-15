package model;

import dao.VacinaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Iago
 */
public class Vacina{

    
    private int codVacina;
    private String duracao;
    private String descricao;
    private float dose;
    private String via;
    private String contraIndicacoes;
    private float temperatura;
    private String nome;
    private String lote;
    private String tipo;
    private String vencimento;
    private Fornecedor fornecedor;
    private int codFornecedor;
    

    public Vacina(int codVacina, String duracao, String descricao, float dose, String via,
            String contraIndicacoes, float temperatura, String nome, String lote,
            String tipo, String vencimento, Fornecedor fornecedor) {
        this.duracao = duracao;
        this.descricao = descricao;
        this.dose = dose;
        this.via = via;
        this.contraIndicacoes = contraIndicacoes;
        this.temperatura = temperatura;
        this.codVacina = codVacina;
        this.nome = nome;
        this.lote = lote;
        this.tipo = tipo;
        this.vencimento = vencimento;
        this.fornecedor = fornecedor;
    }

    public int getCodVacina() {
        return codVacina;
    }

    public void setCodVacina(int codVacina) {
        this.codVacina = codVacina;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    public static Vacina obterVacina(int codVacina) throws ClassNotFoundException, SQLException {
        return VacinaDAO.obterVacina(codVacina);
    }

    public static List<Vacina> obterVacinas() throws ClassNotFoundException, SQLException {
        return VacinaDAO.obterVacinas();
    }


    public void gravar() throws ClassNotFoundException, SQLException {
        VacinaDAO.gravar(this);
    }


    public void excluir() throws ClassNotFoundException, SQLException {
        VacinaDAO.excluir(this);
    }
    

    public void alterar() throws ClassNotFoundException, SQLException {
        VacinaDAO.alterar(this);
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
}
