package com.mycompany.foodweb.Service;

import Util.Constants;
import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Pedido;
import com.mycompany.foodweb.Model.Service;

public class PedidoService {
    
    public Pedido[] listarTodosOsPedidos(Long idRestaurante) {
        String url = Constants.BASE_URL_RESTAURANTES + idRestaurante + "/pedidos";
        String output = new Service().getRequest(url);
        Pedido[] listaDePedidos = new Gson().fromJson(output, Pedido[].class);
        return listaDePedidos;
    }
    
}
