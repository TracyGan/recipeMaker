package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

// Recipe maker application
public class RecipeApp {
    private Fridge fridge;
    private Scanner input;
    private Recipe repPesc;
    private Recipe repVeg;
    private Recipe repVegan;
    private Recipe repOmni;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/fridge.json";

    // EFFECTS: constructs fridge and runs the recipe application
    public RecipeApp() {
        input = new Scanner(System.in);
        fridge = new Fridge("Tracy's fridge");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runRecipe();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runRecipe() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            command = command.toUpperCase();

            if (command.equals("E")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye! See you next time! ");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("A")) {
            findVegetarian("A");
        } else if (command.equals("B")) {
            findVegan("B");
        } else if (command.equals("C")) {
            findPescatarian("C");
        } else if (command.equals("D")) {
            findOmnivores("D");
        } else if (command.equals("F")) {
            printFridge();
        } else if (command.equals("G")) {
            saveFridge();
        } else if (command.equals("H")) {
            loadFridge();
        } else {
            System.out.println("Selection is not valid! ");
        }
    }

    @SuppressWarnings("methodlength")
    private void init() {
        Ingredient i1 = new Ingredient("rice", 1000, Unit.g);
        Ingredient i2 = new Ingredient("kimchi", 500, Unit.g);
        Ingredient i3 = new Ingredient("egg", 10, Unit.whole);
        Ingredient i4 = new Ingredient("garlic", 1, Unit.whole);
        Ingredient i5 = new Ingredient("sesame seed", 100, Unit.g);
        Ingredient i6 = new Ingredient("olive oil", 2000, Unit.ml);
        Ingredient i7 = new Ingredient("onion", 5, Unit.whole);
        Ingredient i8 = new Ingredient("carrot", 1, Unit.whole);
        Ingredient i9 = new Ingredient("peas", 200, Unit.g);
        Ingredient i10 = new Ingredient("pineapple", 1, Unit.cups);
        Ingredient i11 = new Ingredient("cashews", 0.5, Unit.cups);
        Ingredient i12 = new Ingredient("soy sauce", 2, Unit.tbsp);
        Ingredient i13 = new Ingredient("curry powder", 2, Unit.tbsp);
        Ingredient i14 = new Ingredient("cilantro", 0.5, Unit.whole);
        Ingredient i15 = new Ingredient("tomato", 3, Unit.whole);
        Ingredient i16 = new Ingredient("lentil", 100, Unit.g);
        Ingredient i17 = new Ingredient("mushroom", 15, Unit.whole);
        Ingredient i18 = new Ingredient("panko", 200, Unit.g);
        Ingredient i19 = new Ingredient("italian seasoning", 4, Unit.tsp);
        Ingredient i20 = new Ingredient("parmesan cheese", 100, Unit.g);
        Ingredient i21 = new Ingredient("basil", 2, Unit.whole);
        Ingredient i22 = new Ingredient("raw beef", 1, Unit.whole);
        Ingredient i23 = new Ingredient("honey", 1, Unit.tbsp);
        Ingredient i24 = new Ingredient("ginger", 1, Unit.whole);
        Ingredient i25 = new Ingredient("chili", 3, Unit.whole);
        fridge.addIngredient(i1);
        fridge.addIngredient(i2);
        fridge.addIngredient(i3);
        fridge.addIngredient(i4);
        fridge.addIngredient(i5);
        fridge.addIngredient(i6);
        fridge.addIngredient(i7);
        fridge.addIngredient(i8);
        fridge.addIngredient(i9);
        fridge.addIngredient(i10);
        fridge.addIngredient(i11);
        fridge.addIngredient(i12);
        fridge.addIngredient(i13);
        fridge.addIngredient(i14);
        fridge.addIngredient(i15);
        fridge.addIngredient(i16);
        fridge.addIngredient(i17);
        fridge.addIngredient(i18);
        fridge.addIngredient(i19);
        fridge.addIngredient(i20);
        fridge.addIngredient(i21);
        fridge.addIngredient(i22);
        fridge.addIngredient(i23);
        fridge.addIngredient(i24);
        fridge.addIngredient(i25);

        ArrayList<Ingredient> ingredientList1 = new ArrayList<>();
        ArrayList<Ingredient> ingredientList2 = new ArrayList<>();
        ArrayList<Ingredient> ingredientList3 = new ArrayList<>();
        ArrayList<Ingredient> ingredientList4 = new ArrayList<>();
        ingredientList1.add(i1);
        ingredientList1.add(i2);
        ingredientList1.add(i3);
        ingredientList1.add(i4);
        ingredientList1.add(i5);
        ingredientList1.add(i6);
        ingredientList2.add(i1);
        ingredientList2.add(i7);
        ingredientList2.add(i3);
        ingredientList2.add(i4);
        ingredientList2.add(i8);
        ingredientList2.add(i9);
        ingredientList2.add(i10);
        ingredientList2.add(i11);
        ingredientList2.add(i12);
        ingredientList2.add(i13);
        ingredientList2.add(i14);
        ingredientList3.add(i15);
        ingredientList3.add(i16);
        ingredientList3.add(i17);
        ingredientList3.add(i18);
        ingredientList3.add(i19);
        ingredientList3.add(i20);
        ingredientList3.add(i21);
        ingredientList3.add(i3);
        ingredientList3.add(i7);
        ingredientList4.add(i22);
        ingredientList4.add(i23);
        ingredientList4.add(i24);
        ingredientList4.add(i25);
        ingredientList4.add(i12);
        ingredientList4.add(i14);

        repPesc = new Recipe(1, "kimchi fried rice", 'C', 0, ingredientList1);
        repVegan = new Recipe(2, "pineapple vegan fried rice",
                'B', 0, ingredientList2);
        repVeg = new Recipe(3, "vegetarian meatballs",
                'A', 0, ingredientList3);
        repOmni = new Recipe(4, "ginger beef stir fry",
                'D', 0, ingredientList4);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n Select from: ");
        System.out.println("\t A -> Vegetarian");
        System.out.println("\t B -> Vegan");
        System.out.println("\t C -> Pescatarian");
        System.out.println("\t D -> Omnivores");
        System.out.println("\t E -> Quit");
        System.out.println("\t F -> Print Fridge");
        System.out.println("\t G -> Save fridge to file");
        System.out.println("\t H -> Load fridge from file");
    }

