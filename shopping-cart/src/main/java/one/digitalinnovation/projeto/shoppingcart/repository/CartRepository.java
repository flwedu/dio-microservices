package one.digitalinnovation.projeto.shoppingcart.repository;

import one.digitalinnovation.projeto.shoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
