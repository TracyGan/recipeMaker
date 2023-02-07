package model;

// Represents an ingredient with its name, and quantity in (in grams)
//              if initialAmount = 0, then remove from the ingredient,
//              otherwise, quantity =initialAmount
public class Ingredient {
    private String item;
    private double quantity;

    // REQUIRES: ingredientName has a non-zero length,
    //           initialAmount >= 0
    // EFFECTS: the name of ingredient is set to ingredientName;
    //          the quantity of ingredients, is set to quantity + initialAmount
    public Ingredient(String ingredientName, double initialAmount) {
        item = ingredientName;
        quantity = quantity + initialAmount;
    }

    public String getItem() {
        return item;
    }

    public double getQuantity() {
        return quantity;
    }
    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: amount of ingredients is added to the quantity and updated amount is returned
    public double addQuantity(double amount) {
        quantity = quantity + amount;
        return quantity;
    }


    // REQUIRES: amount >= 0 and amount <= getQuantity()
    // MODIFIES: this
    // EFFECTS: amount of ingredients is removed from quantity and updated amount is returned
    public double reduceQuantity(double amount) {
        quantity = quantity - amount;
        return quantity;
    }

    // EFFECTS: returns a string to indicate what ingredient is left and
    // the quantity of that ingredient (in grams)
    public String updateIngredients() {
        return "[ item = " + item + " , " + " quantity = " + quantity + " ]";
    }


}




