import VehiclePackage.Car;
import VehiclePackage.Inventory;
import VehiclePackage.Truck;
import VehiclePackage.Vehicle;
import VehiclePackage.Dealer;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonathan norris on 10/4/16.
 */
public class TestDealer {

    @Test //test remove vehicles
    public void testEmptyDealerConstructor()
    {
        //given
        System.out.println("Testing new empty constructor");
        Dealer d = new Dealer();
        //when
        int size = d.inv.cars.size();
        //then
        assertEquals("Error with empty constructor", 0, size);
    }

    @Test //test remove vehicles
    public void testFileDeserializedToObject()
    {
        //given
        System.out.println("Testing file was deserialized.");
        Dealer d = new Dealer();
        d.deserializeFromFile();
        //when
        Vehicle vOne = d.inv.getVehicle(0);
        Truck v1 = (Truck) vOne;
        Vehicle v2 = d.inv.getVehicle(1);
        Vehicle v3 = d.inv.getVehicle(2);
        Vehicle v4 = d.inv.getVehicle(3);
        Vehicle v5 = d.inv.getVehicle(4);
        Vehicle v6 = d.inv.getVehicle(5);
        Vehicle v7 = d.inv.getVehicle(6);
        Vehicle vEight = d.inv.getVehicle(7);
        Truck v8 = (Truck) vEight;
        Vehicle vNine = d.inv.getVehicle(8);
        Truck v9 = (Truck) vNine;

        //then

        //        Ford F150,2015,35000,TRUE
        assertEquals("Error desiaralize file to inventory", "Ford", v1.getMake());
        assertEquals("Error desiaralize file to inventory", "F150", v1.getModel());
        assertEquals("Error desiaralize file to inventory", 2015, v1.getYear());
        assertEquals("Error desiaralize file to inventory", 35_000, v1.getRetailPrice(), 0);
        assertEquals("Error desiaralize file to inventory", true, v1.getSideStep());

        //        Ford Focus,2010,15000,
        assertEquals("Error desiaralize file to inventory", "Ford", v2.getMake());
        assertEquals("Error desiaralize file to inventory", "Focus", v2.getModel());
        assertEquals("Error desiaralize file to inventory", 2010, v2.getYear());
        assertEquals("Error desiaralize file to inventory", 15_000, v2.getRetailPrice(), 0);

        //            Ford Fiesta,2012,18000,
        assertEquals("Error desiaralize file to inventory", "Ford", v3.getMake());
        assertEquals("Error desiaralize file to inventory", "Fiesta", v3.getModel());
        assertEquals("Error desiaralize file to inventory", 2012, v3.getYear());
        assertEquals("Error desiaralize file to inventory", 18_000, v3.getRetailPrice(), 0);

        //            Ford Fusion,2015,20000,
        assertEquals("Error desiaralize file to inventory", "Ford", v4.getMake());
        assertEquals("Error desiaralize file to inventory", "Fusion", v4.getModel());
        assertEquals("Error desiaralize file to inventory", 2015, v4.getYear());
        assertEquals("Error desiaralize file to inventory", 20_000, v4.getRetailPrice(), 0);

        //            Ford Mustang,1999,8000,
        assertEquals("Error desiaralize file to inventory", "Ford", v5.getMake());
        assertEquals("Error desiaralize file to inventory", "Mustang", v5.getModel());
        assertEquals("Error desiaralize file to inventory", 1999, v5.getYear());
        assertEquals("Error desiaralize file to inventory", 8_000, v5.getRetailPrice(), 0);

        //            Ford GT,2017,30000,
        assertEquals("Error desiaralize file to inventory", "Ford", v6.getMake());
        assertEquals("Error desiaralize file to inventory", "GT", v6.getModel());
        assertEquals("Error desiaralize file to inventory", 2017, v6.getYear());
        assertEquals("Error desiaralize file to inventory", 30_000, v6.getRetailPrice(), 0);

        //            Ford Taurus,2015,25000,
        assertEquals("Error desiaralize file to inventory", "Ford", v7.getMake());
        assertEquals("Error desiaralize file to inventory", "Taurus", v7.getModel());
        assertEquals("Error desiaralize file to inventory", 2015, v7.getYear());
        assertEquals("Error desiaralize file to inventory", 25_000, v7.getRetailPrice(), 0);

        //            GM Sierra,2016,40000,TRUE
        assertEquals("Error desiaralize file to inventory", "GM", v8.getMake());
        assertEquals("Error desiaralize file to inventory", "Sierra", v8.getModel());
        assertEquals("Error desiaralize file to inventory", 2016, v8.getYear());
        assertEquals("Error desiaralize file to inventory", 40_000, v8.getRetailPrice(), 0);
        assertEquals("Error desiaralize file to inventory", true, v8.getSideStep());

        //        Chevy Silverado,2016,35000,TRUE
        assertEquals("Error desiaralize file to inventory", "Chevy", v9.getMake());
        assertEquals("Error desiaralize file to inventory", "Silverado", v9.getModel());
        assertEquals("Error desiaralize file to inventory", 2016, v9.getYear());
        assertEquals("Error desiaralize file to inventory", 35_000, v9.getRetailPrice(), 0);
        assertEquals("Error desiaralize file to inventory", true, v9.getSideStep());
    }


    @Test //test remove vehicles
    public void testObjectWasSerialized()
    {
        //given
        System.out.println("Testing test object was serialized");
        String urlLine = "https://raw.githubusercontent.com/kyungsooim/TestData/master/data/SeptemberInventory.txt";
        Dealer d = new Dealer(urlLine);
        Vehicle v = new Vehicle();
        v.setVehicle("Honda", "Accord", 2_000, 4_589.99);
        d.inv.add(v);

        //when
        d.serializeToFile();
        d.deserializeFromFile();
        Vehicle check = d.inv.getVehicle(9);//last element of vehicle was added to end of inventory

        //then

        assertEquals("Error serialize file to inventory", v.getMake(), check.getMake());
        assertEquals("Error siaralize file to inventory", v.getModel(), check.getModel());
        assertEquals("Error siaralize file to inventory", v.getYear(), check.getYear());
        assertEquals("Error siaralize file to inventory", v.getRetailPrice(), check.getRetailPrice(), 0);

    }
}
