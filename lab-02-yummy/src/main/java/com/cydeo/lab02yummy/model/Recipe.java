package com.cydeo.lab02yummy.model;

import lombok.Data;
import java.util.List;
@Data
public class Recipe {

    private int id;
    private String name;
    private int duration;
    private List<Ingredients> ingredientsList;
    private RecipeType recipeType;

}
