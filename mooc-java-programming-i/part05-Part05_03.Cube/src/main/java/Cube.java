/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andoni
 */
public class Cube {

    private int edge;

    public Cube(int edgeLength) {
        this.edge = edgeLength;
    }

    public int volume() {
        return edge * edge * edge;
    }

    public String toString() {
        return "The length of the edge is " + edge + " and the volume is " + this.volume();
    }
}
