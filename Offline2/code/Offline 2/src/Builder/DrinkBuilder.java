package Builder;

import DrinkTypes.DrinkType;
import Drinks.Drinks;
import Ingredients.Ingredient;
import Toppings.Toppings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DrinkBuilder implements Builder{
    private DrinkType drinkType;
    private int price;
    private int totalPrice;
    private ArrayList<Ingredient> baseIngredients = new ArrayList<>();
    private Map<Toppings,Integer> extraIngredients = new HashMap<>();

    @Override
    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public void setBaseIngredients(ArrayList<Ingredient> baseIngredients) {
        this.baseIngredients = baseIngredients;
    }

    @Override
    public void setExtraIngredients(Map<Toppings, Integer> extraIngredients) {
        this.extraIngredients = extraIngredients;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        baseIngredients.add(ingredient);
    }

    @Override
    public void removeIngredient(Ingredient ingredient) {
        baseIngredients.remove(ingredient);
    }

    @Override
    public void substituteIngredient(Ingredient before, Ingredient after, ArrayList<Ingredient> baseIngredients) {
        int index = baseIngredients.indexOf(before);

        if (index != -1) {
            baseIngredients.remove(index);
            baseIngredients.add(index, after);
        } else {
            System.out.println("Ingredient not found in the list: " + before);
        }
    }

    @Override
    public void IncrementPrice(int price) {
        this.totalPrice += price;
    }

    public Drinks getDrink() {
        return new Drinks(drinkType, price,totalPrice, baseIngredients, extraIngredients);
    }
}
