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
    private Ingredient ingredient8;
    private ArrayList<Ingredient> intList;

    @BeforeEach
    void setUp() {
        testFridge = new Fridge("Tracy");
        ingredient1 = new Ingredient("rice", 1000, Unit.g);
        ingredient2 = new Ingredient("kimchi", 500, Unit.g);
        ingredient3 = new Ingredient ("egg", 10, Unit.whole);
        ingredient4 = new Ingredient("garlic", 10, Unit.whole);
        ingredient5 = new Ingredient("sesame seed", 100, Unit.g);
        ingredient6 = new Ingredient("olive oil", 2000, Unit.ml);
        ingredient7 = new Ingredient("rice", 200, Unit.g);
        ingredient8 = new Ingredient("rice", 1200, Unit.g);
    }

    @Test
    void testConstructor() {
        assertTrue(testFridge.checkIsEmpty());
    }

    @Test
    void testAddOneItem() {
        testFridge.addIngredient(ingredient1);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
        assertEquals(1, testFridge.getSize());
    }

    @Test
    void testAddTwoItems() {
        testFridge.addIngredient(ingredient1);
        testFridge.addIngredient(ingredient2);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
        assertTrue(testFridge.getIngredients().contains(ingredient2));
    }

    @Test
    void testAddOneIngredientTwice() {
        testFridge.addIngredient(ingredient1);
        assertTrue(testFridge.getIngredients().contains(ingredient1));
        testFridge.addIngredient(ingredient7);
        assertEquals(1, testFridge.getSize());
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


    @Test
    void testReduceIngredientOnce() {
        testFridge.addIngredient(ingredient1);
        testFridge.removeOrReduceIngredient(ingredient1, 50);
        assertEquals(950, testFridge.getIngredientAmount(ingredient1));
    }

    @Test
    void testReduceOneIngredientTwice() {
        testFridge.addIngredient(ingredient2);
        testFridge.removeOrReduceIngredient(ingredient2, 50);
        assertEquals(450, testFridge.getIngredientAmount(ingredient2));
        testFridge.removeOrReduceIngredient(ingredient2, 100);
        assertEquals(350, testFridge.getIngredientAmount(ingredient2));
    }

    @Test
    void testReduceTwoIngredientOnce() {
        testFridge.addIngredient(ingredient1);
        testFridge.addIngredient(ingredient2);
        testFridge.removeOrReduceIngredient(ingredient1, 200);
        assertEquals(800, testFridge.getIngredientAmount(ingredient1));
        testFridge.removeOrReduceIngredient(ingredient2, 200);
        assertEquals(300, testFridge.getIngredientAmount(ingredient2));
    }

    @Test
    void testRemoveOneIngredientEntirely() {
        testFridge.addIngredient(ingredient2);
        assertTrue(testFridge.getIngredients().contains(ingredient2));
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
        //assertTrue(testFridge.containIngredient(ingredient3));
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

    @Test
    void testGetIngredient() {
        testFridge.addIngredient(ingredient4);
        assertEquals(ingredient4, testFridge.getIngredient("garlic"));
    }

    @Test
    void testGetIngredient1() {
        testFridge.addIngredient(ingredient4);
        assertEquals(null, testFridge.getIngredient("rice"));
    }

    @Test
    void testGetZeroSize() {
        assertEquals(0, testFridge.getSize());
    }

    @Test
    void testGetOneSize() {
        testFridge.addIngredient(ingredient5);
        assertEquals(1, testFridge.getSize());
    }

    @Test
    void testGetMoreOneSize() {
        testFridge.addIngredient(ingredient5);
        testFridge.addIngredient(ingredient6);
        testFridge.addIngredient(ingredient7);
        testFridge.addIngredient(ingredient8);
        assertEquals(3, testFridge.getSize());
    }

    @Test
    void testGetItem() {
        testFridge.addIngredient(ingredient5);
        assertEquals(ingredient5, testFridge.getItem(0));
    }


}
