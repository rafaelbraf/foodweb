package com.mycompany.foodweb.Service;

import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Produto;

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
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProdutoService {
    
    public Produto pegaProdutoPorId(int idProduto) {
        
        try {
            
            String url = "http://localhost:3001/produtos/" + idProduto;
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");            
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro ao consultar produto.");
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));            
            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }
            
            System.out.println("Produto output: " + output);
            
            conn.disconnect();
            
            Gson gson = new Gson();            
            Produto produto = gson.fromJson(output, Produto.class);            
            
            return produto;
            
        } catch(IOException exception) {
            System.out.println("Erro ao consultar produto " + exception.getMessage());
        }
        
        return null;
        
    }
    
    public Produto[] listarTodosOsProdutos(Long idRestaurante) {
        
        try {
            
            String url = "http://localhost:3001/restaurante/" + idRestaurante + "/produtos";
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao tentar obter os dados da URL: " + url);
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
            //Produto produto = gson.fromJson( new String(output.getBytes()) , Produto.class);
            Produto[] arrayProdutos = gson.fromJson(output, Produto[].class);
            
            return arrayProdutos;
            
        } catch(IOException exception) {
            System.out.println("deu erro óh " + exception.getMessage() );
        }
        return null;
        
    }
    
    public int cadastrarProduto(Produto produto) {
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        int statusCode = 0;
        
        try {
            
            Gson gson = new Gson();            
            String produtoJson = gson.toJson(produto);
            
            HttpPost request = new HttpPost("http://localhost:3001/produtos");
            request.setHeader("Content-Type", "application/json");
            
            HttpEntity entity = new ByteArrayEntity(produtoJson.getBytes("UTF-8"));
            request.setEntity(entity);
            
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            statusCode = statusLine.getStatusCode();
            
        } catch(IOException e) {
            System.out.println("Deu erro ao tentar inserir novo produto: " + e.getMessage());
        } finally {
            try {
                httpClient.close();
            } catch (IOException ex) {
                Logger.getLogger(ProdutoService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return statusCode;
        
    }
    
    public int atualizaProdutoPorId(int idProduto, Produto produto) {
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        int statusCode = 0;
        
        try {
            
            Gson gson = new Gson();
            String produtoJson = gson.toJson(produto);
            
            HttpPut request = new HttpPut("http://localhost:3001/produtos/" + idProduto);
            request.setHeader("Content-Type", "application/json");
            
            HttpEntity entity = new ByteArrayEntity(produtoJson.getBytes("UTF-8"));
            request.setEntity(entity);
            
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            statusCode = statusLine.getStatusCode();
            return statusCode;
            
        } catch (IOException e) {
            System.out.println("Erro ao editar produto.");
        }
        
        return statusCode;
    }
    
    public void excluirProduto(int idProduto) {
        
        try {
            
            String url = "http://localhost:3001/produto/" + idProduto;
            
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao tentar obter dados da URL " + url);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            String output = "";
            String line;
            while((line = br.readLine()) != null) {
                output += line;
            }
            
            System.out.println(output);
            
            conn.disconnect();
            
        } catch(IOException e) {
            System.out.println("Deu erro " + e.getMessage());
        }
        
    }
    
    
    
}
