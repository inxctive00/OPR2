package test;

import main.Management.FineManager;
import main.Management.PoliceOfficer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.Entities.Car;
import main.Entities.Fine;
import main.Entities.Location;

import main.Enums.Action;

import main.Signs.DirectionSign;
import main.Signs.ProhibitionSign;
import main.Signs.SpeedLimitSign;

import java.util.Arrays;
import java.util.List;

public class PoliceOfficerTest {

    private FineManager fineManager;
    private PoliceOfficer officer;

    @BeforeEach
    void setUp() {

        fineManager = new FineManager();
        officer = new PoliceOfficer("Officer Smith", fineManager);
    }

    @Test
    void testInspectLocation() {

        Location location = new Location("Main Street");
        location.addSign(new SpeedLimitSign(50));
        location.addSign(new ProhibitionSign(Action.PARKING));


        Car A = new Car("AAAA-AAAA", 80, Action.DRIVING_STRAIGHT);
        Car B = new Car("BBBB-BBBB", 0, Action.PARKING);
        Car C = new Car("CCCC-CCCC", 40, Action.DRIVING_STRAIGHT);

        List<Car> carsInLocation = Arrays.asList(A, B, C);

        List<Fine> issuedFines = officer.inspectLocation(location, carsInLocation);

        assertEquals(2, issuedFines.size(), "Officer should issue exactly 2 fines in total.");
        assertEquals("Officer Smith", officer.getName(), "Officer name should match.");
    }
}