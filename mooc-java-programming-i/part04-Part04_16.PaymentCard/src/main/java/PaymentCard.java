/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class PaymentCard {

    private double balance;
//    private final double affordable;
//    private final double hearty;

    public PaymentCard(double openingBalance) {
        this.balance = openingBalance;
//        this.affordable = 2.6;
//        this.hearty = 4.6;
    }

    public void eatAffordably() {
        // write code here
        if (this.balance >= 2.6) {
            this.balance -= 2.6;
        }
//        if (this.balance >= affordable) {
//            this.balance -= affordable;
//        }
    }

    public void eatHeartily() {
        // write code here
        if (this.balance >= 4.6) {
            this.balance -= 4.6;
        }
//        if (this.balance >= hearty) {
//            this.balance -= hearty;
//        }
    }

    public void addMoney(double amount) {
        // write code here
        if (amount > 0 && this.balance + amount <= 150) {
            this.balance += amount;
        } else if (amount > 0) {
            this.balance = 150;
        }
//        if (amount < 0) {
//            return;
//        }
//        this.balance += amount;
//        if (this.balance > 150) {
//            this.balance = 150;
//        }
    }

    public String toString() {
        return "The card has a balance of " + this.balance + " euros";
    }
}
