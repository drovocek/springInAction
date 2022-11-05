package ru.soft.mvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.soft.mvc.model.Ingredient;
import ru.soft.mvc.model.Ingredient.Type;
import ru.soft.mvc.model.Taco;
import ru.soft.mvc.model.TacoOrder;
import ru.soft.mvc.repository.IngredientRepositoryJDBC;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientRepositoryJDBC ingredientRepo;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = this.ingredientRepo.findAll();
        Map<Type, List<Ingredient>> ingredientsByType = StreamSupport.stream(ingredients.spliterator(), false)
                .collect(Collectors.groupingBy(Ingredient::getType));
        ingredientsByType.forEach((type, ingredients2) ->
                model.addAttribute(type.toString().toLowerCase(), ingredients2));
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {
        if (errors.hasErrors()) {
            return "design";
        }
        tacoOrder.addTaco(taco);

        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }
}