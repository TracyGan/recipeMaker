package model;

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
    void setUp() {
        i1 = new Ingredient("rice", 1000,Unit.g);
        i2 = new Ingredient("kimchi", 500, Unit.g);
        i3 = new Ingredient ("egg", 1000, Unit.whole);
        i4 = new Ingredient("garlic", 0.5, Unit.whole);
        i5 = new Ingredient("sesame seed", 10, Unit.g);
        i6 = new Ingredient("seaweed", 50, Unit.g);
        i7 = new Ingredient("oyster sauce", 1, Unit.tbsp);

        IngredientList.add(i1);
        IngredientList.add(i2);
        IngredientList.add(i3);
        IngredientList.add(i4);
        IngredientList.add(i5);
        testRecipe = new Recipe(1, "kimchi fried rice", 'C', 0, IngredientList);
    }

    @Test
    void testConstructor() {
        assertEquals(1, testRecipe.getID());
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
        assertTrue(testRecipe.giveRecipe().contains("[ ID = 1, Name = Kimchi Fried Rice, " +
                "Type = C, Ratings = 0, Ingredients : ]"));
    }

    @Test
    void testGiveRecipeAfterRating() {
        testRecipe.increaseRating(5);
        System.out.println(testRecipe.giveRecipe());
        assertTrue(testRecipe.giveRecipe().contains(" ID = 1, Name = kimchi fried rice, " +
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
        assertEquals(1, testRecipe.getID());
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
