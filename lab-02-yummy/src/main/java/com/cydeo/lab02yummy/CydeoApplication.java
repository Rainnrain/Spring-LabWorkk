package com.cydeo.lab02yummy;

import com.cydeo.lab02yummy.config.DBConfigData;
import com.cydeo.lab02yummy.model.Recipe;
import com.cydeo.lab02yummy.model.RecipeType;
import com.cydeo.lab02yummy.service.RecipeServiceImp;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CydeoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(CydeoApplication.class, args);
		RecipeServiceImp recipeService= container.getBean(RecipeServiceImp.class);


		recipeService.prepareRecipe();

		DBConfigData author = container.getBean(DBConfigData.class);
		System.out.println("Here you are! Author information of the recipe");
		System.out.println("Name " + author.getName() + " Surname " + author.getSurname()
				 + "\n" + "Social Media Links "
				+ author.getSocial() + "\n" + "Email " + author.getEmail());
	}




/*
	Faker faker= new Faker();
		Recipe recipe = new Recipe();

		int i=0;
		while(i<100) {

			recipe.setRecipeType(RecipeType.getType(faker.number().numberBetween(1,7)));
			recipe.setId(faker.number().randomDigit());
			recipe.setDuration(faker.number().randomDigit());
			recipe.setName(faker.food().dish());
			recipeService.prepare();
			recipeService.printDBConfiguration();
			i++;
		}
}
*/





}
