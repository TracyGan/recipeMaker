package persistence;

import model.Ingredient;
import model.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkIngredient(String name, double quantity, Unit unit, Ingredient i) {
        assertEquals(name, i.getItem());
        assertEquals(quantity, i.getQuantity());
        assertEquals(unit, i.getUnit());
    }
}
