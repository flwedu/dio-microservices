package one.digitalinnovation.projeto.shoppingcart.controller;

import one.digitalinnovation.projeto.shoppingcart.model.ItemInAList;
import one.digitalinnovation.projeto.shoppingcart.model.ShoppingCart;
import one.digitalinnovation.projeto.shoppingcart.repository.ItemInAListRepository;
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

    @Autowired
    private ItemInAListRepository itemInAListRepository;

    @RequestMapping("/{id}")
    Optional<ShoppingCart> findById(@PathVariable Long id){
        return shoppingCartRepository.findById(id);
    }

    @PostMapping("/{id}")
    ShoppingCart addItem(@PathVariable Long id, @RequestBody ItemInAList item){

        // Primeiro persiste o item na base de dados
        ItemInAList savedItem = itemInAListRepository.save(item);

        // Depois verifica se já existe um carrinho com esse ID na URL.
        Optional<ShoppingCart> findShoppingCart = shoppingCartRepository.findById(id);

        // Se já existir um carrinho com esse ID, adiciona o item a ele
        if (findShoppingCart.isPresent()){
            findShoppingCart.get().addItemToShoppingCart(savedItem);

            // Retorna o carrinho atualizado após persisti-lo
            return shoppingCartRepository.save(findShoppingCart.get());
        }

        // Se não existir ainda, então persista o carrinho com o ID passado e já adicione o item
        ShoppingCart newShoppingCart = ShoppingCart.builder()
                .id(id)
                .itemList(List.of(savedItem))
                .build();
        return shoppingCartRepository.save(newShoppingCart);
    }

    @DeleteMapping("{/id}")
    void clear(@PathVariable Long id){
        shoppingCartRepository.deleteById(id);
    }
}
