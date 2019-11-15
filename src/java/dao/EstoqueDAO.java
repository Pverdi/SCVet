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
import model.Estoque;

/**
 *
 * @author lucsd
 */
public class EstoqueDAO {

    public static Estoque obterEstoque(int codEstoque) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Estoque estoque = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from estoque where codEstoque = " + codEstoque);
            rs.first();
            estoque = instanciarEstoque(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return estoque;
    }

    public static List<Estoque> obterEstoques()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Estoque> estoques = new ArrayList<>();
        Estoque estoque = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from estoque");
            while (rs.next()) {
                estoque = instanciarEstoque(rs);
                estoques.add(estoque);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return estoques;
    }

    public static void gravar(Estoque estoque) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into estoque (codEstoque, nome, lote, vencimento, tipo)"
                    + " values (?,?,?,?,?)");
            comando.setInt(1, estoque.getCodEstoque());
            comando.setString(2, estoque.getNome());
            comando.setString(3, estoque.getLote());
            comando.setString(4, estoque.getVencimento());
            comando.setString(5, estoque.getTipo());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Estoque estoque) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from estoque where codEstoque = " + estoque.getCodEstoque();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Estoque instanciarEstoque(ResultSet rs) throws SQLException, ClassNotFoundException {
        Estoque estoque = new Estoque(rs.getInt("codEstoque"),
                rs.getString("nome"),
                rs.getString("lote"),
                rs.getString("data"),
                rs.getString("tipo"));

        return estoque;
    }
}
