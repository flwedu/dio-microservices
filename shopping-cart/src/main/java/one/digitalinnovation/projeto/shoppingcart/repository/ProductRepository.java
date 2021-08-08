package one.digitalinnovation.projeto.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.projeto.shoppingcart.model.Product;
import one.digitalinnovation.projeto.shoppingcart.model.Product.Id;

@Repository
public interface ProductRepository extends JpaRepository<Product, Id> {

}
