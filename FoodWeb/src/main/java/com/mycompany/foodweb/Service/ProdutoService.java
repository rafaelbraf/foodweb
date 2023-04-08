package com.mycompany.foodweb.Service;

import Util.Constants;
import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Produto;
import com.mycompany.foodweb.Model.Service;


public class ProdutoService {
    
    public Produto pegaProdutoPorId(int idProduto) {
        String url = Constants.BASE_URL_PRODUTOS + idProduto;
        String output = new Service().getRequest(url);
        Produto produto = new Gson().fromJson(output, Produto.class);
        return produto;        
    }
    
    public Produto[] listarTodosOsProdutosDoRestaurante(Long idRestaurante) {
        String url = Constants.BASE_URL_RESTAURANTES + idRestaurante + "/produtos";
        String output = new Service().getRequest(url);
        Produto[] listaDeProdutos = new Gson().fromJson(output, Produto[].class);
        return listaDeProdutos;        
    }
    
    public Boolean cadastrarProduto(Produto produto) {
        String url = Constants.BASE_URL_PRODUTOS;
        Boolean produtoCadastrado = new Service().postRequest(url, produto);
        return produtoCadastrado;        
    }
    
    public Boolean atualizaProdutoPorId(int idProduto, Produto produto) {
        String url = Constants.BASE_URL_PRODUTOS + idProduto;
        Boolean produtoAtualizado = new Service().putRequest(url, produto);
        return produtoAtualizado;
    }
    
    public Boolean excluirProduto(int idProduto) {
        String url = Constants.BASE_URL_PRODUTOS + idProduto;
        Boolean produtoExcluido = new Service().deleteRequest(url);
        return produtoExcluido;        
    }
    
}
