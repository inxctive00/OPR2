package main.Signs;

public class SpeedLimitSign implements TrafficSign {
    private int maxSpeed;

    public SpeedLimitSign(int maxSpeed){
        setMaxSpeed(maxSpeed);
    }

    public int getMaxSpeed(){return maxSpeed;}
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }
}
