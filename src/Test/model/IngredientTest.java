package ca.ubc.cpsc210.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import model.Ingredient;

public class IngredientTest {
    private Ingredient testIngredients;

    @BeforeEach
    void setUp() {
        testIngredients = new Ingredient("Raw Chicken", 500);
    }

    @Test
    void testConstructor() {
        assertEquals("Raw chicken", testIngredients.getItem());
        assertEquals(500, testIngredients.getQuantity());
    }


    @Test
    void testGetItem() {
        testIngredients = new Ingredient("Eggs", 1000);
        assertEquals("Eggs", testIngredients.getItem());
    }

    @Test
    void testAddOnceQuantity() {
        testIngredients = new Ingredient("Tomatoes", 400);
        assertEquals(400, testIngredients.getQuantity());
        testIngredients.addQuantity(52.5);
        assertEquals(452.5, testIngredients.getQuantity());
    }

    @Test
    void testAddTwiceQuantity() {
        testIngredients.addQuantity(28.92);
        assertEquals(528.92, testIngredients.getQuantity());
        testIngredients.addQuantity(51);
        assertEquals(579.92, testIngredients.getQuantity());
    }

    @Test
    void testAddOnceQuantityAtBound() {
        testIngredients.addQuantity(0);
        assertEquals(500, testIngredients.getQuantity());
    }

    @Test
    void testAddOnceQuantityAboveBound() {
        testIngredients.addQuantity(0.1);
        assertEquals(500.1, testIngredients.getQuantity());
    }

    @Test
    void testRemoveQuantity() {
        testIngredients.reduceQuantity(100.0);
        assertEquals(400.0, testIngredients.getQuantity());
    }

    @Test
    void testRemoveQuantityDecimal() {
        testIngredients.reduceQuantity(51.8);
        assertEquals(448.2, testIngredients.getQuantity());
    }

    @Test
    void testRemoveOnceQuantityAtBound() {
        testIngredients.reduceQuantity(0);
        assertEquals(500, testIngredients.getQuantity());
    }

    @Test
    void testRemoveOnceQuantityAboveBound() {
        testIngredients.reduceQuantity(0.05);
        assertEquals(499.95, testIngredients.getQuantity());
    }

    @Test
    void testAddAndRemoveQuantity() {
        testIngredients.addQuantity(200);
        assertEquals(700, testIngredients.getQuantity());
        testIngredients.reduceQuantity(100);
        assertEquals(600, testIngredients.getQuantity());
    }


    @Test
    void testUpdateAfterAdding() {
        testIngredients = new Ingredient("Kimchi", 1200);
        testIngredients.addQuantity(50);
        assertTrue(testIngredients.updateIngredients().contains(" item = Kimchi, quantity = 1250"));
    }

    @Test
    void testUpdateAfterRemoving() {
        testIngredients.reduceQuantity(100);
        assertTrue(testIngredients.updateIngredients().contains(" item = Raw Chicken, quantity = 400"));
    }

    @Test
    void testUpdateWithoutChanging() {
        assertTrue(testIngredients.updateIngredients().contains(" item = Raw Chicken, quantity = 500"));
    }
}
