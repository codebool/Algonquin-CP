/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-18
 * Modified: 2024-09-18
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String eventType, Voxel voxel);
}

// AudioManager class that listens to voxel events
class AudioManager implements Observer {
    @Override
    public void update(String eventType, Voxel voxel) {
        System.out.println("Audio Manager: Playing sound for " + eventType + " of voxel: " + voxel.getType());
    }
}

// HUD class that listens to voxel events
class HUD implements Observer {
    @Override
    public void update(String eventType, Voxel voxel) {
        System.out.println("HUD: Updating display for " + eventType + " of voxel: " + voxel.getType());
    }
}

// Voxel class to represent the voxel
class Voxel {
    private String type;

    public Voxel(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void place() {
        System.out.println("Placing voxel: " + type);
    }

    public void remove() {
        System.out.println("Removing voxel: " + type);
    }
}

// VoxelSubject class that handles observer management and notifying them of events
class VoxelSubject {
    private List<Observer> observers = new ArrayList<>(); // List of observers

    // Method to add an observer
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Method to remove an observer
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Method to notify all observers about an event
    public void notifyObservers(String eventType, Voxel voxel) {
        for (Observer observer : observers) {
            observer.update(eventType, voxel);
        }
    }

    // Methods to place or remove a voxel, and notify observers
    public void placeVoxel(Voxel voxel) {
        voxel.place();
        notifyObservers("place", voxel);
    }

    public void removeVoxel(Voxel voxel) {
        voxel.remove();
        notifyObservers("remove", voxel);
    }
}

// Example usage of the observer pattern
public class TestObserverPattern {
    public static void main(String[] args) {
        // Create the subject (voxel manager)
        VoxelSubject voxelSubject = new VoxelSubject();

        // Create some observers
        Observer hud = new HUD();
        Observer audioManager = new AudioManager();

        // Register the observers
        voxelSubject.addObserver(hud);
        voxelSubject.addObserver(audioManager);

        // Create a voxel of type "Stone"
        Voxel stoneVoxel = new Voxel("Stone");

        // Place the voxel, which should notify all observers
        voxelSubject.placeVoxel(stoneVoxel);

        // Remove the voxel, which should notify all observers
        voxelSubject.removeVoxel(stoneVoxel);
    }
}

