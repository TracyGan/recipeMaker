package persistence;

import model.Fridge;
import model.Ingredient;
import model.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.ArrayList;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Fridge fr = new Fridge("My fridge");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyFridge() {
        try {
            Fridge fr = new Fridge("My fridge");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFridge.json");
            writer.open();
            writer.write(fr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFridge.json");
            fr = reader.read();
            assertEquals("My fridge", fr.getName());
            assertEquals(0, fr.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralFridge() {
        try {
            Fridge fr = new Fridge("My fridge");
            fr.addIngredient(new Ingredient("rice", 5000, Unit.g));
            fr.addIngredient(new Ingredient("kimchi", 500, Unit.g));
            fr.addIngredient(new Ingredient("egg", 10, Unit.whole));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFridge.json");
            writer.open();
            writer.write(fr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFridge.json");
            fr = reader.read();
            assertEquals("My fridge", fr.getName());
            ArrayList<Ingredient> ingredients = fr.getIngredients();
            assertEquals(3, ingredients.size());
            checkIngredient("rice", 5000, Unit.g, ingredients.get(0));
            checkIngredient("kimchi", 500, Unit.g, ingredients.get(1));
            checkIngredient("egg", 10, Unit.whole, ingredients.get(2));

        } catch (IOException e) {
            fail("Exception should not have neen thrown!");
        }
    }
}
