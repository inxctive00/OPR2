package main.Entities;

public class Fine {
    private Car car;
    private String reason;

    public Fine(Car car, String reason) {
        setCar(car);
        setReason(reason);
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car){
        this.car = car;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason){
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Fine for car with license plate: " + car.getLicensePlate() + " - Reason: " + reason;
    }
}