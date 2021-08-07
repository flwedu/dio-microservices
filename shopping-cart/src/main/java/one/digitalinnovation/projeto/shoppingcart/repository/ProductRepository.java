package one.digitalinnovation.projeto.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.projeto.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
