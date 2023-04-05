package persistence;

import model.Ingredient;
import model.Fridge;
import model.Unit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads fridge from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads fridge from file and returns it
    public Fridge read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFridge(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses fridge from JSON object and returns it
    public Fridge parseFridge(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Fridge fr = new Fridge(name);
        addIngredients(fr, jsonObject);
        return fr;
    }

    // MODIFIES: this
    // EFFECTS: parses Ingredients from JSON object and adds them to fridge
    private void addIngredients(Fridge fr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Ingredients");
        for (Object json : jsonArray) {
            JSONObject nextIngredient = (JSONObject) json;
            addIngredient(fr, nextIngredient);
        }
    }

    // MODIFIES: this
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addIngredient(Fridge fr, JSONObject jsonObject) {
        String name = jsonObject.getString("Name");
        double quantity = jsonObject.getDouble("Quantity");
        Unit unit = Unit.valueOf(jsonObject.getString("Unit"));
        Ingredient i = new Ingredient(name, quantity, unit);
        fr.addIngredient(i);
    }

}
