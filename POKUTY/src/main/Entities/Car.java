package main.Entities;

import main.Enums.Action;

public class Car {
    private String licensePlate;
    private int currentSpeed;
    private Action currentAction;

    public Car(String licensePlate, int currentSpeed, Action currentAction) {
       setLicensePlate(licensePlate);
       setCurrentSpeed(currentSpeed);
       setCurrentAction(currentAction);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }
}