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
    public void testeInsercaoDeProduto() {        
        Restaurante restaurante = new Restaurante("teste2@mail.com", "123456");
        RestauranteService restauranteService = new RestauranteService();
        Restaurante restauranteLogado = restauranteService.fazerLoginComEmailESenha(restaurante);
        
        Categoria[] arrayCategorias = restauranteService.listaCategoriasDoRestaurante(restauranteLogado.getId());
        List<Categoria> listaDeCategorias = Arrays.asList(arrayCategorias[0]);
        
        Produto produto = new Produto("Teste", "Teste", 20.0, 10.0, "imgUrl", restauranteLogado, listaDeCategorias);
        Boolean produtoAdicionado = new ProdutoService().cadastrarProduto(produto);
        
        assertEquals(true, produtoAdicionado);
    }
}
