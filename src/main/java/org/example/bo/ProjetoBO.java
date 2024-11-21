package org.example.bo;

import org.example.dao.ProjetoDAO;
import org.example.model.Projeto;

import java.sql.SQLException;

public class ProjetoBO {

    private final ProjetoDAO projetoDAO;

    public ProjetoBO() throws SQLException {
        this.projetoDAO = new ProjetoDAO();
    }

    // Criar projeto com validações de negócios
    public boolean criarProjeto(Projeto projeto) throws Exception {
        if (projeto == null) {
            throw new IllegalArgumentException("O projeto não pode ser nulo.");
        }
        if (projeto.getNomeDoProjeto() == null || projeto.getNomeDoProjeto().isEmpty()) {
            throw new IllegalArgumentException("O nome do projeto é obrigatório.");
        }
        if (projeto.getCusto() <= 0) {
            throw new IllegalArgumentException("O custo do projeto deve ser maior que zero.");
        }
        if (projeto.getRegiao() == null || projeto.getRegiao().isEmpty()) {
            throw new IllegalArgumentException("A região é obrigatória.");
        }
        if (projeto.getStatus() == null || projeto.getStatus().isEmpty()) {
            throw new IllegalArgumentException("O status do projeto é obrigatório.");
        }

        return projetoDAO.criarProjeto(projeto);
    }

    // Buscar projeto por ID com validação
    public Projeto buscarProjetoPorId(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("O ID do projeto deve ser maior que zero.");
        }

        Projeto projeto = ProjetoDAO.buscarProjetoPorId(id);
        if (projeto == null) {
            throw new Exception("Projeto não encontrado com o ID fornecido.");
        }

        return projeto;
    }
}
