package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

// Recipe maker application
public class RecipeApp {
    private Fridge fridge;
    private Scanner input;
    private Ingredient i1;
    private Ingredient i2;
    private Ingredient i3;
    private Ingredient i4;
    private Ingredient i5;
    private Ingredient i6;
    private Ingredient i7;
    private Ingredient i8;
    private Ingredient i9;
    private Ingredient i10;
    private Ingredient i11;
    private Ingredient i12;
    private Ingredient i13;
    private Ingredient i14;
    private Ingredient i15;
    private Ingredient i16;
    private Ingredient i17;
    private Ingredient i18;
    private Ingredient i19;
    private Ingredient i20;
    private Ingredient i21;
    private Ingredient i22;
    private Ingredient i23;
    private Ingredient i24;
    private Ingredient i25;
    private Recipe rPesc;
    private Recipe rVeg;
    private Recipe rVegan;
    private Recipe rOmni;

    public RecipeApp() {
        runRecipe();
    }

    private void runRecipe() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

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
            findVegetarian();
        } else if (command.equals("B")) {
            findVegan();
        } else if (command.equals("C")) {
            findPescatarian();
        } else if (command.equals("D")) {
            findOmnivores();
        } else {
            System.out.println("Selection is not valid! ");
        }
    }

    private void init() {
        fridge = new Fridge();
        i1 = new Ingredient("rice", 1000, Unit.g);
        i2 = new Ingredient("kimchi", 500, Unit.g);
        i3 = new Ingredient ("egg", 10, Unit.whole);
        i4 = new Ingredient("garlic", 1, Unit.whole);
        i5 = new Ingredient("sesame seed", 100, Unit.g);
        i6 = new Ingredient("olive oil", 2000, Unit.ml);
        i7 = new Ingredient("onion", 5, Unit.whole);
        i8 = new Ingredient("carrot", 1, Unit.whole);
        i9 = new Ingredient("peas", 200, Unit.g);
        i10 = new Ingredient("pineapple", 1, Unit.cups);
        i11 = new Ingredient("cashews", 0.5, Unit.cups);
        i12 = new Ingredient("soy sauce", 2, Unit.tbsp);
        i13= new Ingredient("curry powder", 2, Unit.tbsp);
        i14 = new Ingredient("cilantro", 0.5, Unit.whole);
        i15 = new Ingredient("tomato", 3, Unit.whole);
        i16 = new Ingredient("lentil", 100, Unit.g);
        i17 = new Ingredient("mushroom", 15, Unit.whole);
        i18 = new Ingredient("panko", 200, Unit.g);
        i19 = new Ingredient("italian seasoning", 4, Unit.tsp);
        i20 = new Ingredient("parmesan cheese", 100, Unit.g);
        i21 = new Ingredient("basil", 2, Unit.whole);
        i22 = new Ingredient("raw beef", 1, Unit.whole);
        i23 = new Ingredient("honey", 1, Unit.tbsp);
        i24 = new Ingredient("ginger", 1, Unit.whole);
        i25 = new Ingredient("chili", 3, Unit.whole);
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

        rPesc = new Recipe(1, "kimchi fried rice", 'C', 3,ingredientList1);
        rVegan = new Recipe(2, "pineapple vegan fried rice",
                'B', 5,ingredientList2);
        rVeg = new Recipe(3, "vegetarian meatballs",
                'A', 5, ingredientList3);
        rOmni = new Recipe(4, "ginger beef stir fry",
                'D', 2, ingredientList4);
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
    }

    // TODO: How to loop 'Do you want to enter ingredients:'
    // ans can be either yes or no
    // TODO: if yes, then allows you to enter ingredients
    // if no, then finds a vegetarian recipe. if there is one, then prints recipe
    // if not then prints "No recipe available with ingredients in fridge!"
    private void findVegetarian() {
        Recipe selected = selectRecipe();
        System.out.println("Do you want to enter ingredients?");
        System.out.println("A -> Yes");
        System.out.println("B -> No");
        System.out.println("C -> Quit");
        String ingredient = input.nextLine();


        printRecipe(selected);
    }

    private void findVegan() {
        Recipe selected = selectRecipe();

    }

    private void findPescatarian() {

    }

    private void findOmnivores() {

    }


    // EFFECTS: prompts user to select vegetarian, vegan, pescatarian or omnivores and return it
    private Recipe selectRecipe() {
        String selection = ""; // force entry into loop

        while (!(selection.equals("A") || (selection.equals("B") ||
                (selection.equals("D") || (selection.equals("E")))))) {
            System.out.println("A for Vegetarian");
            System.out.println("B for Vegan");
            System.out.println("C for Pescatrian");
            System.out.println("D for Omnivores");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("A")) {
            return rVeg;
        } else if (selection.equals("B")) {
            return rVegan;
        } else if (selection.equals("C")) {
            return rpesc;
        } else if (selection.equals("D")) {
            return rOmni;
        }


        private void printRecipe (Recipe selected){
            System.out.println("Recipes available: ", selected.giveRecipe());
        }
    }

        public void endProgram() {
            System.out.println("Quitting...");
            input.close();
        }
}
