package main.Management;

import main.Entities.Fine;
import main.Entities.Location;
import main.Entities.Car;

import java.util.ArrayList;
import java.util.List;

public class PoliceOfficer {
    private String name;
    private FineManager fineManager;

    public PoliceOfficer(String name, FineManager fineManager) {
        setName(name);
        this.fineManager = fineManager;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public List<Fine> inspectLocation(Location location, List<Car> cars){
        List<Fine> issuedFines = new ArrayList<>();

        System.out.println("[INFO]: Inspection started by: "+getName()+" at location " + location);
        for(Car car: cars){
            List<Fine> finesForCar = fineManager.checkViolations(car,location);

            if(finesForCar.isEmpty() == false){
                issuedFines.addAll(finesForCar);
            }
        }

        return issuedFines;
    }

    /*
        POZN: addAll funguje na pridani XY veci do kolekce bez nutnosti iterace
    */
}
