package one.digitalinnovation.projeto.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Cart {

    @Id()
    private Long id;

    @OneToMany
    private List<Product> productList;

    public List<Product> getProductList() {
	if (productList == null) {
	    productList = new ArrayList<>();
	}
	return productList;
    }

    // Esse método verifica se o item já existe na lista.
    // Caso negativo, adiciona o item a lista.
    // Caso positivo, apenas ajusta o seu amount (quantidade).
    public void addProductToShoppingCart(Product newProduct) {

	if (getProductList().stream().noneMatch(product -> product.getId() == newProduct.getId())) {
	    getProductList().add(newProduct);
	} else {
	    getProductList().stream().filter(product -> product.getId() == newProduct.getId()).forEach(product -> {
		product.setAmount(product.getAmount() + newProduct.getAmount());
	    });
	}
    }
}
