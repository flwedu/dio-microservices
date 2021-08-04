package one.digitalinnovation.projeto.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemInAList {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Id
    private Long id;

    private Long productId;
    private Integer amount;
}
