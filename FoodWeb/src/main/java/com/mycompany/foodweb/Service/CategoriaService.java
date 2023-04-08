package com.mycompany.foodweb.Service;

import Util.Constants;
import com.google.gson.Gson;
import com.mycompany.foodweb.Model.Categoria;
import com.mycompany.foodweb.Model.Service;

public class CategoriaService {
    
    public Categoria[] pegaCategoriasDoRestaurante(Long idRestaurante) {        
        String url = Constants.BASE_URL_CATEGORIAS + "restaurante/" + idRestaurante;
        String output = new Service().getRequest(url);
        Gson gson = new Gson();
        Categoria[] listaDeCategorias = gson.fromJson(output, Categoria[].class);
        return listaDeCategorias;
    }
    
    public Categoria pegaCategoriaPorId(Long idCategoria) {
        String url = Constants.BASE_URL_CATEGORIAS + idCategoria;
        String output = new Service().getRequest(url);
        Categoria categoria = new Gson().fromJson(output, Categoria.class);
        return categoria;
    }
    
    public Boolean atualizaCategoriaPorId(Long idCategoria, Categoria categoria) {
        String url = Constants.BASE_URL_CATEGORIAS + idCategoria;
        Boolean categoriaAtualizada = new Service().putRequest(url, categoria);
        return categoriaAtualizada;
    }
    
    public Boolean adicionarNovaCategoria(Categoria categoria) {
        String url = Constants.BASE_URL_CATEGORIAS;
        Boolean categoriaAdicionada = new Service().postRequest(url, categoria);
        return categoriaAdicionada;
    }
    
}
