package com.mycompany.foodweb.Service;

import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Pedido;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PedidoService {
    
    public Pedido[] listarTodosOsPedidos(Long idRestaurante) {
        
        try {
            
            String url = "http://localhost:3001/restaurantes/" + idRestaurante + "/pedidos";
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao tentar obter dados da url: " + url);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String output = "";
            String line;
            while((line = br.readLine()) != null) {
                output += line;
            }
            System.out.println(output);
            
            conn.disconnect();
            
            Gson gson = new Gson();
            Pedido[] arrayPedidos = gson.fromJson(output, Pedido[].class);
            
            return arrayPedidos;
            
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
