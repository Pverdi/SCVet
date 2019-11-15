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
import java.util.ArrayList;
import java.util.List;
import model.Procedimento;

/**
 *
 * @author Iago
 */
public class ProcedimentoDAO {

    public static Procedimento obterProcedimento(int codProcedimento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Procedimento procedimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from procedimento where codProcedimento = " + codProcedimento);
            rs.first();
            procedimento = instanciarProcedimento(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return procedimento;
        }

    public static List<Procedimento> obterProcedimentos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Procedimento> procedimentos = new ArrayList<>();
        Procedimento procedimento = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from procedimento");
            while (rs.next()) {
                procedimento = instanciarProcedimento(rs);
                procedimentos.add(procedimento);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return procedimentos;
    }

    public static void gravar(Procedimento procedimento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into procedimento (codProcedimento, nome, valor)"
                    + " values (?,?,?)");
            comando.setInt(1, procedimento.getCodProcedimento());
            comando.setString(2, procedimento.getNome());
            comando.setFloat(3, procedimento.getValor());
           
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Procedimento procedimento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from procedimento where codProcedimento = " 
                    + procedimento.getCodProcedimento();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Procedimento procedimento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update procedimento set "
                    + "nome = '" + procedimento.getNome() + "', "
                    + "valor = " + procedimento.getValor();
            stringSQL = stringSQL + " where codProcedimento = " + procedimento.getCodProcedimento();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }}

    private static Procedimento instanciarProcedimento(ResultSet rs) throws SQLException, ClassNotFoundException {
        Procedimento procedimento = new Procedimento(rs.getInt("codProcedimento"),
                rs.getString("nome"),
                rs.getFloat("valor"));
        return procedimento;
    }
    
}
