package com.mycompany.foodweb.Model;

public class Categoria {
    
    private Long id;
    private String nome;
    private Boolean ativo;
    private Restaurante restaurante;

    public Categoria() {
    }
    
    public Categoria(String nome, Boolean ativo, Restaurante restaurante) {
        this.nome = nome;
        this.restaurante = restaurante;
        this.ativo = ativo;
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
