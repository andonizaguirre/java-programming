
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Recipe {

    private String name;
    private int time;
    private ArrayList<String> ingredients;

    public Recipe(String name, int time) {
        this.name = name;
        this.time = time;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTime() {
        return this.time;
    }

    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public String toString() {
        return this.name + ", cooking time: " + this.time;
    }
}
