/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Animal;

/**
 *
 * @author lucsd
 */
public class AnimalDAO {

    public static Animal obterAnimal(int codAnimal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Animal animal = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from animal where codAnimal = " + codAnimal);
            rs.first();
            animal = instanciarAnimal(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return animal;
    }

    public static List<Animal> obterAnimais()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Animal> animais = new ArrayList<Animal>();
        Animal animal = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from animal");
            while (rs.next()) {
                animal = instanciarAnimal(rs);
                animais.add(animal);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return animais;
    }

    public static void gravar(Animal animal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into animal (codAnimal, nome, peso, dtNascimento, "
                    + "tipoSanguineo, Raca_codRaca, Cliente_codCliente)"
                    + " values (?,?,?,?,?,?,?)");
            comando.setInt(1, animal.getCodAnimal());
            comando.setString(2, animal.getNome());
            comando.setFloat(3, animal.getPeso());
            comando.setString(4, animal.getDtNascimento());
            comando.setString(5, animal.getTipoSanguineo());
            if (animal.getRaca() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, animal.getRaca().getCodRaca());
            }
            if (animal.getDono() == null) {
                comando.setNull(7, Types.INTEGER);
            } else {
                comando.setInt(7, animal.getDono().getCodCliente());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Animal animal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from animal where codAnimal = " 
                    + animal.getCodAnimal();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Animal animal) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update animal set "
                    + "nome = '" + animal.getNome() + "', "
                    + "peso = " + animal.getPeso() + ", "
                    + "dtNascimento = '" + animal.getDtNascimento() + "', "
                    + "tipoSanguineo = '" + animal.getTipoSanguineo() + "', "
                    + "Raca_codRaca = ";
            if (animal.getRaca() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + animal.getRaca().getCodRaca();
            }
            stringSQL = stringSQL + ", Cliente_codCliente = ";
            if (animal.getDono() == null) {
                stringSQL = stringSQL + null;
            } else {
                stringSQL = stringSQL + animal.getDono().getCodCliente();
            }
            stringSQL = stringSQL + " where codAnimal = " + animal.getCodAnimal();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Animal instanciarAnimal(ResultSet rs) throws SQLException, ClassNotFoundException {
        Animal animal = new Animal(rs.getInt("codAnimal"),
                rs.getString("nome"),
                rs.getFloat("peso"),
                rs.getString("dtNascimento"),
                rs.getString("tipoSanguineo"),
                null,
                null);
        animal.setCodRaca(rs.getInt("Raca_codRaca"));
        animal.setCodCliente(rs.getInt("Cliente_codCliente"));
        return animal;
    }
}
