package com.mycompany.foodweb.Service;

import Util.Constants;
import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Categoria;
import com.mycompany.foodweb.Model.Produto;
import com.mycompany.foodweb.Model.Restaurante;
import com.mycompany.foodweb.Model.Service;
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
import org.json.JSONObject;

public class RestauranteService {
    
    public Restaurante fazerLoginComEmailESenha(Restaurante restaurante) {
        
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

                Boolean restauranteLogadoComSucesso = statusLine.getStatusCode() == 200;
                if (restauranteLogadoComSucesso) {
                    String responseString = new BasicResponseHandler().handleResponse(response);
                    System.out.println("responsestring: " + responseString);
                    JSONObject jsonObject = new JSONObject(responseString);
                    
                    Restaurante restauranteLogado = new Restaurante();                    
                    restauranteLogado.setId(jsonObject.getLong("id"));
                    restauranteLogado.setNome(jsonObject.getString("nome"));
                    restauranteLogado.setEmail(jsonObject.getString("email"));
                    restauranteLogado.setSenha(jsonObject.getString("senha"));
                    restauranteLogado.setCpfCnpj(jsonObject.getString("cpfCnpj"));
                    restauranteLogado.setTelefone(jsonObject.getString("telefone"));
                    
                    return restauranteLogado;
                    
                } else {                    
                    JOptionPane.showMessageDialog(null, "Erro ao realizar login. Por favor, verifique seu email e senha e tente novamente.");
                }
            }
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Erro: " + e.getLocalizedMessage() + ".\nCaso o problema persista entre em contato com nosso suporte.",
                    "Erro ao fazer login",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        
        return null;
    }
    
    public Restaurante consultarRestaurantePorId(Long idRestaurante) {
        String url = Constants.BASE_URL_RESTAURANTES + idRestaurante;
        String output = new Service().getRequest(url);
        Restaurante restaurante = new Gson().fromJson(output, Restaurante.class);
        return restaurante;
    }
    
    public Produto[] listaProdutosDoRestaurante(Long idRestaurante) {
        String url = Constants.BASE_URL_RESTAURANTES + idRestaurante + "/produtos";
        String output = new Service().getRequest(url);
        Produto[] arrayProdutos = new Gson().fromJson(output, Produto[].class);
        return arrayProdutos;
    }
    
    public Produto[] listaProdutosDoRestaurantePorNome(Long idRestaurante, String nome) {
        String url = Constants.BASE_URL_RESTAURANTES + idRestaurante + "/produtos/query=" + nome;
        String output = new Service().getRequest(url);
        Produto[] arrayProdutos = new Gson().fromJson(output, Produto[].class);
        return arrayProdutos;
    }
    
    public Categoria[] listaCategoriasDoRestaurante(Long idRestaurante) {
        String url = Constants.BASE_URL_CATEGORIAS + "restaurante/" + idRestaurante;
        String output = new Service().getRequest(url);
        Categoria[] arrayCategorias = new Gson().fromJson(output, Categoria[].class);
        return arrayCategorias;
    }
    
}
