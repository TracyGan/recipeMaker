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
        return this.item;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public Unit getUnit() {
        return this.unit;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this, quantity
    // EFFECTS: amount of ingredients is added to the quantity and updated amount is returned
    public double addQuantity(double amount) {
        this.quantity = quantity + amount;
        return quantity;
    }

    // REQUIRES: amount >= 0 and amount <= getQuantity()
    // MODIFIES: this, quantity
    // EFFECTS: amount of ingredients is removed from quantity and updated amount is returned
    public double reduceQuantity(double amount) {
        this.quantity = quantity - amount;
        return quantity;
    }

    // EFFECTS: returns ingredient name, quantity and unit
    public String returnIngredient() {
        return "Item = " + item + " ,Quantity = " + quantity + " " + unit;
    }
}




