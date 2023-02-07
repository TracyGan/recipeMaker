package model;

import model.Ingredient;
import model.Recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe testRecipe;
    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Ingredient i4;
    private Ingredient i5;
    private Ingredient i6;
    private Ingredient i7;
    private ArrayList<Ingredient> IngredientList = new ArrayList<>();

    @BeforeEach
    // TODO: add a list of ingredients
    void setUp() {
        testRecipe = new Recipe();
        i1 = new Ingredient("rice", 1000);
        i2 = new Ingredient("kimchi", 500);
        i3 = new Ingredient ("egg", 1000);
        i4 = new Ingredient("garlic", 100);
        i5 = new Ingredient("sesame seed", 15);
        i6 = new Ingredient("seaweed", 50);
        i7 = new Ingredient("oyster sauce", 10);

        IngredientList.add(i1);
        IngredientList.add(i2);
        IngredientList.add(i3);
        IngredientList.add(i4);
        IngredientList.add(i5);
    }

    @Test
    void testConstructor() {
        testRecipe.makeRecipe(2, "kimchi fried rice", 'C', IngredientList);
        assertEquals(2, testRecipe.getID());
        assertEquals("kimchi fried rice", testRecipe.getName());
        assertEquals('C', testRecipe.getType());
        assertEquals(0, testRecipe.getRatings());
        assertEquals(false, testRecipe.getTried());
        assertTrue(testRecipe.getIngredients().contains(i1));
        assertTrue(testRecipe.getIngredients().contains(i2));
        assertTrue(testRecipe.getIngredients().contains(i3));
        assertTrue(testRecipe.getIngredients().contains(i4));
        assertTrue(testRecipe.getIngredients().contains(i5));
    }


    @Test
    void testIncreaseRatings() {
        testRecipe.increaseRating(2);
        assertEquals(2, testRecipe.getRatings());
    }

    @Test
    void testIncreaseRatingsAtBound() {
        testRecipe.increaseRating(5);
        assertEquals(5, testRecipe.getRatings());
    }

    @Test
    void testIncreaseAndDecreaseRatings() {
        testRecipe.increaseRating(5);
        assertEquals(5, testRecipe.getRatings());
        testRecipe.decreaseRating(2);
        assertEquals(3, testRecipe.getRatings());
    }

    @Test
    void testGiveRecipe() {
        assertTrue(testRecipe.giveRecipe().contains(" ID = 1, Name = Kimchi Fried Rice, " +
                "Type = C, Ratings = 0, Ingredients : "));
    }

    @Test
    void testGiveRecipeAfterRating() {
        testRecipe.increaseRating(5);
        assertTrue(testRecipe.giveRecipe().contains(" ID = 1, Name = Kimchi Fried Rice, " +
                "Type = C, Ratings = 5, Ingredients : "));
    }

    @Test
    void testAddOneIngredient() {
        testRecipe.addIngredient(i6);
        assertTrue(testRecipe.getIngredients().contains(i6));
    }

    @Test
    void testGetRecipe() {
        assertEquals('C', testRecipe.getType());
    }

    @Test
    void testGetName() {
        assertEquals("kimchi fried rice", testRecipe.getName());
    }

    @Test
    void testGetID() {
        assertEquals(2, testRecipe.getID());
    }

    @Test
    void testGetRating() {
        assertEquals(0, testRecipe.getRatings());
    }

    @Test
    void testGetTried() {
        assertFalse(testRecipe.getTried());
    }

}
