package com.mycompany.foodweb.Service;

import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Cliente;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.primefaces.shaded.json.JSONArray;

public class ClienteService {

    public Cliente pegaClientePorId(int idCliente) {
        
        try {
            
            String url = "http://localhost:3001/cliente/" + idCliente;
            System.out.println("url: " + url);
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao tentar obter dados da url: " + url);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }
            
            System.out.println("output: " + output);
            
            conn.disconnect();
            
            Gson gson = new Gson();
             
            Cliente[] cliente = gson.fromJson(output, Cliente[].class);
            
            return cliente[0];
            
        } catch(IOException e) {
            System.out.println("Erro ao buscar cliente.");
        }
        
        return null;
    }
    
}
