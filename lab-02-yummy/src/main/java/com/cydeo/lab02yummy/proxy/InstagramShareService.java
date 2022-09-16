package com.cydeo.lab02yummy.proxy;

import com.cydeo.lab02yummy.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class InstagramShareService implements ShareService{

    @Override
    public void share(Recipe recipe) {
        System.out.println("I want to share this recipe with my Insta friends, enjoy");
        System.out.println(recipe);
    }
}
