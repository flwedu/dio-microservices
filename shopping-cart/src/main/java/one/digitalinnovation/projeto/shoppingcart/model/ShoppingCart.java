package one.digitalinnovation.projeto.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ShoppingCart")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShoppingCart {

    @Id()
    private Long id;

    @ManyToMany
    private List<ItemInAList> itemList;

    public List<ItemInAList> getItemList() {
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        return itemList;
    }

    // Esse método verifica se o item já existe na lista.
    // Caso negativo, adiciona o item a lista.
    // Caso positivo, apenas ajusta o seu amount (quantidade).
    public void addItemToShoppingCart(ItemInAList itemASerAdicionado){
        if (itemList.stream().noneMatch(item -> item.getProductId() == itemASerAdicionado.getProductId())){
            itemList.add(itemASerAdicionado);
        }
        else {
            itemList.stream()
                    .filter(item -> item.getProductId() == itemASerAdicionado.getProductId())
                    .forEach(item -> {
                        item.setAmount(item.getAmount() + itemASerAdicionado.getAmount());
                    });
        }
    }
}
