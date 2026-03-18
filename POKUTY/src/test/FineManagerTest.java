package test;

import main.Management.FineManager;

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

import java.util.List;



public class FineManagerTest {

    private FineManager fineManager;

    @BeforeEach
    void setUp() {
        fineManager = new FineManager();
    }

    @Test
    void testProhibitionViolation_shouldReturnFine() {
        Location location = new Location("City Center");
        location.addSign(new ProhibitionSign(Action.PARKING));
        Car car = new Car("9A7-3143", 0, Action.PARKING);

        List<Fine> fines = fineManager.checkViolations(car, location);

        assertEquals(1, fines.size(), "There should be exactly 1 fine for parking in a no-parking zone.");
        assertTrue(fines.get(0).getReason().contains("Prohibition violation"));
    }

    @Test
    void testSpeedLimitExceeded_shouldReturnFine() {
        Location location = new Location("School Zone");
        location.addSign(new SpeedLimitSign(30));
        Car car = new Car("1A2-95X4", 50, Action.DRIVING_STRAIGHT);

        List<Fine> fines = fineManager.checkViolations(car, location);

        assertEquals(1, fines.size(), "There should be exactly 1 fine for speeding.");
        assertTrue(fines.get(0).getReason().contains("Speed limit exceeded"));
    }

    @Test
    void testWrongDirection_shouldReturnFine() {
        Location location = new Location("One Way Street");
        location.addSign(new DirectionSign(Action.DRIVING_STRAIGHT));
        Car car = new Car("3P0-5563", 20, Action.DRIVING_LEFT);

        List<Fine> fines = fineManager.checkViolations(car, location);

        assertEquals(1, fines.size(), "There should be exactly 1 fine for driving in the wrong direction.");
        assertTrue(fines.get(0).getReason().contains("Wrong driving direction"));
    }

    @Test
    void testHighSpeedWithNoSpeedLimitSign_shouldNotReturnFine() {
        Location location = new Location("German Autobahn");
        location.addSign(new ProhibitionSign(Action.PARKING));
        Car car = new Car("3E4-0901", 200, Action.DRIVING_STRAIGHT);

        List<Fine> fines = fineManager.checkViolations(car, location);

        assertEquals(0, fines.size(), "Car should NOT receive a fine for speeding if there is no speed limit sign present.");
    }

    @Test
    void testCompliantDriver_shouldNotReturnFine() {
        Location location = new Location("Safe Street");
        location.addSign(new SpeedLimitSign(50));
        location.addSign(new ProhibitionSign(Action.TURNING));

        Car car = new Car("6M6-3412", 45, Action.DRIVING_STRAIGHT);

        List<Fine> fines = fineManager.checkViolations(car, location);

        assertEquals(0, fines.size(), "Compliant driver should receive 0 fines.");
    }
}