package one.digitalinnovation.projeto.shoppingcart.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Essa classe encapsula os dados de um Product, vindos do serviço
 * product-catalog
 * 
 * @author Eduardo
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDAO {

    private Long id;

    private String name;
    private Long amount;
}
