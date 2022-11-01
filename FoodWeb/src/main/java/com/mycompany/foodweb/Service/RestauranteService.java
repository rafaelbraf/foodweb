package com.mycompany.foodweb.Service;

import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Restaurante;
import java.io.IOException;
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
            
            System.out.println("rest email: " + restaurante.getEmail());
            System.out.println("rest email não é igual a '': " + !restaurante.getEmail().equals(""));
            
            if (restaurante.getEmail() != null && !restaurante.getEmail().equals("")) {
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                
                Gson gson = new Gson();
                String restauranteJson = gson.toJson(restaurante);
                System.out.println("restaurantejson: " + restauranteJson);

                HttpPost request = new HttpPost("http://localhost:3001/login-restaurante");
                request.setHeader("Content-Type", "application/json");

                HttpEntity entity = new ByteArrayEntity(restauranteJson.getBytes("UTF-8"));
                request.setEntity(entity);
                System.out.println("entity: " + request.getEntity());

                CloseableHttpResponse response = httpClient.execute(request);
                StatusLine statusLine = response.getStatusLine();                

                int statusCode = statusLine.getStatusCode();
                System.out.println("status code: " + statusCode);
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
                    JOptionPane.showMessageDialog(null, "Erro ao realizar login. Por favor, verifique seu email e senha e tente novamente.");
                }
            }
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar login. Entre em contato com nosso suporte.");
        }
        
        return restauranteLogado;
    }
    
}
