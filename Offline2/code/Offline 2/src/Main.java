import Builder.DrinkBuilder;
import Customizer.DrinkCustomizer;
import Director.SmoothieMachine;
import Drinks.Drinks;
import Drinks.Customization;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static ArrayList<Drinks> drinks;
    public static int totalPrice;
    public static int getTotalPrice(){
        totalPrice = 0;
        for (Drinks drink:drinks) {
            totalPrice += drink.getTotalPrice();
        }
        return totalPrice;
    }
    public static void PrintOrder(){
        for (Drinks drink:drinks) {
            drink.PrintDrink();
            System.out.println();
            System.out.println();
        }
        System.out.println("Total Price of your order: "+getTotalPrice()+" TK");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void clearOrder(){
        drinks.clear();
        totalPrice = 0;
    }
    public static void main(String[] args) {
        drinks = new ArrayList<>();
        SmoothieMachine smoothieMachine = new SmoothieMachine();
        Scanner scanner = new Scanner(System.in);
        String input;
        int option;
        boolean systemOn = true;
        boolean orderOngoing = false;
        boolean atleastOneOrderPlaced = false;
        while (systemOn)
        {
            System.out.println("Welcome to Drink Bar!");
            System.out.println("Press o to place an order.");
            System.out.println("Press e to exit.");
            input = scanner.next();
            if(input.matches("o"))
            {
                orderOngoing = true;
                while (orderOngoing)
                {
                    DrinkBuilder drinkBuilder = new DrinkBuilder();
                    DrinkCustomizer drinkCustomizer = new DrinkCustomizer();
                    Customization customization;
                    System.out.println("This is the menu:");
                    System.out.println("Press 1 to order a Chocolate Shake.(230 Tk)");
                    System.out.println("Press 2 to order a Coffee Shake.(250 Tk)");
                    System.out.println("Press 3 to order a Strawberry Shake.(200 Tk)");
                    System.out.println("Press 4 to order a Vanilla Shake.(190 Tk)");
                    System.out.println("Press 5 to order a Zero Shake.(240 Tk)");
                    System.out.println("Press 6 to finish your order.");
                    option = scanner.nextInt();
                    switch (option)
                    {
                        case 1:
                            smoothieMachine.makeChocolateShake(drinkBuilder);
                            atleastOneOrderPlaced = true;
                            break;
                        case 2:
                            smoothieMachine.makeCoffeeShake(drinkBuilder);
                            atleastOneOrderPlaced = true;
                            break;
                        case 3:
                            smoothieMachine.makeStrawberryShake(drinkBuilder);
                            atleastOneOrderPlaced = true;
                            break;
                        case 4:
                            smoothieMachine.makeVanillaShake(drinkBuilder);
                            atleastOneOrderPlaced = true;
                            break;
                        case 5:
                            smoothieMachine.makeZeroShake(drinkBuilder);
                            atleastOneOrderPlaced = true;
                            break;
                        case 6:
                            if(drinks.isEmpty())
                            {
                                System.out.println("You have not ordered anything!");
                                break;
                            }
                            else
                            {
                                orderOngoing = false;
                            }
                            break;
                        default:
                            System.out.println("Invalid input!");
                            orderOngoing = false;
                            break;
                    }
                    if(orderOngoing && atleastOneOrderPlaced)
                    {
                        System.out.println("Do you want to customize your drink?");
                        System.out.println("Press y for yes.");
                        System.out.println("Press n for no.");
                        scanner.nextLine();
                        input = scanner.next();
                        if(input.matches("y"))
                        {
                            System.out.println("Customization options:");
                            System.out.println("Press 1 to make it lactose free.(60 Tk)");
                            System.out.println("Press 2 to add candy toppings.(50 Tk)");
                            System.out.println("Press 3 to add cookies toppings.(40 Tk)");
                            option = scanner.nextInt();
                            switch (option)
                            {
                                case 1:
                                    smoothieMachine.makeLactoseFree(drinkBuilder,drinkCustomizer);
                                    customization = drinkCustomizer.getCustomization();
                                    smoothieMachine.makeCustiomization(drinkBuilder,customization);
                                    break;
                                case 2:
                                    smoothieMachine.addCandy(drinkCustomizer);
                                    customization = drinkCustomizer.getCustomization();
                                    smoothieMachine.makeCustiomization(drinkBuilder,customization);
                                    break;
                                case 3:
                                    smoothieMachine.addCookies(drinkCustomizer);
                                    customization = drinkCustomizer.getCustomization();
                                    smoothieMachine.makeCustiomization(drinkBuilder,customization);
                                    break;
                                default:
                                    System.out.println("Invalid input!");
                                    break;
                            }
                        }
                        else if(input.matches("n"))
                        {
                            System.out.println("Your drink is ready!");
                        }
                        else
                        {
                            System.out.println("Your drink is ready!");
                        }
                        Drinks drink = drinkBuilder.getDrink();
                        drinks.add(drink);
                        System.out.println("Your drink has been added to the order.");
                    }
                }
                System.out.println("Here is your order details:");
                PrintOrder();
                clearOrder();
            }
            else if(input.matches("e"))
            {
                systemOn = false;
                System.out.println("Thank you for visiting Drink Bar!");
            }
            else
            {
                System.out.println("Invalid input!");
            }
        }
    }
}