
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        if (cents > 99) {
            euros = euros + cents / 100;
            cents = cents % 100;
        }
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return this.euros;
    }

    public int cents() {
        return this.cents;
    }

    public Money plus(Money addition) {
        Money total = new Money(this.euros + addition.euros, this.cents + addition.cents);
        return total;
//        int euros = this.euros + addition.euros();
//        int cents = this.cents + addition.cents();
//        if (cents > 99) {
//            cents = cents - 100;
//            euros = euros + 1;
//        }
//        return new Money(euros, cents);
    }

    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        } else if (this.euros == compared.euros && this.cents < compared.cents) {
            return true;
        } else {
            return false;
        }
//        return (100 * this.euros + this.cents) < (100 * compared.euros() + compared.cents());
    }

    public Money minus(Money decreaser) {
        if (this.lessThan(decreaser)) {
            Money difference = new Money(0, 0);
            return difference;
        }
        int auxiliarEuros = this.euros;
        int auxiliarCents = this.cents;
        if (decreaser.cents > this.cents) {
            auxiliarCents = auxiliarCents + 100;
            auxiliarEuros--;
        }
        Money difference = new Money(auxiliarEuros - decreaser.euros, auxiliarCents - decreaser.cents);
        return difference;
//        int euros = this.euros - decreaser.euros();
//        int cents = this.cents - decreaser.cents(); 
//        if (cents < 0) {
//            cents = cents + 100;
//            euros = euros - 1;
//        } 
//        // if the value becomes negative, return zero
//        if (euros < 0) {
//            return new Money(0, 0);
//        } 
//        return new Money(euros, cents);
    }

    public String toString() {
        String zero = "";
        if (this.cents < 10) {
            zero = "0";
        }
        return this.euros + "." + zero + this.cents + "e";
    }
}
