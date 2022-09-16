package com.cydeo.lab02yummy.repository;

import com.cydeo.lab02yummy.model.Recipe;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
@Component
public class DBRecipeRepository implements RecipeRepository {
    List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean saveRecipe(Recipe recipe) {
        if (recipe != null && !ObjectUtils.isEmpty(recipe)) {
            recipeList.add(recipe);
            return true;
        }
        return false;
    }
}
