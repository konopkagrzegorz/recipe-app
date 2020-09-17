package com.springframework.recipeapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name could not be blank")
    @Size(min = 3,message = "Name should be min. {min} characters long")
    @Column(name = "category_name")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                categoryName.equals(category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }
}
