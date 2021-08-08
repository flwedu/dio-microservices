package one.digitalinnovation.projeto.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
	if (products == null) {
	    products = new ArrayList<Product>();
	}
	return products;
    }

    // Esse método primeiro verifica se o CartId bate com o ID do Carro.
    // Depois verifica se o item com o mesmo productId já existe na lista.
    // Caso negativo, adiciona o item a lista.
    // Caso positivo, apenas ajusta o seu amount (quantidade).
    public void addProductToShoppingCart(Product newProduct) {

	if (newProduct.getId().getCartId().equals(this.getId())) {

	    if (getProducts().stream().noneMatch(product -> product.getId() == newProduct.getId())) {
		getProducts().add(newProduct);
	    } else {
		getProducts().stream().filter(product -> product.getId() == newProduct.getId()).forEach(product -> {
		    product.setAmount(product.getAmount() + newProduct.getAmount());
		});

	    }

	}
    }
}