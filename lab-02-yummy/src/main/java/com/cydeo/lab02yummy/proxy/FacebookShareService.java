package com.cydeo.lab02yummy.proxy;

import com.cydeo.lab02yummy.model.Recipe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FacebookShareService implements ShareService{

    @Override
    public void share(Recipe recipe) {
        System.out.println("I want to share this recipe with my Facebook friends, enjoy");
        System.out.println(recipe);
    }
}
