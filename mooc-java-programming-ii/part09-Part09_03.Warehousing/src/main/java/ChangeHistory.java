
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
public class ChangeHistory {

    private ArrayList<Double> inventory;

    public ChangeHistory() {
        this.inventory = new ArrayList<>();
    }

    public void add(double status) {
        this.inventory.add(status);
    }

    public void clear() {
        this.inventory.clear();
    }

    public double maxValue() {
        double maxValue = this.inventory.get(0);
        if (!this.inventory.isEmpty()) {
            for (double status : this.inventory) {
                if (maxValue < status) {
                    maxValue = status;
                }
            }
        } else {
            maxValue = 0;
        }
        return maxValue;
    }

    public double minValue() {
        double minValue = this.inventory.get(0);
        if (!this.inventory.isEmpty()) {
            for (double status : this.inventory) {
                if (status < minValue) {
                    minValue = status;
                }
            }
        } else {
            minValue = 0;
        }
        return minValue;
    }

    public double average() {
        double sum = 0;
        for (double status : this.inventory) {
            sum = sum + status;
        }
        return sum / this.inventory.size();
    }

    public String toString() {
        return this.inventory.toString();
    }
}
