package com.mycompany.foodweb.Model;

import java.util.Date;

public class Pedido {
    
    int idPedido;
    int idCliente;
    Restaurante restaurante;
    String data;
    String hora;
    int idStatusPedido;
    Double valorTotal;
    String codigo;

    public Pedido() {
    }

    public Pedido(int idPedido, int idCliente, Restaurante restaurante, String data, String hora, int idStatusPedido, Double valorTotal, String codigo) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.restaurante = restaurante;
        this.data = data;
        this.hora = hora;
        this.idStatusPedido = idStatusPedido;
        this.valorTotal = valorTotal;
        this.codigo = codigo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdStatusPedido() {
        return idStatusPedido;
    }

    public void setIdStatusPedido(int idStatusPedido) {
        this.idStatusPedido = idStatusPedido;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
