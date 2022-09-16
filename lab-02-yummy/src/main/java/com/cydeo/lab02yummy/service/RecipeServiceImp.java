package com.cydeo.lab02yummy.service;

import com.cydeo.lab02yummy.config.DBConfigData;
import com.cydeo.lab02yummy.model.Ingredients;
import com.cydeo.lab02yummy.model.QuantityType;
import com.cydeo.lab02yummy.model.Recipe;
import com.cydeo.lab02yummy.proxy.ShareService;
import com.cydeo.lab02yummy.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeServiceImp implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final DBConfigData dbConfigData;



    public RecipeServiceImp(RecipeRepository recipeRepository, ShareService shareService, DBConfigData dbConfigData) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.dbConfigData = dbConfigData;

    }

    @Override
    public void prepareRecipe(Recipe recipe) {
        Faker faker= new Faker();
      List<Ingredients> ingredientsList= new ArrayList<>();

        int i=0;
        while(i<8){
            Ingredients ingredients= new Ingredients();

            ingredients.setName(faker.food().ingredient());
            ingredients.setQuantiy(faker.number().randomDigit());
            ingredients.setQuantityType(QuantityType.getQuantityType(faker.number().numberBetween(1,3)));
            ingredientsList.add(ingredients);

            i++;}

        recipe.setIngredientsList(ingredientsList);
        recipeRepository.saveRecipe(recipe);
        shareService.share(recipe);


    }

    public void printDBConfiguration(){
        System.out.println(dbConfigData.getName()+"\n"+dbConfigData.getSurname()+"\n"+dbConfigData.getEmail()
                +"\n"+dbConfigData.getSocial());
    }

}
