/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Item {

    private String identifier;
    private String name;

    public Item(String id, String name) {
        this.identifier = id;
        this.name = name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Item)) {
            return false;
        }
        Item compared = (Item) object;
        if (this.identifier.equals(compared.identifier)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.identifier + ": " + this.name;
    }
}
