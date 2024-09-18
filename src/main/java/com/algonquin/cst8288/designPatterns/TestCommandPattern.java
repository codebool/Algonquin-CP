/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-18
 * Modified: 2024-09-18
 * Description: Lab assignment
 */

package com.algonquin.cst8288.designPatterns;

// Command interface
interface Command {
    void execute();
}

// Voxel class to represent a voxel in the game
class Voxel2 {
    private String type;

    public Voxel2(String type) {
        this.type = type;
    }

    public void place() {
        System.out.println("Placing voxel: " + type);
    }

    public void remove() {
        System.out.println("Removing voxel: " + type);
    }
}

// Concrete command to place a voxel
class PlaceVoxelCommand implements Command {
    private Voxel2 voxel;

    public PlaceVoxelCommand(Voxel2 voxel) {
        this.voxel = voxel;
    }

    @Override
    public void execute() {
        voxel.place();
    }
}

// Concrete command to remove a voxel
class RemoveVoxelCommand implements Command {
    private Voxel2 voxel;

    public RemoveVoxelCommand(Voxel2 voxel) {
        this.voxel = voxel;
    }

    @Override
    public void execute() {
        voxel.remove();
    }
}

// CommandInvoker that stores and executes commands
class CommandInvoker {
    private Command command;

    // Sets the current command
    public void setCommand(Command command) {
        this.command = command;
    }

    // Executes the current command
    public void executeCommand() {
        command.execute();
    }
}

// Example usage
public class TestCommandPattern {
    public static void main(String[] args) {
        // Create a voxel of type "Grass"
        Voxel2 grassVoxel = new Voxel2("Grass");

        // Create commands for placing and removing voxels
        Command placeCommand = new PlaceVoxelCommand(grassVoxel);
        Command removeCommand = new RemoveVoxelCommand(grassVoxel);

        // Create the invoker
        CommandInvoker invoker = new CommandInvoker();

        // Set and execute the place command
        invoker.setCommand(placeCommand);
        invoker.executeCommand();  // Output: Placing voxel: Grass

        // Set and execute the remove command
        invoker.setCommand(removeCommand);
        invoker.executeCommand();  // Output: Removing voxel: Grass
    }
}
