package one.digitalinnovation.projeto.shoppingcart.dao;

import one.digitalinnovation.projeto.shoppingcart.model.Product;

public class ProductMapper {

    public static Product convertDAOToEntity(ProductDAO dao) {

	return Product.builder().id(dao.getId()).name(dao.getName()).amount(dao.getAmount()).build();
    }

    public static ProductDAO convertEntityToDAO(Product entity) {

	return ProductDAO.builder().id(entity.getId()).name(entity.getName()).amount(entity.getAmount()).build();
    }

}
