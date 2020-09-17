package com.springframework.recipeapp.model;

import javax.persistence.*;

@Entity
@Table(name = "unit_of_measure")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uom")
    private String uom;

    public UnitOfMeasure() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
