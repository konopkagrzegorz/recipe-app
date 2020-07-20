package guru.springframework.recipeapp.model;

import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table (name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    @NotBlank(message = "This field cannot be empty")
    @Size(min = 3, max = 255, message = "Description must be between {min} and {max} characters long")
    private String description;

    @Column(name = "prepTime")
    @NotNull(message = "Cannot be null value")
    @Min(value = 0,message =  "{value} is minimum value")
    @Max(value = 999, message = "{value} is maximum value")
    private Integer prepTime;

    @Column(name = "cookTime")
    @NotNull(message = "Cannot be null value")
    @Min(value = 0,message =  "{value} is minimum value")
    @Max(value = 999, message = "{value} is maximum value")
    private Integer cookTime;

    @Column(name = "servings")
    @NotNull(message = "Cannot be null value")
    @Min(value = 1,message =  "{value} is minimum value")
    @Max(value = 99, message = "{value} is maximum value")
    private Integer servings;

    @Column(name = "source")
    private String source;

    @Column(name = "url")
    @URL(message = "Must be a correct URL link")
    private String url;

    @Lob
    @Column(name = "directions")
    @NotBlank(message = "Cannot be blank")
    @Size(min = 3,message = "{value} is a minimum value")
    private String directions;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Lob
    @Column(name = "image")
    private Byte[] image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notes_id", referencedColumnName = "id")
    private Notes notes;

    @ManyToMany
    @JoinTable(
            name = "recipe_category",
    joinColumns = @JoinColumn (name = "recipe_id"),
    inverseJoinColumns = @JoinColumn (name = "category_id"))
    @NotEmpty(message = "Min. 1 category is required")
    private Set<Category> categories;

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

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
