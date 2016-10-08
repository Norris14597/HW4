import VehiclePackage.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jennasowers on 9/19/16.
 */
public class TestCar {
    @Test //test set standard car
    public void testSetCar()
    {
        //given
        Vehicle ve = new Car();
        Car v = (Car) ve;
        //when
        v.setVehicle("Chrysler", "Sebring", 2000, false, 10-000.00, 22.2, true);
        //then
        assertEquals("Error setting make", "Chrysler", v.getMake());
        assertEquals("Error setting model", "Sebring", v.getModel());
        assertEquals("Error setting year", 2000, v.getYear());
        assertEquals("Error setting fourWheel", false, v.getFourWheel());
        assertEquals("Error setting retailPrice", 10-000.00, v.getRetailPrice(), 0);
        assertEquals("Error setting milesPerGallon", 22.2, v.getMilesPerGallon(), 0);
        assertEquals("Error setting convertable", true, v.getConvertable());
    }

    @Test //test car to string
    public void testToStringCar()
    {
        //given
        Vehicle ve = new Car();
        Car v = (Car) ve;
        //when
        v.setVehicle("Chrysler", "Sebring", 2000, false, 10_000.00, 22.2, true);
        String output = v.toString();
        //then
        assertEquals("Error car to string",
                " Make: Chrysler \n Model: Sebring \n Year: 2000 \n Four Wheel: false \n Retail Price: 10000.0 \n Miles Per Gallon: 22.2 \n Convertable: true \n"
                , output);
    }

}
