/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class OneItemBox extends Box {

    private Item item;

//    // Not necessary
//    public OneItemBox() {
//    }
//
//    // Equivalent
//    public OneItemBox() {
//        this.item = null;
//    }
    
    @Override
    public void add(Item item) {
        if (this.item == null) {
            this.item = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.item != null && this.item.equals(item);
    }
}
