package com.cydeo.lab02yummy.service;

import com.cydeo.lab02yummy.config.DBConfigData;
import com.cydeo.lab02yummy.model.Ingredients;
import com.cydeo.lab02yummy.model.QuantityType;
import com.cydeo.lab02yummy.model.Recipe;
import com.cydeo.lab02yummy.model.RecipeType;
import com.cydeo.lab02yummy.proxy.ShareService;
import com.cydeo.lab02yummy.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RecipeServiceImp implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final Faker faker;
    private final DBConfigData dbConfigData;



    public RecipeServiceImp(RecipeRepository recipeRepository, ShareService shareService, Faker faker, DBConfigData dbConfigData) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
        this.dbConfigData = dbConfigData;

    }

   /* @Override
    public void prepare() {
        Recipe recipe= new Recipe();

      List<Ingredients> ingredientsList= new ArrayList<>();

        int i=0;
        while(i<8){
            Ingredients ingredients= new Ingredients();

            ingredients.setName(faker.food().ingredient());
            ingredients.setQuantity(generateRandomValue());
            ingredients.setQuantityType(QuantityType.getQuantityType(faker.number().numberBetween(1,3)));
            ingredientsList.add(ingredients);

            i++;}

        recipe.setIngredientsList(ingredientsList);


        recipeRepository.save(recipe);
        shareService.share(recipe);


    }*/

    public void printDBConfiguration(){
        System.out.println(dbConfigData.getName()+"\n"+dbConfigData.getSurname()+"\n"+dbConfigData.getEmail()
                +"\n"+dbConfigData.getSocial());
    }
    private int generateRandomValue(){
        return new Random().nextInt(20);
    }

//    private List <Ingredients> prepareIngredients(){
//        List<QuantityType> quantityTypeList= List.of(QuantityType.values());
//
//    }


    @Override
    public boolean prepareRecipe() {

        for (int i = 0; i < 20; i++) {

            Arrays.stream(RecipeType.values()).forEach(recipeType -> {
                Recipe recipe = new Recipe();
               recipe.setId(generateRandomValue());
                recipe.setName(faker.food().dish());
                recipe.setDuration(generateRandomValue());
                recipe.setIngredientsList(prepareIngredients());
                recipe.setRecipeType(recipeType);
                recipeRepository.save(recipe);
                shareService.share(recipe);
            });
        }

        return true;
    }

    private List<Ingredients> prepareIngredients() {
        List<QuantityType> quantityTypeList = List.of(QuantityType.values());

        List<Ingredients> ingredientList = new ArrayList<>();

        for (int i = 0; i < generateRandomValue(); i++) {

            Ingredients ingredient = new Ingredients();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(quantityTypeList.get(new Random().nextInt(3)));
            ingredientList.add(ingredient);
        }

        return ingredientList;

    }


}
