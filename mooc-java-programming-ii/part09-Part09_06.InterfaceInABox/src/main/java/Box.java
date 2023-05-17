
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
public class Box implements Packable {

    private ArrayList<Packable> box;
    private double capacity;

    public Box(double capacity) {
        this.box = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Packable item) {
        if (this.weight() + item.weight() <= this.capacity) {
            this.box.add(item);
        }
    }

    public double weight() {
        double sum = 0.0;
        if (!box.isEmpty()) {
            for (Packable item : box) {
                sum = sum + item.weight();
            }
        }
        return sum;
    }

    public String toString() {
        return "Box: " + this.box.size() + " items, total weight " + this.weight() + " kg";
    }
}
