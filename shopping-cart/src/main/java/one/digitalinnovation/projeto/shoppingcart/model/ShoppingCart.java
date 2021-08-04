package one.digitalinnovation.projeto.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<Item> itemList;

    public List<Item> getItemList() {
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        return itemList;
    }
}
