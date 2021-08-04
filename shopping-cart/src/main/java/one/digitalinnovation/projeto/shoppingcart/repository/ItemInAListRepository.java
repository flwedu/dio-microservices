package one.digitalinnovation.projeto.shoppingcart.repository;

import one.digitalinnovation.projeto.shoppingcart.model.ItemInAList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInAListRepository extends JpaRepository<ItemInAList, Long> {
}
