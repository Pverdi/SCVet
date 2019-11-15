package model;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Cliente extends PessoaFisica {

    private int codCliente;

    public Cliente(int codCliente, String cpf, String rg, String nome,
            int numeroEndereco, String email, String complementoEndereco, String telefone,
            int cep, String cidade, String estado, String bairro, String logradouro) {
        super(cpf, rg, nome, numeroEndereco, email, complementoEndereco, telefone,
                cep, cidade, estado, bairro, logradouro);
        this.codCliente = codCliente;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public static Cliente obterCliente(int codCliente) throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterCliente(codCliente);
    }

    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.obterClientes();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        ClienteDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        ClienteDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        ClienteDAO.alterar(this);
    }

}
