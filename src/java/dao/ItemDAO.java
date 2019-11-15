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
import model.Item;

/**
 *
 * @author penel
 */
public class ItemDAO {

    public static Item obterItem(int codItem) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Item item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from item where codItem = " + codItem);
            rs.first();
            item = instanciarItem(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return item;
    }

    public static List<Item> obterItens()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Item> itens = new ArrayList<Item>();
        Item item = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from item");
            while (rs.next()) {
                item = instanciarItem(rs);
                itens.add(item);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return itens;
    }

    public static void gravar(Item item) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into item (codItem, nome, lote, quantidade, tipo, vencimento, Fornecedor_codFornecedor)"
                    + " values (?,?,?,?,?,?,?)");
            comando.setInt(1, item.getCodItem());
            comando.setString(2, item.getNome());
            comando.setInt(3, item.getQuantidade());
            comando.setString(4, item.getLote());
            comando.setString(5, item.getTipo());
            comando.setString(6, item.getVencimento());
            if (item.getFornecedor() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, item.getFornecedor().getCodFornecedor());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Item item) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from item where codItem = " + item.getCodItem();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Item item) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update item set "
                    + "nome = '" + item.getNome() + "', "
                    + "lote = '" + item.getLote() + "', "
                    + "quantidade = '" + item.getQuantidade() + "', "
                    + "tipo = '" + item.getTipo() + "', "
                    + "vencimento = '" + item.getVencimento() + "', "
                    + "Fornecedor_codFornecedor = ";
            if (item.getFornecedor() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + item.getFornecedor().getCodFornecedor();
            }
            stringSQL = stringSQL + " where codItem = " + item.getCodItem();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Item instanciarItem(ResultSet rs) throws SQLException {
        Item item = new Item(rs.getInt("codItem"),
                rs.getString("nome"),
                rs.getString("lote"),
                rs.getInt("quantidade"),
                rs.getString("tipo"),
                rs.getString("vencimento"),
                null);
        item.setCodFornecedor(rs.getInt("Fornecedor_codFornecedor"));
        return item;
    }

}
