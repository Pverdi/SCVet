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
import model.Raca;

/**
 *
 * @author lucsd
 */
public class RacaDAO {

    public static Raca obterRaca(int codRaca) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Raca raca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from raca where codRaca = " + codRaca);
            rs.first();
            raca = instanciarRaca(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return raca;
    }

    public static List<Raca> obterRacas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Raca> racas = new ArrayList<>();
        Raca raca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from raca");
            while (rs.next()) {
                raca = instanciarRaca(rs);
                racas.add(raca);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return racas;
    }

    public static void gravar(Raca raca) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into raca (codRaca, nome, porte, personalidade, Especie_codEspecie)"
                    + " values (?,?,?,?,?)");
            comando.setInt(1, raca.getCodRaca());
            comando.setString(2, raca.getNome());
            comando.setString(3, raca.getPorte());
            comando.setString(4, raca.getPersonalidade());
            if (raca.getEspecie() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, raca.getEspecie().getCodEspecie());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Raca raca) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from raca where codRaca = " 
                    + raca.getCodRaca();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Raca raca) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update raca set "
                    + "nome = '" + raca.getNome() + "', "
                    + "porte = '" + raca.getPorte() + "', "
                    + "personalidade = '" + raca.getPersonalidade() + "', "
                    + "Especie_codEspecie = ";
            if (raca.getEspecie() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + raca.getEspecie().getCodEspecie();
            }
            stringSQL = stringSQL + " where codRaca = " + raca.getCodRaca();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Raca instanciarRaca(ResultSet rs) throws SQLException, ClassNotFoundException {
        Raca raca = new Raca(rs.getInt("codRaca"),
                rs.getString("nome"),
                rs.getString("porte"),
                rs.getString("personalidade"),
                null);
        raca.setCodEspecie(rs.getInt("Especie_codEspecie"));
        return raca;
    }
}
