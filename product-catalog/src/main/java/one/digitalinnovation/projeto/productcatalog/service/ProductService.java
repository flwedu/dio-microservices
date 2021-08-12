package one.digitalinnovation.projeto.productcatalog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.projeto.productcatalog.model.Product;
import one.digitalinnovation.projeto.productcatalog.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
	return productRepository.save(product);
    }

    public Iterable<Product> saveAll(Iterable<Product> productList) {
	return productRepository.saveAll(productList);
    }

    public Iterable<Product> findAll() {
	return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
	return productRepository.findById(id);
    }

}
