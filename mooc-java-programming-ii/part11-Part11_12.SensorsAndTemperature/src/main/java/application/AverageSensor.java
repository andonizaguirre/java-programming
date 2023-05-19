/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andoni
 */
public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public boolean isOn() {
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
//        // Iterators are needed when the list or collection has to be modified i.e remove, add, etc.
//        Iterator<Sensor> iterator = this.sensors.iterator();
//        while (iterator.hasNext()) {
//            if (!iterator.next().isOn()) {
//                return false;
//            }
//        }
//        return true;
    }

    public void setOn() {
        for (Sensor sensor : this.sensors) {
            sensor.setOn();
        }
    }

    public void setOff() {
        for (Sensor sensor : this.sensors) {
            if (sensor.isOn()) {
                sensor.setOff();
                return;
            }
        }
//        // Could just turn all the sensors off
//        for (Sensor sensor : this.sensors) {
//            sensor.setOff();
//        }
//        // Careful with iterators when calling iterator.next() cause it advances the pointer
//        Iterator<Sensor> iterator = this.sensors.iterator();
//        while (iterator.hasNext()) {
//            Sensor currentSensor = iterator.next(); // Store variable to not make multiple calls
//            if (currentSensor.isOn()) {
//                currentSensor.setOff();
//                return;
//            }
//        }
    }

    public int read() {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException();
        }
        // Could use a loop with sum and count, iterator, or reduce(->) with lambda function
        int reading = (int) this.sensors.stream().mapToInt(sensor -> sensor.read()).average().getAsDouble();
        this.readings.add(reading);
        return reading;
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readings;
    }
}
