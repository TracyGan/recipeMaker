package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FridgeTest {
    private Fridge testFridge;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;
    private Ingredient ingredient4;
    private Ingredient ingredient5;
    private Ingredient ingredient6;
    private Ingredient ingredient7;

    @BeforeEach
    void setUp() {
        testFridge = new Fridge();
        ingredient1 = new Ingredient("rice", 1000);
        ingredient2 = new Ingredient("kimchi", 500);
        ingredient3 = new Ingredient ("egg", 1000);
        ingredient4 = new Ingredient("garlic", 100);
        ingredient5 = new Ingredient("sesame seed", 100);
        ingredient6 = new Ingredient("olive oil", 2000);
        ingredient7 = new Ingredient("rice", 200);
    }

    @Test
    void testConstructor() {
        assertTrue(testFridge.checkIsEmpty());
    }

    @Test
    void testAddOneItem() {
        testFridge.addIngredient(ingredient1);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
    }

    @Test
    void testAddTwoItems() {
        testFridge.addIngredient(ingredient1);
        testFridge.addIngredient(ingredient2);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
        assertTrue(testFridge.getIngredients().contains(ingredient2));
    }

    // TODO: adding an item when it is already found in the list
    @Test
    void testAddOneIngredientTwice() {
        testFridge.addIngredient(ingredient1);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
        testFridge.addIngredient(ingredient7);
    }

    @Test
    void testAddSixItems() {
        testFridge.addIngredient(ingredient1);
        testFridge.addIngredient(ingredient2);
        testFridge.addIngredient(ingredient3);
        testFridge.addIngredient(ingredient4);
        testFridge.addIngredient(ingredient5);
        testFridge.addIngredient(ingredient6);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
        assertTrue(testFridge.getIngredients().contains(ingredient2));
        assertTrue(testFridge.getIngredients().contains(ingredient3));
        assertTrue(testFridge.getIngredients().contains(ingredient4));
        assertTrue(testFridge.getIngredients().contains(ingredient5));
        assertTrue(testFridge.getIngredients().contains(ingredient6));
    }

    // TODO: correct test?
    @Test
    void testGetIngredients() {
        testFridge.addIngredient(ingredient1);
        testFridge.addIngredient(ingredient2);
        testFridge.addIngredient(ingredient3);
        assertEquals(testFridge, testFridge.getIngredients());
    }

    @Test
    void testReduceIngredientOnce() {
        testFridge.addIngredient(ingredient1);
        testFridge.removeOrReduceIngredient(ingredient1, 50);
        assertEquals(950, testFridge.getIngredients());
    }

    @Test
    void testReduceOneIngredientTwice() {
        testFridge.addIngredient(ingredient2);
        testFridge.removeOrReduceIngredient(ingredient2, 50);
        assertEquals(450, testFridge.getIngredients());
        testFridge.removeOrReduceIngredient(ingredient2, 100);
        assertEquals(350, testFridge.getIngredients());
    }

    // TODO: how to test for reduction of ingredient
    @Test
    void testReduceTwoIngredientOnce() {
        testFridge.addIngredient(ingredient1);
        testFridge.addIngredient(ingredient2);
        testFridge.removeOrReduceIngredient(ingredient1, 200);
        assertEquals(800, testFridge.getIngredients());
        testFridge.removeOrReduceIngredient(ingredient2, 200);
        assertEquals(300, testFridge.getIngredients());
    }

    @Test
    void testRemoveOneIngredientEntirely() {
        testFridge.addIngredient(ingredient2);
        assertEquals(ingredient2, testFridge.getIngredients());
        testFridge.removeOrReduceIngredient(ingredient2, 500);
        assertFalse(testFridge.containIngredient(ingredient2));
    }

    @Test
    void testContainsIngredient() {
        testFridge.addIngredient(ingredient5);
        assertTrue(testFridge.containIngredient(ingredient5));
    }

    @Test
    void testContainsIngredientInLongList() {
        testFridge.addIngredient(ingredient3);
        testFridge.addIngredient(ingredient4);
        assertTrue(testFridge.containIngredient(ingredient3));
        assertFalse(testFridge.containIngredient(ingredient1));
    }

    @Test
    void testCheckEmpty() {
        testFridge.addIngredient(ingredient4);
        assertFalse(testFridge.checkIsEmpty());
    }

    @Test
    void testCheckEmpty1() {
        assertTrue(testFridge.checkIsEmpty());
    }

}
