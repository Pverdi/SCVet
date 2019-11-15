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
import java.util.ArrayList;
import java.util.List;
import model.Especie;

/**
 *
 * @author lucsd
 */
public class EspecieDAO {

    public static Especie obterEspecie(int codEspecie) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Especie especie = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from especie where codEspecie = " + codEspecie);
            rs.first();
            especie = instanciarEspecie(rs);

        } finally {
            fecharConexao(conexao, comando);
        }
        return especie;
    }

    public static List<Especie> obterEspecies()
            throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Especie> especies = new ArrayList<Especie>();
        Especie especie = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from especie");
            while (rs.next()) {
                especie = instanciarEspecie(rs);
                especies.add(especie);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return especies;
    }

    public static void gravar(Especie especie) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement(
                    "insert into especie (codEspecie, nome)"
                    + " values (?,?)");
            comando.setInt(1, especie.getCodEspecie());
            comando.setString(2, especie.getNome());
            comando.executeUpdate();

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Especie especie) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from especie where codEspecie = " + especie.getCodEspecie();

            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Especie especie) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update especie set "
                    + "nome = '" + especie.getNome() + "'";

            stringSQL = stringSQL + " where codEspecie = " + especie.getCodEspecie();
            comando.execute(stringSQL);

        } finally {
            fecharConexao(conexao, comando);
        }
    }

    private static Especie instanciarEspecie(ResultSet rs) throws SQLException {
        Especie especie = new Especie(rs.getInt("codEspecie"),
                rs.getString("nome"));
        return especie;
    }
}
