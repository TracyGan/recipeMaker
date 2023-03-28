package ui;

import model.Fridge;
import model.Ingredient;
import model.Unit;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Represents a GUI for the RecipeApp
public class RecipeAppGUI extends JFrame {

    private JLabel label;
    private JLabel item;
    private JLabel amt;
    private JLabel unit;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;
    private JFrame frame;
    private JFrame frame1;
    private JTextField f1;
    private JTextField f2;
    private JTextField f3;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Fridge fridge;
    private JButton saveButton;
    private JButton saveButton1;
    private JButton cancelButton;
    private SaveActionListener saveActionListener;
    private CancelActionListener cancelActionListener;
    private FridgeUi fridgeUi;
    private static final String JSON_STORE = "./data/fridge.json";

    public RecipeAppGUI() {
        //fridge = new Fridge("Tracy's fridge");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        desktop = new JDesktopPane();
        saveActionListener = new SaveActionListener();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel Functions", true,
                false, false, false);
        controlPanel.setLayout(new BorderLayout());
        frame1 = new JFrame(" ingredient");
        fridgeUi = new FridgeUi(new Fridge("Tracy's fridge"));
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setContentPane(desktop);
        setTitle("Recipe Maker");
        setSize(WIDTH, HEIGHT);

        addButtonPanel();
        setScreen();
        desktop.add(controlPanel);
    }

    // EFFECTS: sets the controls of the screen
    public void setScreen() {
        controlPanel.pack();
        controlPanel.setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
    }

    // MODIFIES: controlPanel
    // EFFECTS: adds the panel of buttons
    public void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(new JButton(new AddIngredient()));
        buttonPanel.add(new JButton(new ReduceIngredient()));
        buttonPanel.add(new JButton(new SaveFridge()));
        buttonPanel.add(new JButton(new PrintFridge()));
        buttonPanel.add(new JButton(new LoadFridge()));

        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

    // Represents a class to load fridge from file
    private class LoadFridge extends AbstractAction {
        LoadFridge() {
            super("Load fridge from file");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fridgeUi.loadFridge();
        }
    }

    // Represents a class to add ingredients
    private class AddIngredient extends AbstractAction {
        AddIngredient() {
            super("Add Ingredient");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            increaseIngredient();
        }
    }

    // Represents a class to remove or reduce Ingredients
    private class ReduceIngredient extends AbstractAction {
        ReduceIngredient() {
            super("Reduce Ingredient");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            decreaseIngredient();
        }
    }

    // MODIFIES: this, f1, f2, f3, unit, label
    // EFFECTS: produces another JFrame containing information to change ingredients in Fridge
    public void createPage(String s, String s1) {
        setBackground(Color.PINK);
        if (f1 == null) {
            f1 = new JTextField();
        }
        item = new JLabel("Ingredient : ");
        if (f2 == null) {
            f2 = new JTextField();
        }
        amt = new JLabel("Amount : ");
        if (f3 == null) {
            f3 = new JTextField();
        }
        unit = new JLabel("Unit : ");
        label = new JLabel("g / ml / cups / tsp / tbsp / whole");
        setBounds();
        addObjectsIntoFrame();
    }

    // MODIFIES: f1, f2, f3, item, amt, unit, saveButton, cancelButton
    // EFFECTS: sets the bounds of buttons and text fields onto JFrame
    public void setBounds() {
        f1.setBounds(90, 100, 200, 30);
        item.setBounds(20, 100, 100, 30);
        f2.setBounds(90, 150, 200, 30);
        amt.setBounds(20, 150, 100, 30);
        f3.setBounds(90, 230, 200, 30);
        unit.setBounds(20, 230, 50, 30);
        label.setBounds(50, 200, 250, 30);
        saveButton.setBounds(20, 270, 150, 30);
        cancelButton.setBounds(200, 270,150, 30);

    }

    // MODIFIES: frame1
    // EFFECTS: places the buttons, labels, and text fields onto JFrame
    public void addObjectsIntoFrame() {
        frame1.add(f1);
        frame1.add(f2);
        frame1.add(f3);
        frame1.add(item);
        frame1.add(amt);
        frame1.add(unit);
        frame1.add(label);
        frame1.add(saveButton);
        frame1.add(cancelButton);
        frame1.setSize(400, 400);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }

    // MODIFIES: frame1
    // EFFECTS: next action after pressing the Increase Ingredient button
    public void increaseIngredient() {
        createPage("Adding", "Add");
        cleanUp();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ingredient = f1.getText();
                double amount = Double.parseDouble(f2.getText());
                Unit unit = Unit.valueOf(f3.getText());
                //fridge.addIngredient(new Ingredient(ingredient, amount, unit));
                fridgeUi.getFridgeUI().addIngredient(new Ingredient(ingredient, amount, unit));
                f1.setText("");
                f2.setText("");
                f3.setText("");
                frame1.dispose();
                Image image = new Image();
                image.addImage();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
            }
        });
    }

    // MODIFIES: saveButton
    // EFFECTS: removes all action listeners
    private void cleanUp() {
        for (ActionListener al : saveButton.getActionListeners())  {
            saveButton.removeActionListener(al);
        }
    }

    private class CancelActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Close window");
        }
    }

    private class SaveActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button has been clicked");
        }
    }

    // MODIFIES: frame1
    // EFFECTS: next action after pressing the Decrease Ingredient button
    public void decreaseIngredient() {
        createPage("Reducing", "Reduce");
        cleanUp();
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String ingredient = f1.getText();
                double amount = Double.parseDouble(f2.getText());
                Unit unit = Unit.valueOf(f3.getText());
                //fridge.removeOrReduceIngredient(new Ingredient(ingredient, amount, unit), amount);
                fridgeUi.getFridgeUI().removeOrReduceIngredient(new Ingredient(ingredient, amount, unit), amount);
                f1.setText("");
                f2.setText("");
                f3.setText("");
                frame1.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
            }
        });
    }

    // Represents a class to save fridge to file
    private class SaveFridge extends AbstractAction {
        SaveFridge() {
            super("Save fridge to file");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fridgeUi.saveFridge();
        }
    }

    // Represents a class to print fridge
    private class PrintFridge extends AbstractAction {
        PrintFridge() {
            super("Print fridge from file");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fridgeUi.printFridge();
        }
    }

    // EFFECTS: positions the JFrame in the middle of screen
    public void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);

    }

    // MODIFIES: this
    // EFFECTS:
    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            RecipeAppGUI.this.requestFocusInWindow();
        }
    }

}
