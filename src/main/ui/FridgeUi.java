package ui;

import model.Fridge;
import model.Ingredient;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;
import persistence.Writable;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents the UI of the fridge
public class FridgeUi implements Writable {
    private JList<Ingredient> ingredientList;
    private DefaultListModel<Ingredient> model;
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    private JSplitPane splitPane;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Fridge fridge;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/fridge.json";
    private String name;

    public FridgeUi(Fridge fr) {
        frame = new JFrame("Fridge");
        ingredientList = new JList<>();
        model = new DefaultListModel<>();
        fridge = fr;

        label = new JLabel();
        panel = new JPanel();
        splitPane = new JSplitPane();

        ingredientList.setModel(model);

        splitPane.setLeftComponent(new JScrollPane(ingredientList));

        panel.add(label);
        splitPane.setRightComponent(panel);
        name = fr.getName();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    // MODIFIES: jsonWriter
    // EFFECTS: saves the fridge to file
    public void saveFridge() {
        try {
            jsonWriter.open();
            jsonWriter.write(fridge);
            jsonWriter.close();
            System.out.println("Saved " + fridge.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: returns the fridge
    public Fridge getFridgeUI() {
        return fridge;
    }

    // MODIFIES: ingredientList, splitPane, panel
    // EFFECTS: renews a new model each time the fridge is to be printed out
    public void renewModel() {
        model = new DefaultListModel<>();
        ingredientList = new JList<>();
        label = new JLabel();
        panel = new JPanel();
        splitPane = new JSplitPane();
        ingredientList.setModel(model);
        splitPane.setLeftComponent(new JScrollPane(ingredientList));
        panel.add(label);
        splitPane.setRightComponent(panel);
    }

    // MODIFIES: this
    // EFFECTS: loads fridge from file
    public void loadFridge() {
        try {
            fridge = jsonReader.read();
            System.out.println("Loaded " + fridge.getName() + " from " + JSON_STORE);
            printFridge();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: model, this
    // EFFECTS: prints out the items of the fridge into two separate panels
    public void printFridge() {
        frame = new JFrame("Fridge");
        renewModel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
        for (Ingredient i : fridge.getIngredients()) {
            model.addElement(i);
            ingredientList.getSelectionModel().addListSelectionListener(e -> {
                Ingredient item = this.ingredientList.getSelectedValue();
                label.setText("Ingredient : " + item.getItem() + " , Amount : " + item.getQuantity() + item.getUnit());
            });
        }
    }

    // MODIFIES: json
    // EFFECTS: creates a JSON Object, relating to an ingredient
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Ingredients", ingredientsToJson());
        return json;
    }

    // MODIFIES: jsonArray
    // EFFECTS: adds the list of ingredients in the fridge to jsonArray
    private JSONArray ingredientsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Ingredient i : fridge.getIngredients()) {
            jsonArray.put(i.toJson());
        }
        return jsonArray;
    }
}
