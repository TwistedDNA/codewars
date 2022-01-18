package active.learning.kyu4.car.milage;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarMileageTest {

    @Test
    public void hasDigitInTheEnd(){
        assertTrue(CarMileage.hasZerosInTheEnd(100));
        assertTrue(CarMileage.hasZerosInTheEnd(30));
        assertFalse(CarMileage.hasZerosInTheEnd(12000));
        assertFalse(CarMileage.hasZerosInTheEnd(990));
    }

    @Test
    public void everyDigitIsTheSame(){
        assertTrue(CarMileage.everyDigitIsTheSame(11111));
        assertTrue(CarMileage.everyDigitIsTheSame(777));
        assertFalse(CarMileage.everyDigitIsTheSame(12202));
        assertFalse(CarMileage.everyDigitIsTheSame(22221));
    }

}