package one.digitalinnovation.projeto.shoppingcart.model;

import java.util.function.Predicate;

public class UtilFunctions {

    public static Predicate<Product> productPossuioMesmoProductId(Product otherProduct) {
	return product -> product.getId().getProductId().equals(otherProduct.getId().getProductId());
    }

    public static Predicate<Product> productPossuiOMesmoCartId(Product otherProduct) {
	return product -> product.getId().getCartId().equals(otherProduct.getId().getCartId());

    }

    public static Predicate<Product> productPossuioMesmoId(Product otherProduct) {
	return product -> product.getId().equals(otherProduct.getId());
    }

    public static Predicate<Product> productPossuiAoCart(Long id) {
	return product -> product.getId().getCartId().equals(id);
    }

}
