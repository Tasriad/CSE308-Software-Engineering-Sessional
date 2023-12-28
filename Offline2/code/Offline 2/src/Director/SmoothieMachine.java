package Director;

import Builder.Builder;
import Customizer.Customizer;
import DrinkTypes.DrinkType;
import Drinks.Customization;
import Ingredients.Ingredient;
import Toppings.Toppings;

public class SmoothieMachine {
    public void makeChocolateShake(Builder builder)
    {
        builder.setDrinkType(DrinkType.Chocolate_Shake);
        builder.setPrice(230);
        builder.setTotalPrice(230);
        //base ingredients
        builder.addIngredient(Ingredient.Regular_milk);
        builder.addIngredient(Ingredient.Sugar);
        builder.addIngredient(Ingredient.Chocolate_syrup);
        builder.addIngredient(Ingredient.Chocolate_ice_cream);
    }
    public void makeCoffeeShake(Builder builder)
    {
        builder.setDrinkType(DrinkType.Coffee_Shake);
        builder.setPrice(250);
        builder.setTotalPrice(250);
        //base ingredients
        builder.addIngredient(Ingredient.Regular_milk);
        builder.addIngredient(Ingredient.Sugar);
        builder.addIngredient(Ingredient.Coffee);
        builder.addIngredient(Ingredient.Jello);
    }
    public void makeStrawberryShake(Builder builder)
    {
        builder.setDrinkType(DrinkType.Strawberry_Shake);
        builder.setPrice(200);
        builder.setTotalPrice(200);
        //base ingredients
        builder.addIngredient(Ingredient.Regular_milk);
        builder.addIngredient(Ingredient.Sugar);
        builder.addIngredient(Ingredient.Strawberry_syrup);
        builder.addIngredient(Ingredient.Strawberry_ice_cream);
    }
    public void makeVanillaShake(Builder builder)
    {
        builder.setDrinkType(DrinkType.Vanilla_Shake);
        builder.setPrice(190);
        builder.setTotalPrice(190);
        //base ingredients
        builder.addIngredient(Ingredient.Regular_milk);
        builder.addIngredient(Ingredient.Sugar);
        builder.addIngredient(Ingredient.Vanilla_flavoring);
        builder.addIngredient(Ingredient.Jello);
    }
    public void makeZeroShake(Builder builder)
    {
        builder.setDrinkType(DrinkType.Zero_Shake);
        builder.setPrice(240);
        builder.setTotalPrice(240);
        //base ingredients
        builder.addIngredient(Ingredient.Regular_milk);
        builder.addIngredient(Ingredient.Sweetener);
        builder.addIngredient(Ingredient.Vanilla_flavoring);
        builder.addIngredient(Ingredient.Sugar_free_jello);
    }
    public void makeLactoseFree( Builder builder,Customizer customizer)
    {
        customizer.switchToAlmondMilk();
        builder.IncrementPrice(60);
    }
    public void addCandy( Customizer customizer)
    {
        customizer.addExtraIngredient(Toppings.Candy,50);
    }
    public void addCookies( Customizer customizer)
    {
        customizer.addExtraIngredient(Toppings.Cookies,40);
    }
    public void makeCustiomization(Builder builder,Customization customization)
    {
        //extra ingredients
        builder.setExtraIngredients(customization.getExtraIngredients());
        //substitute ingredients
        if(customization.isSwitchToAlmondMilk())
        {
            builder.removeIngredient(Ingredient.Regular_milk);
            builder.addIngredient(Ingredient.Almond_milk);
        }
    }

}
