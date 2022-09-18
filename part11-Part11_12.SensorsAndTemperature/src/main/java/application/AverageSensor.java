/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor{

    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    @Override
    public boolean isOn() {
        for(Sensor s: this.sensors) {
            if(s.isOn()==false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for(Sensor s: this.sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for(Sensor s: this.sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if(this.isOn()==false || this.sensors.isEmpty()) {
            throw new IllegalStateException("Average Sensor is off");
        }
        int sum=0;
        for(Sensor s: this.sensors) {
            sum+= s.read();
        }
        this.readings.add(sum/this.sensors.size());
        return sum/this.sensors.size();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        if(this.readings.isEmpty()) {
            return new ArrayList<>();
        }
        return this.readings;
    }
    
}
