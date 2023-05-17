
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class BySuitInValueOrder implements Comparator<Card> {

    public int compare(Card card1, Card card2) {
        int comparison = card1.getSuit().ordinal() - card2.getSuit().ordinal();
//        int comparison = card1.getSuit().compareTo(card2.getSuit());
        if (comparison == 0) {
            comparison = card1.getValue() - card2.getValue();
        }
        return comparison;
    }
}
