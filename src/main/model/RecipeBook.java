package model;

import java.util.ArrayList;

// Represents a recipe book containing a list of recipes that
// I can make with ingredients in fridge
public class RecipeBook {
    private char type;
    private ArrayList<Recipe> recipeList;

    // EFFECTS: creates a recipe book containing a list of recipes available
    // that I can make with ingredients in my fridge
    public RecipeBook() {
        recipeList = new ArrayList<Recipe>();
    }

    // MODIFIES: this
    // EFFECTS: adds the recipe into the recipe book if ingredients
    // in fridge match ingredients needed for the recipe, otherwise doesn't add the recipe
    public void addRecipes(Recipe recipe) {
        recipeList.add(recipe);
    }

    // MODIFIES: this
    // EFFECTS: remove the recipe from the recipe book if rating = 1
    public void removeRecipes(Recipe recipe) {
        int counter = 1;
        for (Recipe rep : recipeList) {
            if (rep.getRatings() == 1) {
                recipeList.remove(counter);
            }
            counter++;
        }
    }

    // EFFECTS: returns the number of recipes in RecipeBook
    public int numRecipes() {
        return recipeList.size();
    }

    // EFFECTS: returns true if recipe is in RecipeBook
    public boolean checkRecipe(Recipe r) {
        if (recipeList.contains(r)) {
            return true;
        }
        return false;
    }

    // EFFECTS: checks if the RecipeBook is empty
    public boolean isEmpty() {
        if (recipeList.isEmpty()) {
            return true;
        }
        return false;
    }
}