    // EFFECTS: saves the fridge to file
    private void saveFridge() {
        try {
            jsonWriter.open();
            jsonWriter.write(fridge);
            jsonWriter.close();
            System.out.println("Saved " + fridge.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads fridge from file
    private void loadFridge() {
        try {
            fridge = jsonReader.read();
            System.out.println("Loaded " + fridge.getName() + " from " + JSON_STORE);
            printFridge();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: returns a vegetarian recipe, after updating ingredients in fridge
    private void findVegetarian(String s) {
        findMethod(s);
        printRecipe(repVeg);
        askTried(repVeg);
    }

    // MODIFIES: this
    // EFFECTS: returns a vegan recipe, after updating ingredients in fridge
    private void findVegan(String s) {
        findMethod(s);
        printRecipe(repVegan);
        askTried(repVegan);
    }

    // MODIFIES: this
    // EFFECTS: returns a pescatarian recipe, after updating ingredients in fridge
    private void findPescatarian(String s) {
        findMethod(s);
        printRecipe(repPesc);
        askTried(repPesc);
    }

    // MODIFIES: this
    // EFFECTS: returns an omnivore recipe, after updating ingredients in fridge
    private void findOmnivores(String s) {
        findMethod(s);
        printRecipe(repOmni);
        askTried(repOmni);
    }

    // EFFECTS: prompts user to give rating of recipe if tried
    private void askTried(Recipe selected) {
        System.out.println("Have you tried this recipe?");
        System.out.println("A -> Yes");
        System.out.println("B -> No");
        String s = input.nextLine();
        if (Objects.equals(s, "A")) {
            System.out.println("Give your rating from 1-5 (1 horrible, 5 excellent)");
            int n = input.nextInt();
            input.nextLine();
            selected.increaseRating(n);
            printRecipe(selected);
        } else if (Objects.equals(s, "B")) {
            System.out.println("Try the recipe and rate it the next time!");
        } else {
            System.out.println("Invalid answer. Try again!");
        }
    }

    @SuppressWarnings("methodlength")
    // EFFECTS: prompts user to add or reduce ingredients available in fridge
    private void findMethod(String s) {
        Recipe rep = selectRecipe(s);
        while (!Objects.equals(s, "E")) {
            System.out.println("Do you want to enter ingredients?");
            System.out.println("A -> Yes");
            System.out.println("B -> No");
            System.out.println("E -> Quit");
            s = input.nextLine();
            if (Objects.equals(s, "A")) {
                System.out.println("Enter ingredient you want to add:");
                s = input.nextLine();
                System.out.println("Enter the amount of ingredient you want to add:");
                double n = input.nextDouble();
                System.out.println("Enter the units of ingredient you want to add:");
                Unit l = Unit.valueOf(input.next().toLowerCase());
                Ingredient i = new Ingredient(s, n, l);
                fridge.addIngredient(i);
                input.nextLine();
            }
            if (Objects.equals(s, "B")) {
                removeIngredient(rep);
                break;
            }
        }
    }



    @SuppressWarnings("methodlength")
    // MODIFIES: this
    // EFFECTS: reduces or removes an ingredient from fridge
    private void removeIngredient(Recipe selected) {
        String s = "";
        while (!Objects.equals(s, "E")) {
            System.out.println("Do you want to reduce ingredients?");
            System.out.println("A -> Yes");
            System.out.println("B -> No");
            System.out.println("C -> Quit");
            s = input.nextLine();
            if (Objects.equals(s, "A")) {
                System.out.println("Enter ingredient you want to reduce:");
                String i = input.nextLine();
                Ingredient in = fridge.getIngredient(i);
                System.out.println("Enter quantity of ingredient you want to reduce:");
                double amount = input.nextDouble();
                System.out.println("Enter the units of ingredient you want to remove:");
                Unit l = Unit.valueOf(input.next().toLowerCase());
                input.nextLine();
                if (amount < 0.0) {
                    System.out.println("Cannot reduce negative value...");
                    break;
                } else if (fridge.getIngredientAmount(in) < amount) {
                    System.out.println("Insufficient amount in fridge...");
                    break;
                } else {
                    fridge.removeOrReduceIngredient(in, amount);
                }
            }
            if (Objects.equals(s, "B")) {
                System.out.println(selected);
                printFridge();
                break;
            }
        }
    }

    private void printFridge() {
        System.out.println("Items in fridge:");
        for (int i = 0; i < fridge.getSize(); i++) {
            System.out.println(fridge.getItem(i).returnIngredient());
        }
    }


    // EFFECTS: prompts user to select vegetarian, vegan, pescatarian or omnivores and return it
    private Recipe selectRecipe(String selection) {

        while (!(selection.equals("A") || (selection.equals("B")
                || (selection.equals("C") || (selection.equals("D")))))) {
            System.out.println("A for Vegetarian");
            System.out.println("B for Vegan");
            System.out.println("C for Pescatrian");
            System.out.println("D for Omnivores");
            selection = input.nextLine();
            selection = selection.toUpperCase();
        }

        if (selection.equals("A")) {
            return repVeg;
        } else if (selection.equals("B")) {
            return repVegan;
        } else if (selection.equals("C")) {
            return repPesc;
        } else if (selection.equals("D")) {
            return repOmni;
        }
        return null;
    }

    // EFFECTS: returns the recipe that was selected
    private void printRecipe(Recipe selected) {
        System.out.println("Recipe available: " + selected.getRecipe());
    }
}
