package one.digitalinnovation.projeto.productcatalog.controller;

import one.digitalinnovation.projeto.productcatalog.model.Product;
import one.digitalinnovation.projeto.productcatalog.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping()
    ArrayList<Product> listAll() {
        var listaProdutos = new ArrayList<Product>();
        productRepository.findAll().forEach(listaProdutos::add);

        return listaProdutos;
    }

    @GetMapping("/{id}")
    Optional<Product> findById(@PathVariable Long id) {
        return productRepository.findById(id);
    }
}
