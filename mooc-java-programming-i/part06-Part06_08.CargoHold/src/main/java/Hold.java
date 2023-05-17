
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
public class Hold {

    private ArrayList<Suitcase> suitcases;
    private int maxWeight;

    public Hold(int maxWeight) {
        this.suitcases = new ArrayList<>();
        this.maxWeight = maxWeight;
    }

    public int totalWeight() {
        int currentWeight = 0;
        for (Suitcase suitcase : this.suitcases) {
            currentWeight = currentWeight + suitcase.totalWeight();
        }
        return currentWeight;
    }

    public void addSuitcase(Suitcase newSuitcase) {
        if (this.totalWeight() + newSuitcase.totalWeight() <= this.maxWeight) {
            this.suitcases.add(newSuitcase);
        }
    }

    public void printItems() {
        for (Suitcase suitcase : this.suitcases) {
            suitcase.printItems();
        }
    }

    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }
        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.suitcases.get(0).totalWeight() + " kg)";
        }
        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}
