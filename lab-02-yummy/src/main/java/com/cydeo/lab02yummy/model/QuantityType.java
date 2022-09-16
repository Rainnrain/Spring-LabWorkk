package com.cydeo.lab02yummy.model;




public enum QuantityType {
    OUNCE, LB, TBSP, OTHER;


    public static QuantityType getQuantityType(int num){

        return (num==1)?OUNCE:(num==2)?LB:(num==3)?TBSP:OTHER;
    }


}
