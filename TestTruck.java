import VehiclePackage.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jennasowers on 9/19/16.
 */
public class TestTruck {
    @Test //test set standard truck
    public void testSetTruck()
    {
        //given
        Vehicle ve = new Truck();
        Truck v = (Truck) ve;
        //when
        v.setVehicle("Ford", "Ranger", 2000, true, 10-000.00, 12.2, false, 500);
        //then
        assertEquals("Error setting make", "Ford", v.getMake());
        assertEquals("Error setting model", "Ranger", v.getModel());
        assertEquals("Error setting year", 2000, v.getYear());
        assertEquals("Error setting fourWheel", true, v.getFourWheel());
        assertEquals("Error setting retailPrice", 10-000.00, v.getRetailPrice(), 0);
        assertEquals("Error setting milesPerGallon", 12.2, v.getMilesPerGallon(), 0);
        assertEquals("Error setting side step", false, v.getSideStep());
        assertEquals("Error setting tow capacity", 500, v.getTowCapacity());
    }
    @Test //test truck to string
    public void testToStringTruck()
    {
        //given
        Vehicle ve = new Truck();
        Truck v = (Truck) ve;
        //when
        v.setVehicle("Ford", "Ranger", 2000, true, 10_000.00, 12.2, false, 500);
        String output = v.toString();
        //then
        assertEquals("Error truck to string",
                " Make: Ford \n Model: Ranger \n Year: 2000 \n Four Wheel: true \n Retail Price: 10000.0 \n Miles Per Gallon: 12.2 \n Side Step: false \n Tow Capacity: 500 \n"
                , output);
    }

}
