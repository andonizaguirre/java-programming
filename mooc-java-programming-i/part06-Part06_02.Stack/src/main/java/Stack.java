
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
public class Stack {

    private ArrayList<String> values;

    public Stack() {
        this.values = new ArrayList<>();
    }

    public boolean isEmpty() {
        if (this.values.size() == 0) {
            return true;
        }
        // return this.values.isEmpty();
        return false;
    }

    public void add(String value) {
        this.values.add(value);
    }

    public ArrayList<String> values() {
        ArrayList<String> clone = this.values;
        return clone;
    }

    public String take() {
        return this.values.remove(this.values.size() - 1);
    }
}
