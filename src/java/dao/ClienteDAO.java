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
import model.Cliente;

/**
 *
 * @author lucsd
 */
public class ClienteDAO {

    public static Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente where codCliente = " + codCliente);
            rs.first();
            cliente = instanciarCliente(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return cliente;
    }

    public static List<Cliente> obterClientes()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cliente");
            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return clientes;
    }

    public static void gravar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into cliente (codCliente, cpf, rg, "
                    + "nome, numeroEndereco, email, "
                    + "complementoEndereco, telefone, cep, cidade, estado, bairro, logradouro)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, cliente.getCodCliente());
            comando.setString(2, cliente.getCpf());
            comando.setString(3, cliente.getRg());
            comando.setString(4, cliente.getNome());
            comando.setInt(5, cliente.getNumeroEndereco());
            comando.setString(6, cliente.getEmail());
            comando.setString(7, cliente.getComplementoEndereco());
            comando.setString(8, cliente.getTelefone());
            comando.setInt(9, cliente.getCep());
            comando.setString(10, cliente.getCidade());
            comando.setString(11, cliente.getEstado());
            comando.setString(12, cliente.getBairro());
            comando.setString(13, cliente.getLogradouro());

            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Cliente instanciarCliente(ResultSet rs) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente(rs.getInt("codCliente"),
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
        return cliente;
    }

    public static void excluir(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from cliente where codCliente = " + cliente.getCodCliente();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update cliente set "
                    + "cpf = '" + cliente.getCpf() + "', "
                    + "rg = '" + cliente.getRg() + "', "
                    + "nome = '" + cliente.getNome() + "', "
                    + "numeroEndereco = " + cliente.getNumeroEndereco() + ", "
                    + "email = '" + cliente.getEmail() + "', "
                    + "complementoEndereco = '" + cliente.getComplementoEndereco() + "', "
                    + "telefone = '" + cliente.getTelefone() + "', "
                    + "cep = " + cliente.getCep() + ", "
                    + "cidade = '" + cliente.getCidade() + "', "
                    + "estado = '" + cliente.getEstado() + "', "
                    + "bairro = '" + cliente.getBairro() + "', "
                    + "logradouro = '" + cliente.getLogradouro() + "'";

            stringSQL = stringSQL + " where codCliente = " + cliente.getCodCliente();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
