package com.mycompany.foodweb.Model;

public class Produto {
    
    int idProduto;
    String nome;
    String descricao;
    String categoria;
    String quantidade;
    String valorUnitario;
    String restaurante;

    public Produto() {
    }
    
    public Produto(int idProduto, String nome, String descricao, String categoria, String quantidade, String valorUnitario) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
    
    public Produto(String nome, String descricao, String categoria, String quantidade, String valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public Produto(String nome, String descricao, String categoria, String quantidade, String valorUnitario, String restaurante) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.restaurante = restaurante;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeProduto) {
        this.nome = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricaoProduto) {
        this.descricao = descricaoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }
    
}
