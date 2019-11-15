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
import model.Vacina;

/**
 *
 * @author lucsd
 */
public class VacinaDAO {

    public static Vacina obterVacina(int codVacina) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Vacina vacina = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from vacina where codVacina = " + codVacina);
            rs.first();
            vacina = instanciarVacina(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return vacina;
    }

    public static List<Vacina> obterVacinas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Vacina> vacinas = new ArrayList<Vacina>();
        Vacina vacina = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from vacina");
            while (rs.next()) {
                vacina = instanciarVacina(rs);
                vacinas.add(vacina);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return vacinas;
    }

    public static void gravar(Vacina vacina) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into vacina (codVacina, nome, lote, tipo, duracao, descricao, dose, via, contraIndicacoes,"
                    + " vencimento, temperatura, Fornecedor_codFornecedor)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, vacina.getCodVacina());
            comando.setString(2, vacina.getNome());
            comando.setString(3, vacina.getLote());
            comando.setString(4, vacina.getTipo());
            comando.setString(5, vacina.getDuracao());
            comando.setString(6, vacina.getDescricao());
            comando.setFloat(7, vacina.getDose());
            comando.setString(8, vacina.getVia());
            comando.setString(9, vacina.getContraIndicacoes());
            comando.setString(10, vacina.getVencimento());
            comando.setFloat(11, vacina.getTemperatura());
            if (vacina.getFornecedor() == null) {
                comando.setNull(12, Types.INTEGER);
            } else {
                comando.setInt(12, vacina.getFornecedor().getCodFornecedor());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Vacina vacina) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from vacina where codVacina = " + vacina.getCodVacina();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Vacina vacina) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update vacina set "
                    + "nome = '" + vacina.getNome() + "', "
                    + "lote= '" + vacina.getLote() + "', "
                    + "tipo= '" + vacina.getTipo() + "', "
                    + "duracao = '" + vacina.getDuracao() + "', "
                    + "descricao = '" + vacina.getDescricao() + "', "
                    + "dose = " + vacina.getDose() + ", "
                    + "via = '" + vacina.getVia() + "', "
                    + "contraIndicacoes = '" + vacina.getContraIndicacoes() + "', "
                    + "vencimento = '" + vacina.getVencimento() + "', "
                    + "temperatura= " + vacina.getTemperatura() + ", "
                    + "Fornecedor_codFornecedor = ";
            if (vacina.getFornecedor() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + vacina.getFornecedor().getCodFornecedor();
            }
            stringSQL = stringSQL + " where codVacina = " + vacina.getCodVacina();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Vacina instanciarVacina(ResultSet rs) throws SQLException {
        Vacina vacina = new Vacina( rs.getInt("codVacina"),
                rs.getString("duracao"),
                rs.getString("descricao"),
                rs.getFloat("dose"),
                rs.getString("via"),
                rs.getString("contraIndicacoes"),
                rs.getFloat("temperatura"),
                rs.getString("nome"),
                rs.getString("lote"),
                rs.getString("tipo"),
                rs.getString("vencimento"),
                null);
        vacina.setCodFornecedor(rs.getInt("Fornecedor_codFornecedor"));
        return vacina;
    }
}
