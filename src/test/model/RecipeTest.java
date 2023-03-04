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
    private Ingredient i8;

    @BeforeEach
    void setUp() {
        i1 = new Ingredient("rice", 1000,Unit.g);
        i2 = new Ingredient("kimchi", 500, Unit.g);
        i3 = new Ingredient ("egg", 1000, Unit.whole);
        i4 = new Ingredient("garlic", 0.5, Unit.whole);
        i5 = new Ingredient("sesame seed", 10, Unit.g);
        i6 = new Ingredient("seaweed", 50, Unit.g);
        i7 = new Ingredient("oyster sauce", 1, Unit.tbsp);
        i8 = new Ingredient("salt", 1, Unit.tsp);

        ArrayList<Ingredient> IngredientList = new ArrayList<>();
        IngredientList.add(i1);
        IngredientList.add(i2);
        IngredientList.add(i3);
        IngredientList.add(i4);
        IngredientList.add(i5);
        IngredientList.add(i6);
        IngredientList.add(i7);
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
        assertEquals(1, testRecipe.getID());
        assertEquals("kimchi fried rice", testRecipe.getName());
        assertEquals('C', testRecipe.getType());
        assertEquals(0, testRecipe.getRatings());
        System.out.println(testRecipe.getIngredients());
    }

    @Test
    void testGiveRecipeAfterRating() {
        testRecipe.increaseRating(5);
        assertEquals(1, testRecipe.getID());
        assertEquals("kimchi fried rice", testRecipe.getName());
        assertEquals('C', testRecipe.getType());
        assertEquals(5, testRecipe.getRatings());
    }

    @Test
    void testAddOneIngredient() {
        testRecipe.addIngredient(i6);
        assertTrue(testRecipe.getIngredients().contains(i6));
    }

    @Test
    void testGetType() {
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

    @Test
    void testGetIngredients() {
        ArrayList<Ingredient> ingredientListCheck = new ArrayList<>();
        ingredientListCheck.add(i1);
        ingredientListCheck.add(i2);
        ingredientListCheck.add(i3);
        ingredientListCheck.add(i4);
        ingredientListCheck.add(i5);
        ingredientListCheck.add(i6);
        ingredientListCheck.add(i7);
        assertTrue(testRecipe.getIngredients().equals(ingredientListCheck));
    }

    @Test
    void testGetRecipe() {
        assertTrue(testRecipe.getRecipe().contains("ID = 1" +"\n Name = kimchi fried rice" +
                "\n Type = C" + "\n Rating = 0"));
    }

    @Test
    void testAddIngredient() {
        testRecipe.addIngredient(i8);
        ArrayList<Ingredient> ingredientListCheck = new ArrayList<>();
        ingredientListCheck.add(i1);
        ingredientListCheck.add(i2);
        ingredientListCheck.add(i3);
        ingredientListCheck.add(i4);
        ingredientListCheck.add(i5);
        ingredientListCheck.add(i6);
        ingredientListCheck.add(i7);
        assertFalse(testRecipe.getIngredients().contains(ingredientListCheck));
    }

    @Test
    void testGetIngredientAmount() {
        assertEquals(1000, testRecipe.getIngredientAmount(i1));
    }

    @Test
    void testGetMoreIngredientAmount() {
        assertEquals(1000, testRecipe.getIngredientAmount(i1));
        assertEquals(0.5, testRecipe.getIngredientAmount(i4));
    }

    @Test
    void testGetIngredient() {
        assertEquals(i1, testRecipe.getIngredient(0));
    }

}
