package com.mycompany.foodweb.Service;

import Util.Constants;
import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Produto;
import com.mycompany.foodweb.Model.Restaurante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.primefaces.shaded.json.JSONObject;

public class RestauranteService {
    
    public Restaurante fazerLoginComEmailESenha(Restaurante restaurante) {
        
        Restaurante restauranteLogado = new Restaurante();
        
        try {            
            
            if (restaurante.getEmail() != null && !restaurante.getEmail().equals("")) {
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                
                Gson gson = new Gson();
                String restauranteJson = gson.toJson(restaurante);

                HttpPost request = new HttpPost("http://localhost:3001/login-restaurante");
                request.setHeader("Content-Type", "application/json");

                HttpEntity entity = new ByteArrayEntity(restauranteJson.getBytes("UTF-8"));
                request.setEntity(entity);

                CloseableHttpResponse response = httpClient.execute(request);
                StatusLine statusLine = response.getStatusLine();                

                int statusCode = statusLine.getStatusCode();
                if (statusCode == 200) {
                    String responseString = new BasicResponseHandler().handleResponse(response);
                    System.out.println("responsestring: " + responseString);
                    JSONObject jsonObject = new JSONObject(responseString);
                    
                    restauranteLogado.setId(jsonObject.getLong("id"));
                    restauranteLogado.setNome(jsonObject.getString("nome"));
                    restauranteLogado.setEmail(jsonObject.getString("email"));
                    restauranteLogado.setSenha(jsonObject.getString("senha"));
                    restauranteLogado.setCpfCnpj(jsonObject.getString("cpfCnpj"));
                    restauranteLogado.setTelefone(jsonObject.getString("telefone"));
                    
                } else {
                    restauranteLogado = null;
                    JOptionPane.showMessageDialog(null, "Erro ao realizar login. Por favor, verifique seu email e senha e tente novamente.");
                }
            }
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar login. Entre em contato com nosso suporte.");
        }
        
        return restauranteLogado;
    }
    
    public Restaurante consultarRestaurantePorId(Long idRestaurante) {
        
        try {
            
            String url = Constants.BASE_URL_RESTAURANTES + idRestaurante;
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao tentar obter os dados da url: " + url);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }
            
            conn.disconnect();
            
            Gson gson = new Gson();
            Restaurante restaurante = gson.fromJson(output, Restaurante.class);
            return restaurante;
            
        } catch (IOException exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
        
        return null;
        
    }
    
    public Produto[] listaProdutosDoRestaurante(Long idRestaurante) {
        
        try {
            
            String url = Constants.BASE_URL_RESTAURANTES + idRestaurante + "/produtos";
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao tentar obter os dados da url: " + url);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output = "";
            String line;
            while((line = br.readLine()) != null) {
                output += line;
            }
            System.out.println("Output: " + output);
            
            conn.disconnect();
            
            Gson gson = new Gson();
            Produto[] listaProdutos = gson.fromJson(output, Produto[].class);
            return listaProdutos;
            
        } catch(IOException exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
        
        return null;
        
    }
    
}
