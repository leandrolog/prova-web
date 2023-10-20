package com.web.prova.entity;

public class Tarefa {

    private String status;
    private String nome;
    private Long codigo;

    public Tarefa(String status, String nome, Long codigo) {
        this.status = status;
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
