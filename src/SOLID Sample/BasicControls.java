/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-09-11
 * Modified: 2024-09-11
 * Description: SOLID Principles - Interface Segregation Principle (ISP)
 */

interface BasicControls {
    void on();
    void off();
}

interface SmartControls extends BasicControls {
    void startRecording();
    void stopRecording();
}

class BasicTV implements BasicControls {
    @Override
    public void on() {
        System.out.println("Basic TV is on");
    }

    @Override
    public void off() {
        System.out.println("Basic TV is off");
    }
}

class SmartTV implements SmartControls {
    @Override
    public void on() {
        System.out.println("Smart TV is on");
    }

    @Override
    public void off() {
        System.out.println("Smart TV is off");
    }

    @Override
    public void startRecording() {
        System.out.println("Recording started");
    }

    @Override
    public void stopRecording() {
        System.out.println("Recording stopped");
    }
}
