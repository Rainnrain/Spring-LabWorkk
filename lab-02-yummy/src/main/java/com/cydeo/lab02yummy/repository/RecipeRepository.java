package com.cydeo.lab02yummy.repository;

import com.cydeo.lab02yummy.model.Recipe;

public interface RecipeRepository {
    public boolean saveRecipe(Recipe recipe);
}
