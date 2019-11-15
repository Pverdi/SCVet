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
import model.Agenda;

/**
 *
 * @author lucsd
 */
public class AgendaDAO {

    public static Agenda obterAgenda(int codAgenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Agenda agenda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from agenda where codAgenda = " + codAgenda);
            rs.first();
            agenda = instanciarAgenda(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return agenda;
    }

    public static List<Agenda> obterAgendas()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Agenda> agendas = new ArrayList<Agenda>();
        Agenda agenda = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from agenda");
            while (rs.next()) {
                agenda = instanciarAgenda(rs);
                agendas.add(agenda);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return agendas;
    }

    public static void gravar(Agenda agenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into agenda (codAgenda, data, hora, numeroSala, tipoAtendimento, Cliente_codCliente, Animal_codAnimal, Funcionario_codFuncionario)"
                    + " values (?,?,?,?,?,?,?,?)");
            comando.setInt(1, agenda.getCodAgenda());
            comando.setString(2, agenda.getData());
            comando.setInt(3, agenda.getHora());
            comando.setInt(4, agenda.getNumeroSala());
            comando.setString(5, agenda.getTipoAtendimento());
            if (agenda.getCliente() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, agenda.getCliente().getCodCliente());
            }
            if (agenda.getAnimal() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, agenda.getAnimal().getCodAnimal());
            }
            if (agenda.getVeterinario() == null) {
                comando.setNull(8, Types.INTEGER);
            } else {
                comando.setInt(8, agenda.getVeterinario().getCodFuncionario());
            }
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Agenda agenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from agenda where codAgenda = " + agenda.getCodAgenda();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Agenda agenda) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update agenda set "
                    + "data = '" + agenda.getData() + "', "
                    + "hora = '" + agenda.getHora() + "', "
                    + "numeroSala = '" + agenda.getNumeroSala() + "', "
                    + "tipoAtendimento = '" + agenda.getTipoAtendimento() + "', "
                    + "Cliente_codCliente = ";
            if (agenda.getCliente() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + agenda.getCliente().getCodCliente();
            }
            stringSQL = stringSQL + ", Animal_codAnimal = ";
            if (agenda.getAnimal() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + agenda.getAnimal().getCodAnimal();
            }
            stringSQL = stringSQL + ", Funcionario_codFuncionario = ";
            if (agenda.getVeterinario() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + agenda.getVeterinario().getCodFuncionario();
            }
            stringSQL = stringSQL + " where codAgenda= " + agenda.getCodAgenda();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Agenda instanciarAgenda(ResultSet rs) throws SQLException, ClassNotFoundException {
        Agenda agenda = new Agenda(rs.getInt("codAgenda"),
                rs.getString("data"),
                rs.getInt("hora"),
                rs.getInt("numeroSala"),
                rs.getString("tipoAtendimento"),
                null,
                null,
                null);
        agenda.setCodCliente(rs.getInt("Cliente_codCliente"));
        agenda.setCodAnimal(rs.getInt("Animal_codAnimal"));
        agenda.setCodFuncionario(rs.getInt("Funcionario_codFuncionario"));
        return agenda;
    }
}
