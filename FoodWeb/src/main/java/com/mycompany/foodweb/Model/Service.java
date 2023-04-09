package com.mycompany.foodweb.Model;

import com.google.gson.Gson;
import com.mycompany.foodweb.Service.ProdutoService;
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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Service {
    
    String url;
    String method;

    public Service() {
    }

    public Service(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public String getRequest(String url) {
        String output = "";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            
            if (httpURLConnection.getResponseCode() != 200) {
                System.out.println("Erro " + httpURLConnection.getResponseMessage() + " ao tentar obter dados da URL: " + url);
            }
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            
            String line;
            while((line = bufferedReader.readLine()) != null) {
                output += line;
            }
            
            httpURLConnection.disconnect();
                        
        } catch (IOException e) {
            System.out.println(e);
        }
        return output;
    }
    
    public Boolean putRequest(String url, Object object) {
        Boolean objectAtualizado = false;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        
        try {
            String objectJson = new Gson().toJson(object);
            HttpPut putRequest = new HttpPut(url);
            putRequest.setHeader("Content-Type", "application/json");

            HttpEntity entity = new ByteArrayEntity(objectJson.getBytes("UTF-8"));
            putRequest.setEntity(entity);
            
            CloseableHttpResponse response = httpClient.execute(putRequest);
            
            StatusLine statusLine = response.getStatusLine();
            
            objectAtualizado = statusLine.getStatusCode() == 200;
        } catch (IOException e) {
            System.out.println(e);
        }
        return objectAtualizado;
    }
    
    public Boolean postRequest(String url, Object object) {
        Boolean objectAdicionado = false;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        
        try {
            String objectJson = new Gson().toJson(object);
            
            HttpPost postRequest = new HttpPost(url);
            postRequest.setHeader("Content-Type", "application/json");
            
            HttpEntity entity = new ByteArrayEntity(objectJson.getBytes("UTF-8"));
            postRequest.setEntity(entity);
            
            CloseableHttpResponse response = httpClient.execute(postRequest);
            
            StatusLine statusLine = response.getStatusLine();
            
            objectAdicionado = statusLine.getStatusCode() == 201;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                Logger.getLogger(ProdutoService.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return objectAdicionado;
    }
    
    public Boolean deleteRequest(String url) {
        Boolean objectDeletado = false;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        
        try {            
            HttpDelete deleteRequest = new HttpDelete(url);
            
            CloseableHttpResponse response = httpClient.execute(deleteRequest);
            
            StatusLine statusLine = response.getStatusLine();
            
            objectDeletado = statusLine.getStatusCode() == 200;            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return objectDeletado;
    }
    
}
