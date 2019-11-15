package model;

import dao.PagamentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucsd
 */
public class Pagamento {

    private int codPagamento;
    private float valorTotal;
    private float valorPago;
    private Procedimento procedimento;
    private int codProcedimento;

    public Pagamento(int codPagamento, float valorTotal, float valorPago, Procedimento procedimento) {
        this.codPagamento = codPagamento;
        this.valorTotal = valorTotal;
        this.valorPago = valorPago;
        this.procedimento = procedimento;
    }

    public int getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(int codPagamento) {
        this.codPagamento = codPagamento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }
    
    /**
     * @return the procedimento
     */
    public Procedimento getProcedimento() throws ClassNotFoundException, SQLException {
        if ((this.codProcedimento != 0) && (this.procedimento == null)) {
            this.procedimento = Procedimento.obterProcedimento(this.codProcedimento);
        }
        return this.procedimento;
    }

    /**
     * @param procedimento the procedimento to set
     */
    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
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
    
    public static Pagamento obterPagamento(int codPagamento) throws ClassNotFoundException, SQLException {
        return PagamentoDAO.obterPagamento(codPagamento);
    }

    public static List<Pagamento> obterPagamentos() throws ClassNotFoundException, SQLException {
        return PagamentoDAO.obterPagamentos();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        PagamentoDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        PagamentoDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        PagamentoDAO.alterar(this);
    }

}
