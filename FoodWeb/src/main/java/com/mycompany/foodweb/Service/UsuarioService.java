package com.mycompany.foodweb.Service;

import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Usuario;
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

public class UsuarioService {

    public int fazerLoginComEmailSenha(Usuario usuario) {
        
        int idRestaurante = 0;        
        
        try {
            
            if (usuario.getEmail() != null && !usuario.getEmail().equals("") && usuario.getSenha() != null && !usuario.getSenha().equals("")) {
                
                CloseableHttpClient httpClient = HttpClientBuilder.create().build();
                
                Gson gson = new Gson();
                String usuarioJson = gson.toJson(usuario);
                
                HttpPost request = new HttpPost("http://localhost:3001/auth/");
                request.setHeader("Content-Type", "application/json");
                
                HttpEntity entity = new ByteArrayEntity(usuarioJson.getBytes("UTF-8"));
                request.setEntity(entity);
                
                CloseableHttpResponse response = httpClient.execute(request);
                StatusLine statusLine = response.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                
                if (statusCode == 200) {
                    
                    String responseString = new BasicResponseHandler().handleResponse(response);                
                    JSONObject jsonObject = new JSONObject(responseString);
                    idRestaurante = jsonObject.getInt("Restaurante");
                    
                } else if (statusCode == 401) {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar login. Por favor, verifique seu email e senha e tente novamente.");
                }
                
            }
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar login. Entre em contato com nosso suporte.");
        }

        return idRestaurante;
        
    }
    
}
