package ui;

import model.EventLog;
import model.Fridge;
import model.Ingredient;
import model.Unit;
import model.exception.LogException;
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
    private JTextField f1;
    private JTextField f2;
    private JTextField f3;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private JButton saveButton;
    private JButton cancelButton;
    private FridgeUi fridgeUi;
    private static final String JSON_STORE = "./data/fridge.json";
    private Image image;

    public RecipeAppGUI() {
        createObjects();
        setContentPane(desktop);
        setTitle("Recipe Maker");
        setSize(WIDTH, HEIGHT);

        addButtonPanel();
        setScreen();
        desktop.add(controlPanel);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ScreenPrinter screenPrinter = new ScreenPrinter();
                    screenPrinter.printLog(EventLog.getInstance());
                } catch (LogException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    // EFFECTS: creates multiple new Objects
    public void createObjects() {
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel Functions", true,
                false, false, false);
        controlPanel.setLayout(new BorderLayout());
        frame = new JFrame("Change Ingredient");
        fridgeUi = new FridgeUi(new Fridge("Tracy's fridge"));
        new JsonWriter(JSON_STORE);
        new JsonReader(JSON_STORE);
        image = new Image();
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
    public void createPage() {
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
        frame.add(f1);
        frame.add(f2);
        frame.add(f3);
        frame.add(item);
        frame.add(amt);
        frame.add(unit);
        frame.add(label);
        frame.add(saveButton);
        frame.add(cancelButton);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // MODIFIES: frame1
    // EFFECTS: next action after pressing the Increase Ingredient button
    public void increaseIngredient() {
        createPage();
        cleanUp();
        saveButton.addActionListener(e -> {
            String ingredient = f1.getText();
            double amount = Double.parseDouble(f2.getText());
            Unit unit = Unit.valueOf(f3.getText());
            fridgeUi.getFridgeUI().addIngredient(new Ingredient(ingredient, amount, unit));
            f1.setText("");
            f2.setText("");
            f3.setText("");
            frame.dispose();
            image.addImage();
        });
        cancelButton.addActionListener(e -> frame.dispose());
    }

    // MODIFIES: saveButton
    // EFFECTS: removes all action listeners
    private void cleanUp() {
        for (ActionListener al : saveButton.getActionListeners())  {
            saveButton.removeActionListener(al);
        }
    }

    // MODIFIES: frame1
    // EFFECTS: next action after pressing the Decrease Ingredient button
    public void decreaseIngredient() {
        createPage();
        cleanUp();
        saveButton.addActionListener(e -> {
            String ingredient = f1.getText();
            double amount = Double.parseDouble(f2.getText());
            Unit unit = Unit.valueOf(f3.getText());
            fridgeUi.getFridgeUI().removeOrReduceIngredient(new Ingredient(ingredient, amount, unit), amount);
            f1.setText("");
            f2.setText("");
            f3.setText("");
            frame.dispose();
            image.addImage();
        });

        cancelButton.addActionListener(e -> frame.dispose());
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
            super("Print fridge");
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
    // EFFECTS: focus given to a component
    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            RecipeAppGUI.this.requestFocusInWindow();
        }
    }
}
