package model;

import java.util.ArrayList;

// Represents a recipe book containing a list of recipes that
// I can make with ingredients in fridge, including the different cuisines
public class RecipeBook {
    private char type;
    private ArrayList<Recipe> recipeList;

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
        for (Recipe rep : recipeList) {
            int counter = 1;
            if (rep.getRatings() == 1) {
                recipeList.remove(counter);
            }
            counter++;
        }
    }
}
