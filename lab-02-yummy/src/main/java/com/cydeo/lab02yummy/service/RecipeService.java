package com.cydeo.lab02yummy.service;

import com.cydeo.lab02yummy.model.Ingredients;
import com.cydeo.lab02yummy.model.Recipe;
import com.cydeo.lab02yummy.proxy.ShareService;
import com.cydeo.lab02yummy.repository.DBRecipeRepository;
import com.cydeo.lab02yummy.repository.RecipeRepository;
import com.github.javafaker.Faker;

public interface RecipeService {


    public void prepareRecipe(Recipe recipe);


}
