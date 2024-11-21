package org.example.bo;
import org.example.dao.PessoaDAO;
import org.example.model.PessoaFisica;
import org.example.model.PessoaJuridica;

import java.sql.SQLException;

public class PessoaBO {
    PessoaDAO pd = new PessoaDAO();

public PessoaFisica buscarFisicoPorId(int id){
    try{
        return pd.buscarPfPorId(id);
    }catch(SQLException e){
        System.out.println("Erro ao buscar no Banco de Dados: "+ e);
        return null;
    }
}
public PessoaJuridica buscarJuridicoPorId(int id){
    try{
        return pd.buscarPjPorId(id);
    }catch (SQLException e){
        System.out.println("Erro ao buscar no Banco de Dados: "+ e);
        return null;
    }
}
public PessoaFisica buscarFisicoPorCpf(String cpf){
    try{
        return pd.buscarPfPorCpf(cpf);
    }catch (SQLException e){
        System.out.println("Erro ao buscar cpf no Banco de Dados");
        return null;
    }
}

public PessoaJuridica buscarJuridicaPorCnpj(String cnpj){
    try{
        return pd.buscarPjPorCnpj(cnpj);
    }catch (SQLException e){
        System.out.println("Erro ao buscar cpf no Banco de Dados");
        return null;
    }
}


    // Método para criar Pessoa Física
    public boolean criarPessoaFisica(PessoaFisica pf) {
        try {
            return pd.criarPessoaPf(pf);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Pessoa Física no Banco de Dados: " + e);
            return false;
        }
    }

    // Método para criar Pessoa Jurídica
    public boolean criarPessoaJuridica(PessoaJuridica pj) {
        try {
            return pd.criarPessoaPj(pj);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Pessoa Jurídica no Banco de Dados: " + e);
            return false;
        }
    }
}

