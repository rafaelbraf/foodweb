package ProdutoTest;

import com.mycompany.foodweb.Model.Categoria;
import com.mycompany.foodweb.Model.Produto;
import com.mycompany.foodweb.Model.Restaurante;
import com.mycompany.foodweb.Service.ProdutoService;
import com.mycompany.foodweb.Service.RestauranteService;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {
    
    String email = "teste2@mail.com";
    String senha = "123456";
    
    public void testeInsercaoDeProduto() {        
        Restaurante restaurante = new Restaurante(email, senha);
        RestauranteService restauranteService = new RestauranteService();
        Restaurante restauranteLogado = restauranteService.fazerLoginComEmailESenha(restaurante);
        
        Categoria[] arrayCategorias = restauranteService.listaCategoriasDoRestaurante(restauranteLogado.getId());
        List<Categoria> listaDeCategorias = Arrays.asList(arrayCategorias[0]);
        
        Produto produto = new Produto("Teste", "Teste", 20.0, 10.0, "imgUrl", restauranteLogado, listaDeCategorias);
        Boolean produtoAdicionado = new ProdutoService().cadastrarProduto(produto);
        
        assertEquals(true, produtoAdicionado);
    }
    
    public void testeEdicaoDeProduto() {
        Restaurante restaurante = new Restaurante(email, senha);
        
        RestauranteService restauranteService = new RestauranteService();
        Restaurante restauranteLogado = restauranteService.fazerLoginComEmailESenha(restaurante);        
        Produto[] arrayProdutos = restauranteService.listaProdutosDoRestaurante(restauranteLogado.getId());
        
        Produto produto;
        if (arrayProdutos.length > 0) {
            produto = arrayProdutos[0];
        } else {
            return;
        }
        
        produto.setDescricao("Teste Edição");
        produto.setNome("Teste Edição");
        produto.setPreco(2.0);
        produto.setQuantidade(1.0);
        
        Boolean produtoAtualizado = new ProdutoService().atualizaProdutoPorId(produto.getId(), produto);
        
        assertEquals(true, produtoAtualizado);
    }
    
}
