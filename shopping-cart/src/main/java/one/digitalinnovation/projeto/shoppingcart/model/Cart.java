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

    public void addProductToShoppingCart(Product newProduct) {

	// Primeiro verifica se existem produtos com o Id(cartId e productId).
	// Caso positivo, apenas ajusta o amount dos itens encontrados.

	getProducts().stream().filter(UtilFunctions.productPossuioMesmoId(newProduct)).forEach(product -> {
	    product.setAmount(product.getAmount() + newProduct.getAmount());
	});

	// Se o produto ainda não constar no carrinho, o adiciona a lista
	if (getProducts().stream().noneMatch(UtilFunctions.productPossuioMesmoId(newProduct))) {

	    // Apenas se o cartId for o mesmo
	    if (newProduct.getId().getCartId().equals(this.getId()))
		getProducts().add(newProduct);

	}
	;
    }
}