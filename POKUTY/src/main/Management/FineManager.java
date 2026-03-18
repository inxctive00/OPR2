package main.Management;

import main.Entities.Car;
import main.Entities.Fine;
import main.Entities.Location;
import main.Signs.DirectionSign;
import main.Signs.ProhibitionSign;
import main.Signs.SpeedLimitSign;
import main.Signs.TrafficSign;

import java.util.ArrayList;
import java.util.List;

public class FineManager {

    public List<Fine> checkViolations(Car car, Location location){
        List<Fine> fines = new ArrayList<>();

        for(TrafficSign trafficSign: location.getSigns()){
            if(trafficSign instanceof  ProhibitionSign){
                ProhibitionSign prohibitionSign = (ProhibitionSign) trafficSign;
                if(car.getCurrentAction() == prohibitionSign.getForbiddenAction()){

                    String reason = "Prohibition violation! Forbidden action: " + prohibitionSign.getForbiddenAction() + " at location: " + location.getName();
                    fines.add(new Fine(car,reason));
                }
            }
            else if(trafficSign instanceof SpeedLimitSign){
                SpeedLimitSign speedLimitSign = (SpeedLimitSign) trafficSign;
                if(car.getCurrentSpeed() > speedLimitSign.getMaxSpeed()){

                    String reason = "Speed limit exceeded at location: " + location.getName() + "! Allowed: " + speedLimitSign.getMaxSpeed() + ", Measured: " + car.getCurrentSpeed();

                    fines.add(new Fine(car,reason));
                }
            }
            else if(trafficSign instanceof DirectionSign){
                DirectionSign directionSign = (DirectionSign) trafficSign;
                if (car.getCurrentAction().name().startsWith("DRIVING") && car.getCurrentAction() != directionSign.getAllowedDirection()) {
                    String reason = "Wrong driving direction at location: " + location.getName() + "! Mandatory direction: " + directionSign.getAllowedDirection();
                    fines.add(new Fine(car, reason));
                }
            }
        }

        return fines;
    }
}
