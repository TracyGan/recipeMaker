package ui;

//import jdk.swing.interop.SwingInterOpUtils;
//import model.Fridge;
//import model.Ingredient;
//import model.Recipe;
//import model.RecipeBook;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import java.util.Scanner; // user input
//
//// Recipe maker application
//public class RecipeApp {
//    private Fridge fridge;
//    private RecipeBook recipes;
//    private Scanner input;
//
//
//    public RecipeApp() {
//        boolean keepGoing = true;
//        String command = null;
//
//        init();
//
//        while (keepGoing) {
//            displayMenu();
//            command =input.next();
//            command = command.toLowerCase();
//
//            if (command.equals("E")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nGoodbye! See you next time! ");
//    }
//
//
//    private void processCommand(String command) {
//        if (command.equals("A")) {
//            findVegetarian();
//        } else if (command.equals("B")) {
//            findVegan();
//        } else if (command.equals("C")) {
//            findPescatarian();
//        } else if (command.equals("D")) {
//            findOmnivores();
//        } else {
//            System.out.println("Selection is not valid! ");
//        }
//    }
//
//    private void init() {
//
//    }
//
//    // EFFECTS: displays menu of options to user
//    private void displayMenu() {
//        System.out.println("\n Select from: ");
//        System.out.println("\t A -> Vegetarian");
//        System.out.println("\t B -> Vegan");
//        System.out.println("\t C -> Pescatarian");
//        System.out.println("\t D -> Omnivores");
//        System.out.println("\t E -> Quit");
//    }
//
//    private void findVegetarian() {
//        Recipe selected = selectRecipe();
//        System.out.println("Enter ingredients you have: ");
//        String ingredient = input.nextLine();
//
//    }
//
//    private void findVegan() {
//
//    }
//
//    private void findPescatarian() {
//
//    }
//
//    private void findOmnivores() {
//
//    }
//
//    private Recipe selectRecipe() {
//        String selection = "";
//
//    }
//}
