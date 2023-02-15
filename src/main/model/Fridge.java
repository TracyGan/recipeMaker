package model;

import java.util.ArrayList;
import java.util.ListIterator;

// Represents a fridge having a list of ingredients that are available
public class Fridge {
    ArrayList<Ingredient> ingredientList;

    // EFFECTS: constructs a fridge with an empty list of ingredients
    public Fridge() {
        ingredientList = new ArrayList<Ingredient>();
    }

    // MODIFIES: this, ingredient
    // EFFECTS: inserts an ingredient into the fridge,
    // unless if there is already that ingredient, then add the amount
    public void addIngredient(Ingredient item) {
        for (Ingredient i : ingredientList) {
            if ((i.getItem().equals(item.getItem()))) {
                i.addQuantity(item.getQuantity());
            }
        }
        int i = 0;
        boolean flag = false;
        while (i < ingredientList.size() && !flag) {
            Ingredient temp = ingredientList.get(i);
            if (temp.getItem().equals(item.getItem())) {
                flag = true;
            }
            i++;
        }
        if (!flag) {
            ingredientList.add(item);
        }
    }

    // EFFECTS: returns ingredient in list with that name
    public Ingredient getIngredient(String item) {
        for (Ingredient i : ingredientList) {
            if ((i.getItem()).equals(item)) {
                return i;
            }
        }
        return null;
    }

    // REQUIRES: amountNeeded > 0 and amount >= amount - amountNeeded, item already in the list
    // MODIFIES: this, ingredient
    // EFFECTS: decrease the amount of an ingredient by amount = amount - amountNeeded
    // unless if amount = 0, then remove ingredient
    public void removeOrReduceIngredient(Ingredient item, double amountNeeded) {
        ListIterator<Ingredient> iter = ingredientList.listIterator();
        while (iter.hasNext()) {
            Ingredient element = iter.next();
            if (element.getItem().equals(item.getItem())) {
                if (element.reduceQuantity(amountNeeded) == 0) {
                    iter.remove();
                }
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
        if (ingredientList.isEmpty()) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns the number of ingredients in the fridge
    public int getSize() {
        return ingredientList.size();
    }

    // EFFECTS: returns the ingredient with that index number
    public Ingredient getItem(int n) {
        return ingredientList.get(n);
    }

}
