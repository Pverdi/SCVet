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
import model.Prontuario;

/**
 *
 * @author lucsd
 */
public class ProntuarioDAO {

    public static Prontuario obterPronturario(int codProntuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Prontuario prontuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from prontuario where codProntuario = " + codProntuario);
            rs.first();
            prontuario = instanciarProntuario(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return prontuario;
    }

    public static List<Prontuario> obterProntuarios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Prontuario> prontuarios = new ArrayList<Prontuario>();
        Prontuario prontuario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from prontuario");
            while (rs.next()) {
                prontuario = instanciarProntuario(rs);
                prontuarios.add(prontuario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return prontuarios;
    }

    public static void gravar(Prontuario prontuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into prontuario (codProntuario, data, hora, descricao, Animal_codAnimal, Vacina_codVacina, Procedimento_codProcedimento)"
                    + " values (?,?,?,?,?,?,?)");
            comando.setInt(1, prontuario.getCodProntuario());
            comando.setString(2, prontuario.getData());
            comando.setInt(3, prontuario.getHora());
            comando.setString(4, prontuario.getDescricao());
            if (prontuario.getAnimal() == null) {
                comando.setNull(5, Types.INTEGER);
            } else {
                comando.setInt(5, prontuario.getAnimal().getCodAnimal());
            }
            if (prontuario.getVacina() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, prontuario.getVacina().getCodVacina());
            }
            if (prontuario.getProcedimento() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, prontuario.getProcedimento().getCodProcedimento());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Prontuario prontuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from prontuario where codProntuario = " + prontuario.getCodProntuario();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
        public static void alterar(Prontuario prontuario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update prontuario set "
                    + "data = '" + prontuario.getData() + "', "
                    + "hora = '" + prontuario.getHora() + "', "
                    + "descricao = '" + prontuario.getDescricao() + "'";
            stringSQL = stringSQL + ", Animal_codAnimal = ";
            if (prontuario.getAnimal() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + prontuario.getAnimal().getCodAnimal();
            }
            stringSQL = stringSQL + ", Vacina_codVacina = ";
            if (prontuario.getVacina() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + prontuario.getVacina().getCodVacina();
            }
            stringSQL = stringSQL + ", Procedimento_codProcedimento = ";
            if (prontuario.getProcedimento() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + prontuario.getProcedimento().getCodProcedimento();
            }
            stringSQL = stringSQL + " where codProntuario= " + prontuario.getCodProntuario();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Prontuario instanciarProntuario(ResultSet rs) throws SQLException, ClassNotFoundException {
        Prontuario prontuario = new Prontuario(rs.getInt("codProntuario"),
                rs.getString("data"),
                rs.getInt("hora"),
                rs.getString("descricao"),
                null,
                null,
                null);
        prontuario.setCodAnimal(rs.getInt("Animal_codAnimal"));
        prontuario.setCodVacina(rs.getInt("Vacina_codVacina"));
        prontuario.setCodProcedimento(rs.getInt("Procedimento_codProcedimento"));
        return prontuario;
    }

    public static Prontuario obterProntuario(int codProntuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
