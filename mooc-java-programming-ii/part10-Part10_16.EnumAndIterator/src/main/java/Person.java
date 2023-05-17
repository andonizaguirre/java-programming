/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Person {

    private String name;
    private Education level;

    public Person(String name, Education level) {
        this.name = name;
        this.level = level;
    }

    public Education getEducation() {
        return this.level;
    }

    public String toString() {
        return this.name + ", " + this.level;
    }
}
