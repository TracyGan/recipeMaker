package model;

import java.util.ArrayList;

// Represents a recipe having an id, name, type of food (A = vegetarian, B = vegan, C = pescatarian, or D = omnivore),
// ratings (1-5) where a rating of 5 means excellent, whether the user has tried it,
// and a list of ingredients with its specified amount (in grams)
public class Recipe {
    private int id;                 // id of the recipe
    private String name;            // name of recipe
    private char type;            // type of recipe
    private int ratings;            // ratings of the recipe
    private boolean tried;          // whether I have tried this recipe
    private ArrayList<Ingredient> ingredientList;  // list of ingredients needed for the recipe

    // EFFECTS: constructs a recipe, with a certain ID, name of recipe, type of recipe, the ratings of recipe,
    // a value of false in tried and a list of ingredients needed for that recipe
    public Recipe(int idValue, String recipeName, char recipeType, int ratings, ArrayList ingredients) {
        this.id = idValue;
        this.name = recipeName;
        this.type = recipeType;
        this.ratings = ratings;
        this.tried = false;
        this.ingredientList = ingredients;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public char getType() {
        return type;
    }

    public int getRatings() {
        return ratings;
    }

    public boolean getTried() {
        return tried;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredientList;
    }

    // REQUIRES: star > 0 and star + ratings <= 5
    // MODIFIES: this
    // EFFECTS: star is added to the ratings and updated ratings is returned
    public int increaseRating(int star) {
        ratings = ratings + star;
        return ratings;
    }

    // REQUIRES: star > 0 and star < ratings and star - ratings > 0
    // MODIFIES: this
    // EFFECTS: star is removed from the ratings and updated ratings is returned
    public int decreaseRating(int star) {
        ratings = ratings - star;
        return ratings;
    }

    public String giveRecipe() {
        return "[ ID = " + id + ", " + "Name = " + name + ", " + "Type = " + type + ", "
                + "Ratings = " + ratings + ", " + "Ingredients : " + ingredientList + "]";
    }

    // MODIFIES: this
    // EFFECTS: adds an ingredient into list of ingredients needed for the recipe
    public void addIngredient(Ingredient i) {
        ingredientList.add(i);
    }


}
