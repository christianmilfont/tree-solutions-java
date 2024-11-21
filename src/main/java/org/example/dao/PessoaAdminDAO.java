package org.example.dao;

import org.example.config.DatabaseConnection;
import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//VOU TRATAR OS METODOS DE ATUALIZAR E DELETAR JA QUE APENAS OS ADMINS PODEM FAZER ISSO, SEGUINDO NOSSA REGRA DE NEGOCIO!!!!
public class PessoaAdminDAO {
    private Connection connection;

    public PessoaAdminDAO()  {
        this.connection = DatabaseConnection.criarConexao();
    }

///// ATUALIZANDO PF E PJ
    public PessoaFisica atualizarPessoaPf(PessoaFisica pessoaFisica) throws SQLException{
        String sql = "UPDATE PessoaFisica SET nomeEmpresa = ?, email = ?, senha = ? WHERE cpf = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, pessoaFisica.getNomeEmpresa());
            stmt.setString(2, pessoaFisica.getEmail());
            stmt.setString(3, pessoaFisica.getSenha());
            stmt.setString(4, pessoaFisica.getCpf());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao tentar atualizar a pessoa fisica!");

        } return pessoaFisica;
    }

    public PessoaJuridica atualizarPessoaPj(PessoaJuridica pj) throws SQLException{
        String sql = "UPDATE PessoaJuridica SET nomeEmpresa = ?, email = ?, senha = ? WHERE cnpj = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, pj.getNomeEmpresa());
            stmt.setString(2, pj.getEmail());
            stmt.setString(3, pj.getSenha());
            stmt.setString(4, pj.getCnpj());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao tentar atualizar a pessoa fisica!" + e);

        } return pj;
    }



    // Deletar Pessoa Física
    public void deletarPessoaPf(String cpf) throws SQLException {
        String sql = "DELETE FROM PessoaFisica WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao deletar Pessoa Física: " + e);
            throw e;
        }

    }

    // Deletar Pessoa Jurídica
    public PessoaJuridica deletarPessoaPj(String cnpj) throws SQLException {
        String sql = "DELETE FROM PessoaJuridica WHERE cnpj = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao deletar Pessoa Jurídica: " + e.getMessage());
            throw e;

        }return null;
    }

}
