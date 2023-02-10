package model;


// Represents an ingredient with its name, quantity and units of quantity (in Metric System)
public class Ingredient {
    private String item;
    private double quantity;
    private Unit unit;

    // REQUIRES: ingredientName has a non-zero length,
    //           initialAmount >= 0
    // EFFECTS: the name of ingredient is set to ingredientName;
    //          the quantity of ingredients, is set to quantity + initialAmount, and unit is set to u
    public Ingredient(String ingredientName, double initialAmount, Unit u) {
        this.item = ingredientName;
        this.quantity = quantity + initialAmount;
        this.unit = u;
    }

    public String getItem() {
        return item;
    }

    public double getQuantity() {
        return quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: amount of ingredients is added to the quantity and updated amount is returned
    public double addQuantity(double amount) {
        this.quantity = quantity + amount;
        return quantity;
    }


    // REQUIRES: amount >= 0 and amount <= getQuantity()
    // MODIFIES: this
    // EFFECTS: amount of ingredients is removed from quantity and updated amount is returned
    public double reduceQuantity(double amount) {
        this.quantity = quantity - amount;
        return this.quantity;
    }

    // EFFECTS: returns a string to indicate what ingredient is left and
    // the quantity of that ingredient (in grams)
    public String updateIngredients() {
        return " item = " + item + "," + " quantity = " + quantity + unit;
    }


}




