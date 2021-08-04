package one.digitalinnovation.projeto.productcatalog.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Classe que reúne as configurações para conexão com uma database
 * ElasticSearch. Nesse projeto, uma imagem está rodando via docker na porta
 * 9200 e 9300.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "one.digitalinnovation.projeto.productcatalog.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200", "localhost:9300").build();
        return RestClients.create(clientConfiguration).rest();
    }

}
