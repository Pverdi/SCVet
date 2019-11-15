/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Pagamento;

/**
 *
 * @author lucsd
 */
public class PagamentoDAO {

    public static Pagamento obterPagamento(int codPagamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pagamento pagamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pagamento where codPagamento = " + codPagamento);
            rs.first();
            pagamento = instanciarPagamento(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return pagamento;
    }

    public static List<Pagamento> obterPagamentos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pagamento> pagamentos = new ArrayList<Pagamento>();
        Pagamento pagamento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pagamento");
            while (rs.next()) {
                pagamento = instanciarPagamento(rs);
                pagamentos.add(pagamento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return pagamentos;
    }

    public static void gravar(Pagamento pagamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into pagamento (codPagamento, valorTotal, valorPago, Procedimento_codProcedimento)"
                    + " values (?,?,?,?)");
            comando.setInt(1, pagamento.getCodPagamento());
            comando.setFloat(2, pagamento.getValorTotal());
            comando.setFloat(3, pagamento.getValorPago());
            if (pagamento.getProcedimento() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, pagamento.getProcedimento().getCodProcedimento());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Pagamento pagamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from pagamento where codPagamento = " + pagamento.getCodPagamento();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Pagamento pagamento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update pagamento set "
                    + "valorTotal = '" + pagamento.getValorTotal() + "', "
                    + "valorPago = '" + pagamento.getValorPago() + "', "
                    + "Procedimento_codProcedimento = ";
            if (pagamento.getProcedimento() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + pagamento.getProcedimento().getCodProcedimento();
            }
            stringSQL = stringSQL + " where codPagamento = " + pagamento.getCodPagamento();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Pagamento instanciarPagamento(ResultSet rs) throws SQLException {
        Pagamento pagamento = new Pagamento(rs.getInt("codPagamento"),
                rs.getFloat("valorTotal"),
                rs.getFloat("valorPago"),
                null);
        pagamento.setCodProcedimento(rs.getInt("Procedimento_codProcedimento"));
        return pagamento;
    }
}
