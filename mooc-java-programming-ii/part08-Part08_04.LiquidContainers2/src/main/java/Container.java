/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Container {

    private int amount;

    public void Container() {
        this.amount = amount;
    }

    public int contains() {
        return this.amount;
    }

    public void add(int amountAdded) {
        if (this.amount + amountAdded <= 100 && amountAdded > 0) {
            this.amount = this.amount + amountAdded;
        } else {
//            amountAdded = 100 - this.amount;
//            this.amount = this.amount + amountAdded;
            this.amount = 100;
        }
    }

    public void remove(int amountRemoved) {
        if (amountRemoved <= this.amount) {
            this.amount = this.amount - amountRemoved;
        } else {
//            amountRemoved = this.amount;
//            this.amount = this.amount - amountRemoved;
            this.amount = 0;
        }
    }

    public String toString() {
        return this.amount + "/100";
    }
}
