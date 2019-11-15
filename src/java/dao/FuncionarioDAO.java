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
import model.Funcionario;

/**
 *
 * @author lucsd
 */
public class FuncionarioDAO {

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario where codFuncionario = " + codFuncionario);
            rs.first();
            funcionario = instanciarFuncionario(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    public static List<Funcionario> obterFuncionarios()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from funcionario");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static void gravar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into funcionario (codFuncionario, cargo, turno, "
                    + "especializacao, dtAdmissao, cpf, rg, "
                    + "nome, numeroEndereco, email, "
                    + "complementoEndereco, telefone, cep, cidade, estado, bairro, logradouro)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getCodFuncionario());
            comando.setString(2, funcionario.getCargo());
            comando.setString(3, funcionario.getTurno());
            comando.setString(4, funcionario.getEspecializacao());
            comando.setString(5, funcionario.getDtAdmissao());
            comando.setString(6, funcionario.getCpf());
            comando.setString(7, funcionario.getRg());
            comando.setString(8, funcionario.getNome());
            comando.setInt(9, funcionario.getNumeroEndereco());
            comando.setString(10, funcionario.getEmail());
            comando.setString(11, funcionario.getComplementoEndereco());
            comando.setString(12, funcionario.getTelefone());
            comando.setInt(13, funcionario.getCep());
            comando.setString(14, funcionario.getCidade());
            comando.setString(15, funcionario.getEstado());
            comando.setString(16, funcionario.getBairro());
            comando.setString(17, funcionario.getLogradouro());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from funcionario where codFuncionario = " + funcionario.getCodFuncionario();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update funcionario set "
                    + "cargo = '" + funcionario.getCargo() + "', "
                    + "turno = '" + funcionario.getTurno() + "', "
                    + "especializacao = '" + funcionario.getEspecializacao() + "', "
                    + "dtAdmissao = '" + funcionario.getDtAdmissao() + "', "
                    + "cpf = '" + funcionario.getCpf() + "', "
                    + "rg = '" + funcionario.getRg() + "', "
                    + "nome = '" + funcionario.getNome() + "', "
                    + "numeroEndereco = '" + funcionario.getNumeroEndereco() + "', "
                    + "email = '" + funcionario.getEmail() + "', "
                    + "complementoEndereco = '" + funcionario.getComplementoEndereco() + "', "
                    + "telefone = '" + funcionario.getTelefone() + "', "
                    + "cep = '" + funcionario.getCep() + "', "
                    + "cidade = '" + funcionario.getCidade() + "', "
                    + "estado = '" + funcionario.getEstado() + "', "
                    + "bairro = '" + funcionario.getBairro() + "', "
                    + "logradouro = '" + funcionario.getLogradouro() + "' ";

            stringSQL = stringSQL + " where codFuncionario = " + funcionario.getCodFuncionario();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario(rs.getInt("codFuncionario"),
                rs.getString("cargo"),
                rs.getString("turno"),
                rs.getString("especializacao"),
                rs.getString("dtAdmissao"),
                rs.getString("cpf"),
                rs.getString("rg"),
                rs.getString("nome"),
                rs.getInt("numeroEndereco"),
                rs.getString("email"),
                rs.getString("complementoEndereco"),
                rs.getString("telefone"),
                rs.getInt("cep"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("bairro"),
                rs.getString("logradouro"));
        return funcionario;
    }
}
