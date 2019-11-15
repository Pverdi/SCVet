package model;

import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Funcionario extends PessoaFisica {

    private int codFuncionario;
    private String cargo;
    private String turno;
    private String especializacao;
    private String dtAdmissao;

    public Funcionario(int codFuncionario, String cargo, String turno, String especializacao, String dtAdmissao,
            String cpf, String rg, String nome, int numeroEndereco, String email,
            String complementoEndereco, String telefone, int cep, String cidade,
            String estado, String bairro, String logradouro) {

        super(cpf, rg, nome, numeroEndereco, email, complementoEndereco, telefone,
                cep, cidade, estado, bairro, logradouro);
        this.codFuncionario = codFuncionario;
        this.cargo = cargo;
        this.turno = turno;
        this.especializacao = especializacao;
        this.dtAdmissao = dtAdmissao;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(String dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public static Funcionario obterFuncionario(int codFuncionario) throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionario(codFuncionario);
    }

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        return FuncionarioDAO.obterFuncionarios();
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        FuncionarioDAO.gravar(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException {
        FuncionarioDAO.excluir(this);
    }
    
    public void alterar() throws ClassNotFoundException, SQLException {
        FuncionarioDAO.alterar(this);
    }
}
