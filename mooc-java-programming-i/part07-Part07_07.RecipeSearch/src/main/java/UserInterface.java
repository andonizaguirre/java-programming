
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class UserInterface {

    private Scanner scanner;
    private ArrayList<Recipe> recipes;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.recipes = new ArrayList<>();
    }

    public void start() {
        System.out.println("File to read: ");
        String file = this.scanner.nextLine();
        this.readFile(file);
        System.out.println("Commands:");
        System.out.println("list - list the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println("Enter command: ");
        String command = this.scanner.nextLine();
        this.processCommands(command);
    }

    private void readFile(String file) {
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String name = fileReader.nextLine();
                int time = Integer.valueOf(fileReader.nextLine());
                Recipe recipe = new Recipe(name, time);
                this.recipes.add(recipe);
                while (fileReader.hasNextLine()) {
                    String ingredient = fileReader.nextLine();
                    if (ingredient.isEmpty()) {
                        break;
                    }
                    recipe.addIngredient(ingredient);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void processCommands(String command) {
        if (command.equals("stop")) {
            return;
        } else if (command.equals("list")) {
            this.list();
        } else if (command.equals("find name")) {
            this.findByName();
        } else if (command.equals("find cooking time")) {
            this.findByMaxTime();
        } else if (command.equals("find ingredient")) {
            this.findBasedOnIngredient();
        }
    }

    private void list() {
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            System.out.println(recipe);
        }
    }

    private void findByName() {
        System.out.println("Searched word:");
        String word = this.scanner.nextLine();
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe);
            }
        }
    }

    private void findByMaxTime() {
        System.out.println("Max cooking time:");
        int maxTime = Integer.valueOf(this.scanner.nextLine());
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            if (recipe.getTime() <= maxTime) {
                System.out.println(recipe);
            }
        }
    }

    private void findBasedOnIngredient() {
        System.out.println("Ingredient:");
        String searchedIngredient = this.scanner.nextLine();
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            for (String ingredient : recipe.getIngredients()) {
                if (ingredient.equals(searchedIngredient)) {
                    System.out.println(recipe);
                }
            }
        }
    }
}
