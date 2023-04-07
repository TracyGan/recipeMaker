package model;

import java.util.ArrayList;
import java.util.ListIterator;

// Represents a recipe book containing a list of recipes that
// I can make with ingredients in fridge
public class RecipeBook {
    private ArrayList<Recipe> recipeList;

    // EFFECTS: creates a recipe book containing a list of recipes available
    // that I can make with ingredients in my fridge
    public RecipeBook() {
        recipeList = new ArrayList<>();
    }

    // MODIFIES: this, recipeList
    // EFFECTS: adds the recipe into the recipe book if ingredients
    // in fridge match ingredients needed for the recipe, otherwise doesn't add the recipe
    public void addRecipes(Recipe recipe) {
        recipeList.add(recipe);
    }

    // MODIFIES: this, recipeList
    // EFFECTS: remove the recipe from the recipe book if rating = 1
    public void removeRecipes() {
        ListIterator<Recipe> iter = recipeList.listIterator();
        while (iter.hasNext()) {
            Recipe element = iter.next();
            if (element.getRatings() == 1) {
                iter.remove();
            }
        }
    }

    // EFFECTS: returns the number of recipes in RecipeBook
    public int numRecipes() {
        return recipeList.size();
    }

    // EFFECTS: returns true if recipe is in RecipeBook
    public boolean containsRecipe(Recipe r) {
        return recipeList.contains(r);
    }

    // EFFECTS: returns true if the RecipeBook is empty
    public boolean isEmpty() {
        return recipeList.isEmpty();
    }
}
