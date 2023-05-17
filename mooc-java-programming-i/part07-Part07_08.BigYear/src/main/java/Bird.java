/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Bird {

    private String name;
    private String nameInLatin;
    private int observations;

    public Bird(String name, String nameInLatin) {
        this.name = name;
        this.nameInLatin = nameInLatin;
        this.observations = 0;
    }

    public String name() {
        return this.name;
    }

    public void observation() {
        this.observations++;
    }

    public String toString() {
        return this.name + " (" + this.nameInLatin + "): " + this.observations + " observations";
    }
}
