package model;

import java.sql.SQLOutput;
import java.util.ArrayList;

// Represents a fridge having a list of ingredients that are available
// TODO: check when the amount of ingredients =0, I want to remove it from the list of ingredients
//  but do I put state that if statement in the fridge or ingredients class
public class Fridge {
    ArrayList<Ingredient> ingredientList;

    // EFFECTS: constructs a fridge with an empty list of ingredients
    public Fridge() {
        ingredientList = new ArrayList<Ingredient>();
    }

    // MODIFIES: this
    // EFFECTS: inserts an ingredient into the fridge,
    // unless if there is already that ingredient, then add the amount
    public void addIngredient(Ingredient item) {
        for (Ingredient i : ingredientList) {
            if (i.getItem().equals(item)) {
                i.addQuantity(i.getQuantity());
            }
            ingredientList.add(item);
        }
    }

    // REQUIRES: amountNeeded > 0 and amount >= amount - amountNeeded, item already in the list
    // MODIFIES: this
    // EFFECTS: decrease the amount of an ingredient by amount = amount - amountNeeded
    // unless if amount = 0, then remove ingredient
    public String removeOrReduceIngredient(Ingredient item, double amountNeeded) {
        // TODO: deduct amountNeeded of ingredients from amount
        // TODO: if amount = 0, remove ingredient, else do nothing
        for (Ingredient i : ingredientList) {
            int counter = 1;
            if (i.getItem().equals(item)) {
                if (i.reduceQuantity(amountNeeded) == 0) {
                    ingredientList.remove(counter);
                }
                i.reduceQuantity(amountNeeded);
            } else {
                counter++;
            }
        }
        return "No ingredient was reduced!";
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredientList;
    }

    // EFFECTS: returns true if ingredient is in the fridge
    public Boolean containIngredient(Ingredient i) {
        if (ingredientList.contains(i)) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns true if the fridge is empty
    public boolean checkIsEmpty() {
        if (ingredientList.isEmpty() == true) {
            return true;
        }
        return false;
    }

}
