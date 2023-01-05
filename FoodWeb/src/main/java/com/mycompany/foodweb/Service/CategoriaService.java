package com.mycompany.foodweb.Service;

import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Categoria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class CategoriaService {
    
    public Categoria[] pegaCategoriasDoRestaurante(Long idRestaurante) {
        
        try {
            
            String url = "http://localhost:3001/categorias/restaurante/" + idRestaurante;
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseMessage() + " ao tentar obter dados da URL: " + url);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }
            
            System.out.println(output);
            
            conn.disconnect();
            
            Gson gson = new Gson();
            Categoria[] listaDeCategorias = gson.fromJson(output, Categoria[].class);
            return listaDeCategorias;
            
        } catch (IOException exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
        
        return null;
        
    }
    
    public int adicionarNovaCategoria(Categoria categoria) {
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        
        int statusCode = 0;
        
        try {
            
            Gson gson = new Gson();
            String categoriaJson = gson.toJson(categoria);
            
            HttpPost request = new HttpPost("http://localhost:3001/categorias");
            request.setHeader("Content-Type", "application/json");
            
            HttpEntity entity = new ByteArrayEntity(categoriaJson.getBytes("UTF-8"));
            request.setEntity(entity);
            
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            statusCode = statusLine.getStatusCode();
            
        } catch (IOException e) {
            System.out.println("Erro ao tentar cadastrar nova categoria: " + e.getMessage());
        } finally {
            try {
                httpClient.close();                
            } catch (IOException ex) {
                Logger.getLogger(CategoriaService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return statusCode;
        
    }
    
}
