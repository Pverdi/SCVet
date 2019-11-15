package model;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public abstract class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(String cnpj, String nome, int numeroEndereco, String email,
            String complementoEndereco, String telefone ,int cep, String cidade, String estado, String bairro, String logradouro) {
        super(nome, numeroEndereco, email, complementoEndereco, telefone, cep, cidade, estado, bairro, logradouro);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
