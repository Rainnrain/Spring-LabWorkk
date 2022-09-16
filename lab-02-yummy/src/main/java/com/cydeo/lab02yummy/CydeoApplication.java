package com.cydeo.lab02yummy;

import com.cydeo.lab02yummy.model.Recipe;
import com.cydeo.lab02yummy.model.RecipeType;
import com.cydeo.lab02yummy.service.RecipeService;
import com.cydeo.lab02yummy.service.RecipeServiceImp;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CydeoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(CydeoApplication.class, args);
		RecipeServiceImp recipeService= container.getBean(RecipeServiceImp.class);


		Faker faker= new Faker();
		Recipe recipe = new Recipe();

		int i=0;
		while(i<100) {

			recipe.setRecipeType(RecipeType.getType(faker.number().numberBetween(1,7)));
			recipe.setId(faker.number().randomDigit());
			recipe.setDuration(faker.number().randomDigit());
			recipe.setName(faker.food().dish());
			recipeService.prepareRecipe(recipe);
			recipeService.printDBConfiguration();
			i++;
		}





	}

}
