package com.mycompany.foodweb.Model;

import java.util.List;

public class Produto {
    
    int id;
    String nome;
    String descricao;
    Double preco;
    Double quantidade;
    String imgUrl;    
    Restaurante restaurante;
    List<Categoria> categorias;

    public Produto() {
    }

    public Produto(String nome, String descricao, Double preco, Double quantidade, String imgUrl, Restaurante restaurante, List<Categoria> categorias) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imgUrl = imgUrl;
        this.restaurante = restaurante;
        this.categorias = categorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public String categoriasToString() {
        String categoriasEmString = "";
        for (int i = 0; i < categorias.size(); i++) {
            if (i != categorias.size() - 1) {
                categoriasEmString += categorias.get(i).getNome() + ", ";
            } else {
                categoriasEmString += categorias.get(i).getNome();
            }
        }
        return categoriasEmString;
    }
    
}
