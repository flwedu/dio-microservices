package one.digitalinnovation.projeto.productcatalog.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import one.digitalinnovation.projeto.productcatalog.config.ElasticSearchConfig;
import one.digitalinnovation.projeto.productcatalog.model.Product;

/**
 * Cria uma especificação de repositório para realizar operações de CRUD com os
 * objetos Product. Implementação a ser configurada pelo próprio SpringBoot com
 * os parâmetos em {@link ElasticSearchConfig}.
 */
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
}
