package Drinks;

import Toppings.Toppings;

import java.util.Map;

public class Customization {
    private Map<Toppings,Integer> extraIngredients;
    private boolean switchToAlmondMilk;

    public Customization(Map<Toppings, Integer> extraIngredients, boolean switchToAlmondMilk) {
        this.extraIngredients = extraIngredients;
        this.switchToAlmondMilk = switchToAlmondMilk;
    }

    public Map<Toppings, Integer> getExtraIngredients() {
        return extraIngredients;
    }

    public boolean isSwitchToAlmondMilk() {
        return switchToAlmondMilk;
    }
}
