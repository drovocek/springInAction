package ru.soft.mvc.repository;

import org.springframework.data.repository.Repository;
import ru.soft.mvc.model.Ingredient;

import java.util.Optional;

public interface IngredientRepositoryJDBC extends Repository<Ingredient, String> {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}