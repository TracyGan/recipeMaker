package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.ListIterator;

// Represents a fridge having a list of ingredients that are available
public class Fridge implements Writable {
    private ArrayList<Ingredient> ingredientList;
    private String name;

    // EFFECTS: constructs a fridge with a name and an empty list of ingredients
    public Fridge(String name) {
        this.name = name;
        ingredientList = new ArrayList<Ingredient>();
    }

    // EFFECTS: return the name of the fridge
    public String getName() {
        return name;
    }

    // EFFECTS: returns the amount of a specific ingredient in the fridge
    public double getIngredientAmount(Ingredient i) {
        return i.getQuantity();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredientList;
    }

    // MODIFIES: this, ingredient
    // EFFECTS: inserts an ingredient into the fridge,
    // unless if there is already that ingredient, then add the amount
    public void addIngredient(Ingredient item) {
        for (Ingredient i : ingredientList) {
            if ((i.getItem().equals(item.getItem()))) {
                i.addQuantity(item.getQuantity());
                EventLog.getInstance().logEvent(new Event("Added " + item.getItem()
                        + " by " + item.getQuantity()));
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
            EventLog.getInstance().logEvent(new Event("Added " + item.getQuantity() + " "
                    + item.getUnit().name() + " of " + item.getItem() + " into fridge!"));
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
                double n = element.reduceQuantity(amountNeeded);
                if (n == 0) {
                    iter.remove();
                    EventLog.getInstance().logEvent(new Event("Removed " + Double.toString(amountNeeded)
                            + " " + item.getUnit().name() +  " of " + item.getItem() + " from the fridge!"));
                } else {
                    EventLog.getInstance().logEvent(new Event("Reduced "
                            + item.getItem() + " by " + Double.toString(amountNeeded) + item.getUnit().name() + "!"));
                }
            }
        }
    }


    // EFFECTS: returns true if ingredient is in the fridge
    public Boolean containIngredient(Ingredient i) {
        return ingredientList.contains(i);
    }

    // EFFECTS: returns true if the fridge is empty
    public boolean checkIsEmpty() {
        return ingredientList.isEmpty();
    }

    public int getSize() {
        return ingredientList.size();
    }

    // EFFECTS: returns the ingredient with that index number
    public Ingredient getItem(int n) {
        return ingredientList.get(n);
    }

    // MODIFIES: json
    // EFFECTS: creates a new JSON object relating to the ingredient
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Ingredients", ingredientsToJson());
        return json;
    }

    // MODIFIES: jsonArray
    // EFFECTS: adds the list of ingredients in the fridge to the jsonArray
    private JSONArray ingredientsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Ingredient i : ingredientList) {
            jsonArray.put(i.toJson());
        }
        return jsonArray;
    }
}
