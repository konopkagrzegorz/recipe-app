package guru.springframework.recipeapp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    @JoinColumn(name = "uom_id", referencedColumnName = "id")
    private UnitOfMeasure uom;
}
