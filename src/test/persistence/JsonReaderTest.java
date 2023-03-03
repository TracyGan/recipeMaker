package persistence;

import model.Fridge;
import model.Ingredient;
import model.Unit;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Fridge fr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFridge() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFridge.json");
        try {
            Fridge fr = reader.read();
            assertEquals("My fridge", fr.getName());
            assertEquals(0, fr.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralFridge() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFridge.json");
        try {
            Fridge fr = reader.read();
            assertEquals("My fridge",fr.getName());
            ArrayList<Ingredient> ingredients = fr.getIngredients();
            assertEquals(3, fr.getSize());
            checkIngredient("rice", 5000, Unit.g, ingredients.get(0));
            checkIngredient("kimchi", 500, Unit.g, ingredients.get(1));
            checkIngredient("egg", 10, Unit.whole, ingredients.get(2));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
