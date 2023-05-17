
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        // for-each, for, while loop; stream().forEach(->); Iterator class
        Iterator<Card> iterator = this.cards.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void sort() {
        // Custom Sorting algorithm; Comparable interface, stream().sorted() (sorts stream), Collections.sort() (sorts original list); Comparator class
        Collections.sort(this.cards);
    }

    public int compareTo(Hand another) {
        return this.handValue() - another.handValue();
    }

    public int handValue() {
        Iterator<Card> iterator = this.cards.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum = sum + iterator.next().getValue();
        }
        return sum;
    }

    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
