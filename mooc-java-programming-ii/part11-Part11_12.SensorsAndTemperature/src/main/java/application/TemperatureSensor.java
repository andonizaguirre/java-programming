/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author andoni
 */
public class TemperatureSensor implements Sensor {

    private boolean state;

    // Primitive boolean default value = false
    // Constructor not needed
//    public TemperatureSensor() {
//        this.state = false;
//    }
    
    public boolean isOn() {
        return this.state;
    }

    public void setOn() {
        this.state = true;
    }

    public void setOff() {
        this.state = false;
    }

    public int read() {
        if (!this.state) {
            throw new IllegalStateException();
        }
        Random rand = new Random();
        return rand.nextInt(61) - 30; // rand.nextInt(30 - (-30)) + (-30)        
    }
}
