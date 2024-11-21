package org.example.bo;

import org.example.dao.PessoaAdminDAO;
import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;

import java.sql.SQLException;

public class PessoaAdminBO {

    private final PessoaAdminDAO pessoaAdminDAO;

    public PessoaAdminBO() {
        this.pessoaAdminDAO = new PessoaAdminDAO();
    }

    // Verifica se o usuário é administrador
   // private boolean verificarPermissaoAdmin(String usuarioId) {
        // Simulação: Verifique no banco ou em um serviço externo se o usuário é admin
        // Aqui está apenas um exemplo simples de validação:
        //return usuarioId.equals("admin"); // Exemplo de ID de admin hardcoded
    //}

    // Atualizar Pessoa Física
    public PessoaFisica atualizarPessoaFisica(String usuarioId, PessoaFisica pessoaFisica) throws Exception {
        //if (!verificarPermissaoAdmin(usuarioId)) {
          //  throw new Exception("Permissão negada: Apenas administradores podem atualizar uma Pessoa Física.");
        //}
        try {
            return pessoaAdminDAO.atualizarPessoaPf(pessoaFisica);
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar Pessoa Física: " + e.getMessage(), e);
        }
    }

    // Atualizar Pessoa Jurídica
    public PessoaJuridica atualizarPessoaJuridica(String usuarioId, PessoaJuridica pessoaJuridica) throws Exception {
        ///if (!verificarPermissaoAdmin(usuarioId)) {
            //throw new Exception("Permissão negada: Apenas administradores podem atualizar uma Pessoa Jurídica.");
       // }
        try {
            return pessoaAdminDAO.atualizarPessoaPj(pessoaJuridica);
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar Pessoa Jurídica: " + e.getMessage(), e);
        }
    }

    // Deletar Pessoa Física
    public void deletarPessoaFisica(String usuarioId, String cpf) throws Exception {
       // if (!verificarPermissaoAdmin(usuarioId)) {
        //    throw new Exception("Permissão negada: Apenas administradores podem deletar uma Pessoa Física.");
        //}
        try {
            pessoaAdminDAO.deletarPessoaPf(cpf);
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar Pessoa Física: " + e.getMessage(), e);
        }
    }

    // Deletar Pessoa Jurídica
    public void deletarPessoaJuridica(String usuarioId, String cnpj) throws Exception {
        //if (!verificarPermissaoAdmin(usuarioId)) {
         //   throw new Exception("Permissão negada: Apenas administradores podem deletar uma Pessoa Jurídica.");
        //}
        try {
            pessoaAdminDAO.deletarPessoaPj(cnpj);
        } catch (SQLException e) {
            throw new Exception("Erro ao deletar Pessoa Jurídica: " + e.getMessage(), e);
        }
    }
}
