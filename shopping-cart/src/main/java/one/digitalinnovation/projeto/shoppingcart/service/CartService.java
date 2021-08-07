package one.digitalinnovation.projeto.shoppingcart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projeto.shoppingcart.model.Cart;
import one.digitalinnovation.projeto.shoppingcart.model.Product;
import one.digitalinnovation.projeto.shoppingcart.repository.CartRepository;
import one.digitalinnovation.projeto.shoppingcart.repository.ProductRepository;
import one.digitalinnovation.projeto.shoppingcart.restclient.ProductRestClient;

@Service
public class CartService {

    @Autowired
    private CartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    private ProductRestClient productRestClient = new ProductRestClient();

    public Optional<Cart> findById(Long id) {
	return shoppingCartRepository.findById(id);
    }

    public Cart addItemToCart(Long id, Product product) {

	// Recupera / persiste os dados sobre o item no request body
	Product savedProduct = productRestClient.findAndSave(product);

	// Depois verifica se já existe um carrinho com esse ID na URL.
	Optional<Cart> optionalCart = shoppingCartRepository.findById(id);

	// Se já existir um carrinho com esse ID ele será chamado
	// Se não existir, será então criado um carrinho
	Cart cart = optionalCart.orElseGet(() -> Cart.builder().id(id).build());
	cart.addProductToShoppingCart(savedProduct);

	return cart;

    }

    public void deleteById(Long id) {

	shoppingCartRepository.deleteById(id);
    }

}
