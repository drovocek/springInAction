package ru.soft.mvc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Table
public class Taco {

    @Id
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Transient
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    private List<IngredientRef> ingredientsRefs;

    public void setIngredients(List<Ingredient> ingredients) {
        System.out.println("!!!!!!!!!!");
        this.ingredients = ingredients;
        this.ingredientsRefs = this.ingredients.stream()
                .map(c -> new IngredientRef(c.getId()))
                .toList();
    }
}