import VehiclePackage.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jennasowers on 9/18/16.
 */
public class TestVehicle {

    @Test //test set standard vehicle
    public void testSetVehicle()
    {
        //given
        Vehicle v = new Vehicle();
        //when
        v.setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        //then
        assertEquals("Error setting make", "Honda", v.getMake());
        assertEquals("Error setting model", "Pilot", v.getModel());
        assertEquals("Error setting year", 2005, v.getYear());
        assertEquals("Error setting fourWheel", true, v.getFourWheel());
        assertEquals("Error setting retailPrice", 16_999.99, v.getRetailPrice(), 0);
        assertEquals("Error setting milesPerGallon", 17.5, v.getMilesPerGallon(), 0);
    }

    @Test //test vehicle to string
    public void testToStringVehicle()
    {
        //given
        Vehicle v = new Vehicle();
        //when
        v.setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        String output = v.toString();
        //then
        assertEquals("Error vehicle to string",
                " Make: Honda \n Model: Pilot \n Year: 2005 \n Four Wheel: true \n Retail Price: 16999.99 \n Miles Per Gallon: 17.5 \n"
                , output);
    }

}
