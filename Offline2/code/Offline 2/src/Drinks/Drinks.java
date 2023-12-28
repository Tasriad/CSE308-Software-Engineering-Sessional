package Drinks;

import DrinkTypes.DrinkType;
import Ingredients.Ingredient;
import Toppings.Toppings;

import java.util.ArrayList;
import java.util.Map;

public class Drinks {
    private DrinkType drinkType;
    private int price;
    private ArrayList<Ingredient> baseIngredients;
    private Map<Toppings,Integer> extraIngredients;

    private int totalPrice;

    public Drinks(DrinkType drinkType, int price,int totalPrice, ArrayList<Ingredient> baseIngredients, Map<Toppings, Integer> extraIngredients) {
        this.drinkType = drinkType;
        this.price = price;
        this.baseIngredients = baseIngredients;
        this.extraIngredients = extraIngredients;
        this.totalPrice = totalPrice;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Ingredient> getBaseIngredients() {
        return baseIngredients;
    }

    public Map<Toppings, Integer> getExtraIngredients() {
        return extraIngredients;
    }
    public void calculateTotalPrice(){
        for (Map.Entry<Toppings,Integer> entry:extraIngredients.entrySet()) {

            totalPrice += entry.getValue();
        }
    }
    public void PrintDrink(){
        System.out.println(drinkType);
        System.out.println();
        System.out.println("Base Ingredients:");
        for (Ingredient ingredient:baseIngredients) {
            System.out.println(ingredient);
        }
        System.out.println();
        System.out.println("Added Ingredients:");
        if(extraIngredients.isEmpty()){
            System.out.println("None");
        }
        for (Map.Entry<Toppings,Integer> entry:extraIngredients.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println();
        System.out.println(drinkType+" Base Price: "+price+"TK");
        if(baseIngredients.contains(Ingredient.Almond_milk)){
            System.out.println("Almond_milk--------------->+60TK");
        }
        for (Map.Entry<Toppings,Integer> entry:extraIngredients.entrySet()) {
            System.out.println(entry.getKey()+"--------------->+"+entry.getValue()+"TK");
        }
        calculateTotalPrice();
        System.out.println(drinkType+ " Total Price: "+getTotalPrice()+"TK");
    }
}
