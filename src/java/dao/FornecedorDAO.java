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
import model.Fornecedor;

/**
 *
 * @author lucsd
 */
public class FornecedorDAO {

    public static Fornecedor obterFornecedor(int codFornecedor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Fornecedor fornecedor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from fornecedor where codFornecedor = " + codFornecedor);
            rs.first();
            fornecedor = instanciarFornecedor(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return fornecedor;
    }

    public static List<Fornecedor> obterFornecedores()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        Fornecedor fornecedor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from fornecedor");
            while (rs.next()) {
                fornecedor = instanciarFornecedor(rs);
                fornecedores.add(fornecedor);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return fornecedores;
    }

    public static void gravar(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into fornecedor (codFornecedor, nomeContato, nomeEmpresa, "
                    + "cnpj, numeroEndereco,"
                    + " email, complementoEndereco, telefone, cep, cidade, estado, bairro, logradouro)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, fornecedor.getCodFornecedor());
            comando.setString(2, fornecedor.getNomeContato());
            comando.setString(3, fornecedor.getNomeEmpresa());
            comando.setString(4, fornecedor.getCnpj());
            comando.setInt(5, fornecedor.getNumeroEndereco());
            comando.setString(6, fornecedor.getEmail());
            comando.setString(7, fornecedor.getComplementoEndereco());
            comando.setString(8, fornecedor.getTelefone());
            comando.setInt(9, fornecedor.getCep());
            comando.setString(10, fornecedor.getCidade());
            comando.setString(11, fornecedor.getEstado());
            comando.setString(12, fornecedor.getBairro());
            comando.setString(13, fornecedor.getLogradouro());

            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from fornecedor where codFornecedor = " + fornecedor.getCodFornecedor();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void alterar(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update fornecedor set "
                    + "nomeContato = '" + fornecedor.getNomeContato() + "', "
                    + "nomeEmpresa = '" + fornecedor.getNomeEmpresa() + "', "
                    + "cnpj = '" + fornecedor.getCnpj() + "', "
                    + "numeroEndereco = '" + fornecedor.getNumeroEndereco() + "', "
                    + "email = '" + fornecedor.getEmail() + "', "
                    + "complementoEndereco = '" + fornecedor.getComplementoEndereco() + "', "
                    + "telefone = '" + fornecedor.getTelefone() + "', "
                    + "cep = '" + fornecedor.getCep() + "', "
                    + "cidade = '" + fornecedor.getCidade() + "', "
                    + "estado = '" + fornecedor.getEstado() + "', "
                    + "bairro = '" + fornecedor.getBairro() + "', "
                    + "logradouro = '" + fornecedor.getLogradouro() + "' ";

            stringSQL = stringSQL + " where codFornecedor = " + fornecedor.getCodFornecedor();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Fornecedor instanciarFornecedor(ResultSet rs) throws SQLException, ClassNotFoundException {
        Fornecedor fornecedor = new Fornecedor(rs.getInt("codFornecedor"),
                rs.getString("nomeContato"),
                rs.getString("nomeEmpresa"),
                rs.getString("cnpj"),
                rs.getInt("numeroEndereco"),
                rs.getString("email"),
                rs.getString("complementoEndereco"),
                rs.getString("telefone"),
                rs.getInt("cep"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("bairro"),
                rs.getString("logradouro"));

        return fornecedor;
    }
}
