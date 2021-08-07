package one.digitalinnovation.projeto.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingCartApplication {

    // O RestTemplate permite fazer requisições e obter dados de outros serviços.
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
	return new RestTemplate();
    }

    public static void main(String[] args) {
	SpringApplication.run(ShoppingCartApplication.class, args);
    }
}
