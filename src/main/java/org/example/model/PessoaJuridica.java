package org.example.model;

public class PessoaJuridica {

    private int id;
    private String nomeEmpresa;
    private String cnpj;
    private String email;
    private String senha;

    public PessoaJuridica(int id, String razaoSocial, String cnpj) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
    }

    public PessoaJuridica() {

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String validarCnpj() {
        return cnpj.length() == 14 ? "CNPJ válido" : "CNPJ inválido";
    }
}
