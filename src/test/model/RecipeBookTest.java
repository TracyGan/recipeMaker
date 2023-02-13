package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class RecipeBookTest {
    private RecipeBook testRecipeBook;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Ingredient i4;
    private Ingredient i5;
    private Ingredient i6;
    private Ingredient i7;
    private Ingredient i8;
    private Ingredient i9;
    private Ingredient i10;
    private Ingredient i11;


    @BeforeEach
    void setUp() {
        testRecipeBook = new RecipeBook();
        i1 = new Ingredient("kimchi", 150, Unit.g);
        i2 = new Ingredient("rice", 3, Unit.cups);
        i3 = new Ingredient("egg", 200, Unit.whole);
        i4 = new Ingredient("sesame oil", 1, Unit.tbsp);
        i5 = new Ingredient("sesame seed", 1, Unit.tbsp);
        i6 = new Ingredient("garlic", 0.5, Unit.whole);
        i7 = new Ingredient("kimchi", 220, Unit.g);
        i8 = new Ingredient("sugar", 2, Unit.tsp);
        i9 = new Ingredient("flour", 100, Unit.g);
        i10 = new Ingredient("scallion", 3, Unit.whole);
        i11 = new Ingredient("vegetable oil", 2, Unit.tbsp);

        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(i1);
        ingredientList.add(i2);
        ingredientList.add(i3);
        ingredientList.add(i4);
        ingredientList.add(i5);
        ingredientList.add(i6);

        ArrayList<Ingredient> ingredientList1 = new ArrayList<>();
        ingredientList1.add(i7);
        ingredientList1.add(i8);
        ingredientList1.add(i9);
        ingredientList1.add(i10);
        ingredientList1.add(i11);

        ArrayList<Ingredient> ingredientList2 = new ArrayList<>();
        ingredientList.add(i1);
        ingredientList1.add(i11);

        r1 = new Recipe(1, "kimchi fried rice", 'C', 3, ingredientList);
        r2 = new Recipe(2, "kimchi pancake", 'C', 1, ingredientList1);
        r3 = new Recipe(3, "stir fried kimchi", 'C', 1, ingredientList2);
    }

    @Test
    void testConstructor() {
        assertEquals(0, testRecipeBook.numRecipes());
    }

    @Test
    void testAddOneRecipe() {
        testRecipeBook.addRecipes(r1);
        assertTrue(testRecipeBook.containsRecipe(r1));
    }

    @Test
    void testAddTwoRecipe() {
        testRecipeBook.addRecipes(r1);
        assertTrue(testRecipeBook.containsRecipe(r1));
        testRecipeBook.addRecipes(r2);
        assertTrue(testRecipeBook.containsRecipe(r2));
    }

    @Test
    void testRemoveNoRecipe() {
        testRecipeBook.addRecipes(r1);
        assertTrue(testRecipeBook.containsRecipe(r1));
        testRecipeBook.removeRecipes();
        assertFalse(testRecipeBook.isEmpty());
        assertTrue(testRecipeBook.containsRecipe(r1));
    }

    @Test
    void testRemoveTwoRecipe() {
        testRecipeBook.addRecipes(r2);
        testRecipeBook.addRecipes(r3);
        testRecipeBook.removeRecipes();
        assertTrue(testRecipeBook.isEmpty());
        assertFalse(testRecipeBook.containsRecipe(r2));
        assertFalse(testRecipeBook.containsRecipe(r3));
    }

    @Test
    void testRemoveRecipe() {
        testRecipeBook.addRecipes(r2);
        assertTrue(testRecipeBook.containsRecipe(r2));
        testRecipeBook.removeRecipes();
        assertTrue(testRecipeBook.isEmpty());
        assertFalse(testRecipeBook.containsRecipe(r2));
    }

    @Test
    void testCheckRecipe() {
        testRecipeBook.addRecipes(r2);
        assertTrue(testRecipeBook.containsRecipe(r2));
    }

    @Test
    void testCheckNoRecipe() {
        assertFalse(testRecipeBook.containsRecipe(r1));
    }

    @Test
    void testCheckNoRecipeAfterAdding() {
        testRecipeBook.addRecipes(r1);
        assertFalse(testRecipeBook.containsRecipe(r2));
    }

    @Test
    void testNumZeroRecipe() {
        assertEquals(0, testRecipeBook.numRecipes());
    }

    @Test
    void testNumOneRecipe() {
        testRecipeBook.addRecipes(r2);
        assertEquals(1, testRecipeBook.numRecipes());
    }

    @Test
    void testMoreThanOneRecipe() {
        testRecipeBook.addRecipes(r2);
        testRecipeBook.addRecipes(r1);
        assertEquals(2, testRecipeBook.numRecipes());
    }

    @Test
    void testCheckEmpty() {
        assertTrue(testRecipeBook.isEmpty());
    }

    @Test
    void testCheckNotEmpty() {
        testRecipeBook.addRecipes(r1);
        assertFalse(testRecipeBook.isEmpty());
    }

    @Test
    void testCheckRecipeThere() {
        testRecipeBook.addRecipes(r1);
        assertTrue(testRecipeBook.containsRecipe(r1));
    }

    @Test
    void testCheckMoreThanOneRecipe() {
        testRecipeBook.addRecipes(r2);
        testRecipeBook.addRecipes(r1);
        assertTrue(testRecipeBook.containsRecipe(r2));
        assertTrue(testRecipeBook.containsRecipe(r1));
    }
}
