package org.example.dao;

import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;
import org.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO()  {
        this.connection = DatabaseConnection.criarConexao();
    }

    public PessoaFisica buscarPfPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM PessoaFisica WHERE cpf = ?";
        PessoaFisica pf = new PessoaFisica();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pf.setCpf(cpf);
                pf.setNomeEmpresa(rs.getString("nomeEmpresa"));
                pf.setEmail(rs.getString("Email"));
                pf.setSenha(rs.getString("Senha"));
                pf.setId(rs.getInt("Id"));
            }return pf;
        }
    }
    public PessoaJuridica buscarPjPorCnpj(String cnpj) throws SQLException {
        String sql = "SELECT * FROM PessoaJuridica WHERE cnpj = ?";
        PessoaJuridica pj = new PessoaJuridica();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pj.setCnpj(cnpj);
                pj.setNomeEmpresa(rs.getString("nomeEmpresa"));
                pj.setEmail(rs.getString("Email"));
                pj.setSenha(rs.getString("Senha"));
                pj.setId(rs.getInt("Id"));
            }return pj;
        }
    }
    public PessoaJuridica buscarPjPorId(int id) throws SQLException{
        String sql =  "SELECT * FROM PessoaJuridica WHERE id = ?";
        PessoaJuridica pj = new PessoaJuridica();
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                pj.setCnpj(rs.getString("cnpj"));
                pj.setNomeEmpresa(rs.getString("nomeEmpresa"));
                pj.setEmail(rs.getString("Email"));
                pj.setSenha(rs.getString("Senha"));
                pj.setId(id);
            }return pj;
        }
    }
    public PessoaFisica buscarPfPorId(int id) throws SQLException {
        String sql = "SELECT * FROM PessoaFisica WHERE id = ?";
        PessoaFisica pf = new PessoaFisica();
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery(); // buscar dados no BD
            while(rs.next()){
                pf.setCpf(rs.getString("cpf"));
                pf.setNomeEmpresa(rs.getString("nomeEmpresa"));
                pf.setEmail(rs.getString("Email"));
                pf.setSenha(rs.getString("Senha"));
                pf.setId(id);
            }return pf;
        }
    }

    public boolean criarPessoaPf(PessoaFisica pf) throws SQLException {
        String sql = "INSERT INTO PessoaFisica (cpf, nomeEmpresa, email, senha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pf.getCpf());
            stmt.setString(2, pf.getNomeEmpresa());
            stmt.setString(3, pf.getEmail());
            stmt.setString(4, pf.getSenha());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Pessoa Física: " + e.getMessage());
            throw e;
        }
    }

    public boolean criarPessoaPj(PessoaJuridica pj) throws SQLException {
        String sql = "INSERT INTO PessoaJuridica (cnpj, nomeEmpresa, email, senha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pj.getCnpj());
            stmt.setString(2, pj.getNomeEmpresa());
            stmt.setString(3, pj.getEmail());
            stmt.setString(4, pj.getSenha());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Pessoa Jurídica: " + e.getMessage());
            throw e;
        }
    }
}




