/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-11-20
 * Modified: 2024-11-20
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

import java.util.ArrayList;
import java.util.List;
// Subject or Observable
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    public WeatherStation() {
        observers = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
// Observer
interface Observer {
    void update(float temperature);
}
// Concrete Observer
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("Phone Display: Current temperature is " + temperature + "°C");
    }
}
// Concrete Observer
class TVDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("TV Display: Current temperature is " + temperature + "°C");
    }
}
public class TestObserverPattern02 {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        TVDisplay tvDisplay = new TVDisplay();
        weatherStation.registerObserver(phoneDisplay);
        weatherStation.registerObserver(tvDisplay);
        weatherStation.setTemperature(30.5F);
        weatherStation.setTemperature(25.0F);
    }
}