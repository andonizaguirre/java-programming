/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Hideout<T> {

    private T hideout;

    public void putIntoHideout(T toHide) {
        this.hideout = toHide;
    }

    public T takeFromHideout() {
        T toTake = this.hideout;
        this.hideout = null;
        return toTake;
    }

    public boolean isInHideout() {
        return this.hideout != null;
    }
}
