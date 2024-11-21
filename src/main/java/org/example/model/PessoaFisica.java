package org.example.model;

public class PessoaFisica {

    private int id;
    private String nomeEmpresa;
    private String cpf;
    private String email;

    private String senha;


    public PessoaFisica(){

    }

    public PessoaFisica(int id, String nomeEmpresa, String cpf, String senha, String email) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String validarCpf() {
        return cpf.length() == 11 ? "CPF válido" : "CPF inválido";
    }
}
