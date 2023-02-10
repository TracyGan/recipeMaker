package model;

import java.sql.SQLOutput;
import java.util.ArrayList;

// Represents a fridge having a list of ingredients that are available
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
            if (i.getItem().equals(item.getItem())) {
                i.addQuantity(item.getQuantity());
            }
        }
        ingredientList.add(item);
    }

    // EFFECTS: returns ingredient in list with that name
    public Ingredient getIngredient(String item) {
        for (Ingredient i : ingredientList) {
            if (i.getItem() == item) {
                return i;
            }
        }
        return null;
    }

    // REQUIRES: amountNeeded > 0 and amount >= amount - amountNeeded, item already in the list
    // MODIFIES: this
    // EFFECTS: decrease the amount of an ingredient by amount = amount - amountNeeded
    // unless if amount = 0, then remove ingredient
    public void removeOrReduceIngredient(Ingredient item, double amountNeeded) {
        int counter = 1;
        for (Ingredient i : ingredientList) {
            if (i.getItem().equals(item)) {
                if (i.reduceQuantity(amountNeeded) == 0) {
                    ingredientList.remove(counter);
                    counter--;
                }
                i.reduceQuantity(amountNeeded);
            } else {
                counter++;
            }
        }
    }

    public double getIngredientAmount(Ingredient i) {
        return i.getQuantity();
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
