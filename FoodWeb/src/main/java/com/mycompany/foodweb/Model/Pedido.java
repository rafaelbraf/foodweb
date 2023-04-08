package com.mycompany.foodweb.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    
    Long id;
    String dataHoraPedido;
    String statusPedido;
    Restaurante restaurante;

    public Pedido() {
    }

    public Pedido(String dataHoraPedido, String statusPedido, Restaurante restaurante) {
        this.dataHoraPedido = dataHoraPedido;
        this.statusPedido = statusPedido;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public String getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(String dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }    

    public String formataDataHoraPedido(String dataHoraPedido) {
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.ms");
        LocalDateTime dateTime = LocalDateTime.parse(dataHoraPedido, dtFormatter);
        return dateTime.toString();
    }
    
}