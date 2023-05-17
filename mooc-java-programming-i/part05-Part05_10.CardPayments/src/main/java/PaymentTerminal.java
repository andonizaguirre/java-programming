
public class PaymentTerminal {

    private double money;  // amount of cash
    private int affordableMeals; // number of sold affordable meals
    private int heartyMeals;  // number of sold hearty meals
//    // This is how a constant is defined in Java
//    private static final double AFFORDABLE_PRICE = 2.5;
//    private static final double HEARTY_PRICE = 4.3;

    public PaymentTerminal() {
        // register initially has 1000 euros of money
        this.money = 1000;
        this.affordableMeals = 0;
        this.heartyMeals = 0;
    }

    public double eatAffordably(double payment) {
        // an affordable meal costs 2.50 euros
        // increase the amount of cash by the price of an affordable mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment >= 2.5) {
            this.money = this.money + 2.5;
            this.affordableMeals++;
            return payment - 2.5;
        }
        return payment;
//        if (payment < AFFORDABLE_PRICE) {
//            return payment;
//        } 
//        this.money += AFFORDABLE_PRICE;
//        this.affordableMeals++;
//        return payment - AFFORDABLE_PRICE;
    }

    public double eatHeartily(double payment) {
        // a hearty meal costs 4.30 euros
        // increase the amount of cash by the price of a hearty mean and return the change
        // if the payment parameter is not large enough, no meal is sold and the method should return the whole payment
        if (payment >= 4.3) {
            this.money = this.money + 4.3;
            this.heartyMeals++;
            return payment - 4.3;
        }
        return payment;
//        if (payment < HEARTY_PRICE) {
//            return payment;
//        }
//        this.money += HEARTY_PRICE;
//        this.heartyMeals++;
//        return payment - HEARTY_PRICE;
    }

    public boolean eatAffordably(PaymentCard card) {
        // an affordable meal costs 2.50 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
        if (card.takeMoney(2.5)) {
            this.affordableMeals++;
            return true;
        }
        return false;
//        if (card.balance() < AFFORDABLE_PRICE) {
//            return false;
//        }
//        card.takeMoney(AFFORDABLE_PRICE);
//        this.affordableMeals++;
//        return true;
    }

    public boolean eatHeartily(PaymentCard card) {
        // a hearty meal costs 4.30 euros
        // if the payment card has enough money, the balance of the card is decreased by the price, and the method returns true
        // otherwise false is returned
        if (card.takeMoney(4.3)) {
            this.heartyMeals++;
            return true;
        }
        return false;
//        if (card.balance() < HEARTY_PRICE) {
//            return false;
//        }
//        card.takeMoney(HEARTY_PRICE);
//        this.heartyMeals++;
//        return true;
    }

    public void addMoneyToCard(PaymentCard card, double sum) {
        if (sum > 0) {
            card.addMoney(sum);
            this.money = this.money + sum;
        }
    }

    @Override
    public String toString() {
        return "money: " + money + ", number of sold affordable meals: " + affordableMeals + ", number of sold hearty meals: " + heartyMeals;
    }
}
