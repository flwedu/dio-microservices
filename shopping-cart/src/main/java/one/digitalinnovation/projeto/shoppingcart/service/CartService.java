package one.digitalinnovation.projeto.shoppingcart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projeto.shoppingcart.model.Cart;
import one.digitalinnovation.projeto.shoppingcart.model.Product;
import one.digitalinnovation.projeto.shoppingcart.repository.CartRepository;
import one.digitalinnovation.projeto.shoppingcart.repository.ProductRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Optional<Cart> findById(Long id) {
	return cartRepository.findById(id);
    }

    public Cart addItemToCart(Long id, Product product) {

	// Recupera / persiste os dados sobre o item no request body
	Optional<Product> productInDB = productRepository.findById(product.getId());

	Product savedProduct = productInDB.orElseGet(() -> productRepository.save(product));

	// Depois verifica se já existe um carrinho com esse ID na URL.
	Optional<Cart> optionalCart = cartRepository.findById(id);

	// Se já existir um carrinho com esse ID ele será chamado
	// Se não existir, será então criado um carrinho
	Cart cart = optionalCart.orElseGet(() -> Cart.builder().id(id).build());
	cart.addProductToShoppingCart(savedProduct);

	return cartRepository.save(cart);

    }

    public void deleteById(Long id) {

	cartRepository.deleteById(id);
    }

}
