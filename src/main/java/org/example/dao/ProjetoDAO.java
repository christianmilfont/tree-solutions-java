package org.example.dao;

import org.example.model.Projeto;
import org.example.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjetoDAO {

    private static Connection connection;

    public ProjetoDAO() throws SQLException {
        connection = DatabaseConnection.criarConexao();
    }

    public  boolean criarProjeto(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO Projeto (nomeDoProjeto, descricao, regiao, custo, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNomeDoProjeto());
            stmt.setString(2, projeto.getDescricao());
            stmt.setString(3, projeto.getRegiao());
            stmt.setInt(4, projeto.getCusto());
            stmt.setString(5, projeto.getStatus());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public static Projeto buscarProjetoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Projeto WHERE id = ?";
        Projeto p = new Projeto();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                p.setNomeDoProjeto(rs.getString("NomeDoProjeto"));
                p.setDescricao(rs.getString("descricao"));
                p.setCusto(rs.getInt("custo"));
                p.setRegiao(rs.getString("regiao"));
                p.setStatus(rs.getString("Status"));
                p.setId(id);
            }return p;
        }
        }

    }

