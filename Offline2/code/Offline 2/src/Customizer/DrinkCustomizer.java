package Customizer;

import Drinks.Customization;
import Ingredients.Ingredient;
import Toppings.Toppings;

import java.util.HashMap;
import java.util.Map;

public class DrinkCustomizer implements Customizer{
    private int price;
    private Map<Toppings,Integer> extraIngredients = new HashMap<>();

    private boolean switchToAlmondMilk;

    @Override
    public void addExtraIngredient(Toppings toppings, int extraPrice) {
        extraIngredients.put(toppings,extraPrice);
//        System.out.println("Added "+toppings+" for "+extraPrice+"TK");
    }

    @Override
    public void IncrementPrice(int price) {
        this.price += price;
    }

    @Override
    public void switchToAlmondMilk() {
        switchToAlmondMilk = true;
    }

    public Customization getCustomization() {
        return new Customization(extraIngredients,switchToAlmondMilk);
    }
}
