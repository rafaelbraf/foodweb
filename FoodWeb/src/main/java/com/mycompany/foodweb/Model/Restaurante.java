package com.mycompany.foodweb.Model;

public class Restaurante {
    
    Long id;
    String cpfCnpj;
    String nome;
    String email;
    String senha;
    String endereco;    
    String telefone;

    public Restaurante() {
    }

    public Restaurante(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Restaurante(Long id, String cpfCnpj, String nome, String email, String senha, String endereco, String telefone) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
