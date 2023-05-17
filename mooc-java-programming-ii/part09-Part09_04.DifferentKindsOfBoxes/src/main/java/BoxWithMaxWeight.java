
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
public class BoxWithMaxWeight extends Box {

    private ArrayList<Item> box;
    private int capacity;

    public BoxWithMaxWeight(int capacity) {
        this.box = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Item item) {
        if (this.getCurrentWeight() + item.getWeight() <= this.capacity) {
            this.box.add(item);
        }
    }

    private int getCurrentWeight() {
        int sum = 0;
        for (Item item : box) {
            sum = sum + item.getWeight();
        }
        return sum;
    }

    public boolean isInBox(Item item) {
        return this.box.contains(item);
    }
}
