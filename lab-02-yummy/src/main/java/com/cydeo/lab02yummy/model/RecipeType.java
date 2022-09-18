package com.cydeo.lab02yummy.model;


public enum RecipeType {
  BREAKFAST(1), LUNCH(2), DESSERT(3), APPETIZER(4), BAKED(5), SOUP(6), VEGETARIAN(7), OTHER;

  int value;

RecipeType(int value){
    this.value=value;
}
RecipeType(){}

   public static RecipeType getType(int value){
  return (value==1)?BREAKFAST:(value==2)?LUNCH:(value==3)?DESSERT:(value==4)?APPETIZER:(value==5)?BAKED:(value==6)?SOUP:(value==7)?VEGETARIAN:OTHER;

    }
}
