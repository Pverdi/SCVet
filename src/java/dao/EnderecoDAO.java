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
import model.Endereco;

/**
 *
 * @author lucsd
 */
public class EnderecoDAO {

    public static Endereco obterEndereco(int codEndereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from endereco where codEndereco = " + codEndereco);
            rs.first();
            endereco = instanciarEndereco(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return endereco;
    }

    public static List<Endereco> obterEnderecos()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Endereco> enderecos = new ArrayList<Endereco>();
        Endereco endereco = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from endereco");
            while (rs.next()) {
                endereco = instanciarEndereco(rs);
                enderecos.add(endereco);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
    }

    public static void gravar(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into endereco (codEndereco, cep, estado, cidade, bairro, logradouro)"
                    + " values (?,?,?,?,?,?)");
            comando.setInt(1, endereco.getCodEndereco());
            comando.setInt(2, endereco.getCep());
            comando.setString(3, endereco.getEstado());
            comando.setString(4, endereco.getCidade());
            comando.setString(5, endereco.getBairro());
            comando.setString(6, endereco.getLogradouro());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from endereco where codEndereco = " + endereco.getCodEndereco();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Endereco endereco) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update endereco set "
                    + "cep = '" + endereco.getCep() + "'"
                    + "estado = '" + endereco.getEstado() + "'"
                    + "cidade = '" + endereco.getCidade() + "'"
                    + "bairro = '" + endereco.getBairro() + "'"
                    + "logradouro = '" + endereco.getLogradouro() + "'";

            stringSQL = stringSQL + " where codEndereco = " + endereco.getCodEndereco();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Endereco instanciarEndereco(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco(rs.getInt("codEndereco"),
                rs.getInt("cep"),
                rs.getString("estado"),
                rs.getString("cidade"),
                rs.getString("bairro"),
                rs.getString("logradouro"));
        return endereco;
    }
}
