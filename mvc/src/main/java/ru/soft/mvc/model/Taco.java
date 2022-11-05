package ru.soft.mvc.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    private Date createdAt = new Date();
    
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}

//@Data
////@Table
//public class Taco {
//
//    @Id
//    private Long id;
//
//    private Date createdAt = new Date();
//
//    @NotNull
//    @Size(min = 5, message = "Name must be at least 5 characters long")
//    private String name;
//
//    @Transient
//    @NotNull
//    @Size(min = 1, message = "You must choose at least 1 ingredient")
//    private List<Ingredient> ingredients;
//
//    private List<IngredientRef> ingredientsRefs;
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//        this.ingredientsRefs = this.ingredients.stream()
//                .map(c -> new IngredientRef(c.getId()))
//                .toList();
//    }
//}