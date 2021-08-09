package one.digitalinnovation.projeto.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @EmbeddedId
    private Id id;

    private String name;
    private Long amount;

    @Getter
    @Setter
    @EqualsAndHashCode
    public static class Id implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long productId;
	private Long cartId;

    }

    public void addAmount(Long amountToAdd) {
	amount += amountToAdd;
    }

}
