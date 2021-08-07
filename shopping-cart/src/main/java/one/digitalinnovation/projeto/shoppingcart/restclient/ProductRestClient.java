package one.digitalinnovation.projeto.shoppingcart.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import one.digitalinnovation.projeto.shoppingcart.dao.ProductDAO;
import one.digitalinnovation.projeto.shoppingcart.model.Product;
import one.digitalinnovation.projeto.shoppingcart.repository.ProductRepository;

/**
 * Essa classe realiza requisições para o serviço products-catalog para
 * recuperar dados sobre os itens adicionados ao shopping-cart
 * 
 * @author Eduardo
 *
 */
public class ProductRestClient {

    @Autowired
    private RestTemplate clientRest;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<ProductDAO> getProductDAOById(Long id) {

	return clientRest.exchange("http://localhost:8080/product/" + id.toString(), HttpMethod.GET, null,
		ProductDAO.class);
    }

    public Product findAndSave(Product product) {
	// Implementação temporária
	return productRepository.save(product);
    }

}
