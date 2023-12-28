package Customizer;

import Ingredients.Ingredient;
import Toppings.Toppings;

public interface Customizer {
    void addExtraIngredient(Toppings toppings, int extraPrice);
    void switchToAlmondMilk();
    void IncrementPrice(int price);
}
