package one.digitalinnovation.projeto.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.projeto.shoppingcart.dao.ProductDAO;
import one.digitalinnovation.projeto.shoppingcart.model.Cart;
import one.digitalinnovation.projeto.shoppingcart.service.CartService;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/{id}")
    Optional<Cart> findById(@PathVariable Long id) {
	return cartService.findById(id);
    }

    @PostMapping("/{id}")
    Cart addItem(@PathVariable Long id, @RequestBody ProductDAO product) {

	return cartService.addItemToCart(id, product);
    }

    @DeleteMapping("{/id}")
    void clear(@PathVariable Long id) {
	cartService.deleteById(id);
    }
}
