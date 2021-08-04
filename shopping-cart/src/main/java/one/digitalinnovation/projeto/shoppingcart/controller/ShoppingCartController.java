package one.digitalinnovation.projeto.shoppingcart.controller;

import one.digitalinnovation.projeto.shoppingcart.model.Item;
import one.digitalinnovation.projeto.shoppingcart.model.ShoppingCart;
import one.digitalinnovation.projeto.shoppingcart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @RequestMapping("/{id}")
    Optional<ShoppingCart> findById(@PathVariable Long id){
        return shoppingCartRepository.findById(id);
    }

    @PostMapping("/{id}")
    ShoppingCart addItem(@PathVariable Long id, @RequestBody Item item){

        Optional<ShoppingCart> findShoppingCart = shoppingCartRepository.findById(id);

        // Se já existir um carrinho com esse ID, adiciona o item a ele
        if (findShoppingCart.isPresent()){
            findShoppingCart.get().getItemList().add(item);
            return findShoppingCart.get();
        }

        // Se não existir ainda, então persista o carrinho com o ID passado e já adicione o item
        ShoppingCart newShoppingCart = ShoppingCart.builder()
                .id(id)
                .itemList(List.of(item))
                .build();
        return shoppingCartRepository.save(newShoppingCart);
    }

    @DeleteMapping("{/id}")
    void clear(@PathVariable Long id){
        shoppingCartRepository.deleteById(id);
    }
}
