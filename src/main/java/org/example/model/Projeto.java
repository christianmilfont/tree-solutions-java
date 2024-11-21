package org.example.model;

public class Projeto {

    private int id;
    private String nomeDoProjeto;
    private String descricao;
    private String regiao;
    private int custo;
    private String status;  // Adicionado o status

    public Projeto(int id, String nomeDoProjeto, String descricao, String regiao, int custo, String status) {
        this.id = id;
        this.nomeDoProjeto = nomeDoProjeto;
        this.descricao = descricao;
        this.regiao = regiao;
        this.custo = custo;
        this.status = status;
    }

    public Projeto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoProjeto() {
        return nomeDoProjeto;
    }

    public void setNomeDoProjeto(String nomeDoProjeto) {
        this.nomeDoProjeto = nomeDoProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
