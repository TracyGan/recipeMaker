package ui;

import model.Fridge;
import model.Ingredient;
import model.Unit;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RecipeAppGUI extends JFrame {

    private JList<Ingredient> ingredientList;
    private DefaultListModel<Ingredient> model;
    private JLabel label;
    private JLabel item;
    private JLabel amt;
    private JLabel unit;
    private JPanel panel;
    private JSplitPane splitPane;
    private JScrollPane scroll;
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
    private JButton cancelButton;
    private SaveActionListener saveActionListener;
    private CancelActionListener cancelActionListener;

    public RecipeAppGUI() {
        fridge = new Fridge("Tracy's fridge");
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        desktop = new JDesktopPane();
        saveActionListener = new SaveActionListener();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel Functions", true,
                false, false, false);
        controlPanel.setLayout(new BorderLayout());
        frame1 = new JFrame( " ingredient");

        setContentPane(desktop);
        setTitle("Recipe Maker");
        setSize(WIDTH, HEIGHT);
        setBackground(Color.PINK);

        addButtonPanel();
        addFridge();

        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);
    }

    public void addFridge() {
        ingredientList = new JList<>();
        panel = new JPanel();
        label = new JLabel();
        model = new DefaultListModel<>();
        splitPane = new JSplitPane();
        ingredientList.setModel(model);

        model.addElement(new Ingredient("Apple", 5, Unit.whole));
        model.addElement(new Ingredient("Egg", 20, Unit.whole));
        model.addElement(new Ingredient("Orange", 5, Unit.whole));

        ingredientList.getSelectionModel().addListSelectionListener(e -> {
            Ingredient i = ingredientList.getSelectedValue();
            label.setText("Ingredient: " + i.getItem() + " : " + i.getQuantity());
        });

        splitPane.setLeftComponent(new JScrollPane(ingredientList));
        panel.add(label);
        splitPane.setRightComponent(panel);

        desktop.add(splitPane);
        desktop.setVisible(true);
        centreOnScreen();
    }

    public void addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(new JButton(new AddIngredient()));
        buttonPanel.add(new JButton(new ReduceIngredient()));
        buttonPanel.add(new JButton(new SaveFridge()));
        buttonPanel.add(new JButton(new PrintFridge()));

        controlPanel.add(buttonPanel, BorderLayout.WEST);
    }

    private class AddIngredient extends AbstractAction {
        AddIngredient() {
            super("Add Ingredient");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            increaseIngredient();
        }
    }

    private class ReduceIngredient extends AbstractAction {
        ReduceIngredient() {
            super("Reduce Ingredient");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            decreaseIngredient();
        }
    }

    // TODO: is it okay if this methods length exceeds max
    public void createPage(String s, String s1) {
        setBackground(Color.PINK);
        f1 = new JTextField();
        item = new JLabel("Ingredient : ");
        f1.setBounds(90, 100, 200, 30);
        item.setBounds(20, 100, 100, 30);
        f2 = new JTextField();
        amt = new JLabel("Amount : ");
        f2.setBounds(90, 150, 200, 30);
        amt.setBounds(20, 150, 100, 30);
        f3 = new JTextField();
        unit = new JLabel("Unit : ");
        f3.setBounds(90, 230, 200, 30);
        unit.setBounds(20, 230, 50, 30);
        label = new JLabel("g / ml / cups / tsp / tbsp / whole");
        label.setBounds(50, 200, 250, 30);
        saveButton.setBounds(20, 270, 150, 30);
        cancelButton.setBounds(200, 270,150, 30);
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


    public void increaseIngredient() {
        createPage("Adding", "Add");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ingredient = f1.getText();
                double amount = Double.parseDouble(f2.getText());
                Unit unit = Unit.valueOf(f3.getText());
                fridge.addIngredient(new Ingredient(ingredient, amount, unit));
            }
        });
        //TODO: i want to close the createPage window not this
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
            }
        });
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


    public void decreaseIngredient() {
        createPage("Reducing", "Reduce");
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String ingredient = f1.getText();
                double amount = Double.parseDouble(f2.getText());
                Unit unit = Unit.valueOf(f3.getText());
                fridge.removeOrReduceIngredient(new Ingredient(ingredient, amount, unit), amount);
            }
        });
    }

    // TODO: do i need to implement a json into save fridge
    private class SaveFridge extends AbstractAction {
        SaveFridge() {
            super("Save fridge to file");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            frame = new JFrame("save");
        }
    }

    private class PrintFridge extends AbstractAction {
        PrintFridge() {
            super("Print fridge from file");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            frame = new JFrame();
//            for (int i = 0; i < fridge.getSize(); i++) {
//                System.out.println(fridge.getItem(i).returnIngredient());
//                createFridge();
//            }
            createFridge();
        }
    }

    public void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);

    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }

    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            RecipeAppGUI.this.requestFocusInWindow();
        }
    }

    // TODO: how to save all the ingredients in my fridge to my JLIST together
    private void createFridge() {
        frame = new JFrame("Fridge");
        ingredientList = new JList<>();
        model = new DefaultListModel<>();

        label = new JLabel();
        panel = new JPanel();
        splitPane = new JSplitPane();

        ingredientList.setModel(model);

        model.addElement(new Ingredient("Rice", 500, Unit.g));
// for loop -> iterate over all ingredients of fridge and call model.addElement

        splitPane.setLeftComponent(new JScrollPane(ingredientList));

        panel.add(label);
        splitPane.setRightComponent(panel);

        ingredientList.getSelectionModel().addListSelectionListener(e -> {
            Ingredient i = this.ingredientList.getSelectedValue();
            label.setText("Ingredient : " + i.getItem() + " , Amount : " + i.getQuantity() + i.getUnit());
        });
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(WIDTH, HEIGHT);
    }


}
