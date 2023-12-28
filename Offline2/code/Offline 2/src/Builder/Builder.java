package Builder;

import DrinkTypes.DrinkType;
import Ingredients.Ingredient;
import Toppings.Toppings;

import java.util.ArrayList;
import java.util.Map;

public interface Builder {
    void setDrinkType(DrinkType drinkType);
    void setPrice(int price);
    void setTotalPrice(int totalPrice);
    void setBaseIngredients(ArrayList<Ingredient> baseIngredients);
    void setExtraIngredients(Map<Toppings,Integer> extraIngredients);
    void addIngredient(Ingredient ingredient);
    void removeIngredient(Ingredient ingredient);
    void substituteIngredient(Ingredient before,Ingredient after,ArrayList<Ingredient> baseIngredients);
    void IncrementPrice(int price);

}
