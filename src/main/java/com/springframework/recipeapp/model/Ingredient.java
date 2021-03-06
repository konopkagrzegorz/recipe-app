package com.springframework.recipeapp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredient", schema = "public")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasure uom) {
        this.uom = uom;
    }

    public Long getRecipeId() {
        return recipe.getId();
    }

    public void setRecipeId(Long recipeId) {
        this.recipe.setId(recipeId);
    }
}
