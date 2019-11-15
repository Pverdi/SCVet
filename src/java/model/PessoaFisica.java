package model;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public abstract class PessoaFisica extends Pessoa {

    private String cpf;
    private String rg;

    public PessoaFisica(String cpf, String rg, String nome, int numeroEndereco, String email,
            String complementoEndereco, String telefone, int cep, String cidade, String estado, String bairro, String logradouro) {
        super(nome, numeroEndereco, email, complementoEndereco, telefone, cep, cidade, estado, bairro, logradouro);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
