package model;

import dao.FornecedorDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Fornecedor extends PessoaJuridica {

    private int codFornecedor;
    private String nomeContato;
    private String nomeEmpresa;

    public Fornecedor(int codFornecedor, String nomeContato, String nome,
            String cnpj, int numeroEndereco, String email, 
            String complementoEndereco, String telefone, int cep, String cidade,
            String estado, String bairro, String logradouro) {
        super(cnpj, nome, numeroEndereco, email, complementoEndereco, telefone,
                cep, cidade, estado, bairro, logradouro);
        this.codFornecedor = codFornecedor;
        this.nomeContato = nomeContato;
        this.nomeEmpresa = nome;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public static Fornecedor obterFornecedor(int codFornecedor) throws ClassNotFoundException, SQLException {
        return FornecedorDAO.obterFornecedor(codFornecedor);
    }

    public static List<Fornecedor> obterFornecedores() throws ClassNotFoundException, SQLException {
        return FornecedorDAO.obterFornecedores();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        FornecedorDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        FornecedorDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        FornecedorDAO.alterar(this);
    }
}
