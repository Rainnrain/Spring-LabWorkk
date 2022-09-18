package com.cydeo.lab02yummy.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
//@Component
public class Recipe {

    private int id;
    private String name;
    private int duration;
    private List<Ingredients> ingredientsList;
    RecipeType recipeType;

}
