import VehiclePackage.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jennasowers on 9/19/16.
 */
public class TestInventory {

    @Test //test add truck to inventory
    public void testAddToInventoryTruck() {
        //given
        Vehicle v = new Truck();
        Truck v1 = (Truck) v;
        Inventory inv = new Inventory();
        //when
        v1.setVehicle("Ford", "Ranger", 2000, true, 15_000.00, 12.2, false, 500);
        inv.add(v1);
        Vehicle check1 = inv.cars.get(0);
        Truck check = (Truck) check1;
        //then
        assertEquals("Error setting make truck to inventory", "Ford", check.getMake());
        assertEquals("Error setting model truck to inventory", "Ranger", check.getModel());
        assertEquals("Error setting year truck to inventory", 2000, check.getYear());
        assertEquals("Error setting four wheel truck to inventory", true, check.getFourWheel());
        assertEquals("Error setting retail price truck to inventory", 15_000.00, check.getRetailPrice(), 0);
        assertEquals("Error setting mpg truck to inventory", 12.2, check.getMilesPerGallon(), 0);
        assertEquals("Error setting side step truck to inventory", false, check.getSideStep());
        assertEquals("Error setting tow capacity truck to inventory", 500, check.getTowCapacity(), 0);
    }

    @Test //test add car to inventory
    public void testAddToInventoryCar() {
        //given
        Vehicle v = new Car();
        Car v1 = (Car) v;
        v1.setVehicle("Chrysler", "Sebring", 2000, false, 10_000.00, 22.2, true);
        Inventory inv = new Inventory();
        //when
        inv.add(v1);
        Vehicle check1 = inv.cars.get(0);
        Car check = (Car) check1;
        //then
        assertEquals("Error setting make car to inventory", "Chrysler", check.getMake());
        assertEquals("Error setting model car to inventory", "Sebring", check.getModel());
        assertEquals("Error setting year car to inventory", 2000, check.getYear());
        assertEquals("Error setting four wheel car to inventory", false, check.getFourWheel());
        assertEquals("Error setting retail price car to inventory", 10_000.00, check.getRetailPrice(), 0);
        assertEquals("Error setting mpg car to inventory", 22.2, check.getMilesPerGallon(), 0);
        assertEquals("Error setting convertable car to inventory", true, check.getConvertable());
    }
    @Test //test add vehicle to inventory
    public void testAddToInventoryVehicle()
    {
        //given
        Vehicle v = new Vehicle();
        v.setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        Inventory inv = new Inventory();
        //when
        inv.add(v);
        Vehicle check = inv.cars.get(0);
        //then
        assertEquals("Error setting make vehicle to inventory", "Honda", check.getMake());
        assertEquals("Error setting model vehicle to inventory", "Pilot", check.getModel());
        assertEquals("Error setting year vehicle to inventory", 2005, check.getYear());
        assertEquals("Error setting four wheel vehicle to inventory", true, check.getFourWheel());
        assertEquals("Error setting retail price vehicle to inventory", 16_999.99, check.getRetailPrice(), 0);
        assertEquals("Error setting mpg vehicle to inventory", 17.5, check.getMilesPerGallon(), 0);
    }

    @Test //test remove vehicles
    public void testRemoveVehicleFromInventory() {
        //given
        Vehicle[] v = {new Vehicle(), new Car(), new Truck()};
        v[0].setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        Car v1 = (Car) v[1];
        v1.setVehicle("Chrysler", "Sebring", 2000, false, 10_000.00, 22.2, true);
        Truck v2 = (Truck) v[2];
        v2.setVehicle("Ford", "Ranger", 2000, true, 15_000.00, 12.2, false, 500);

        Inventory inv = new Inventory();
        //when
        for (int i = 0; i < v.length; i++)
            inv.add(v[i]);

        //then
        inv.remove(v[2]);
        assertEquals("Error removing truck", false, inv.cars.contains(v[2]));

        inv.remove(v[1]);
        assertEquals("Error removing car", false, inv.cars.contains(v[1]));

        inv.remove(v[0]);
        assertEquals("Error removing vehicle", false, inv.cars.contains(v[0]));
    }


    @Test //test find cheapest vehicle in inventory
    public void testFindCheapestVehicle() {
        //given
        Vehicle[] v = {new Vehicle(), new Car(), new Truck()};
        v[0].setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        Car v1 = (Car) v[1];
        v1.setVehicle("Chrysler", "Sebring", 2000, false, 10_000.00, 22.2, true);
        Truck v2 = (Truck) v[2];
        v2.setVehicle("Ford", "Ranger", 2000, true, 15_000.00, 12.2, false, 500);

        Inventory inv = new Inventory();

        //when
        for (int i = 0; i < v.length; i++)
            inv.add(v[i]);

        Vehicle cheap = inv.findCheapestVehicle();

        //then
        assertEquals("Error finding cheapest vehicle", v1, cheap);
    }

    @Test //test find expensive vehicle in inventory
    public void testMostExpensiveVehicle() {
        //given
        Vehicle[] v = {new Vehicle(), new Car(), new Truck()};
        v[0].setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        Car v1 = (Car) v[1];
        v1.setVehicle("Chrysler", "Sebring", 2000, false, 10_000.00, 22.2, true);
        Truck v2 = (Truck) v[2];
        v2.setVehicle("Ford", "Ranger", 2000, true, 15_000.00, 12.2, false, 500);

        Inventory inv = new Inventory();

        //when
        for (int i = 0; i < v.length; i++)
            inv.add(v[i]);

        Vehicle exp = inv.findMostExpensiveVehicle();

        //then
        assertEquals("Error finding cheapest vehicle", v[0], exp);
    }

    @Test //test find average price inventory
    public void testfindAveragePriceInventory() {
        //given
        Vehicle[] v = {new Vehicle(), new Car(), new Truck()};
        v[0].setVehicle("Honda", "Pilot", 2005, true, 16_999.99, 17.5);
        Car v1 = (Car) v[1];
        v1.setVehicle("Chrysler", "Sebring", 2000, false, 10_000.00, 22.2, true);
        Truck v2 = (Truck) v[2];
        v2.setVehicle("Ford", "Ranger", 2000, true, 15_000.00, 12.2, false, 500);

        Inventory inv = new Inventory();

        //when
        for (int i = 0; i < v.length; i++)
            inv.add(v[i]);

        Vehicle check = null;
        double avg = 0.0; //starting price at 1 billion
        for (int i = 0; i < inv.cars.size(); i++)
        {
            check = inv.cars.get(i);
            avg += check.getRetailPrice();
        }
        avg /= inv.cars.size();

        //then
        assertEquals("Error calculating average price",13_999.99 , avg, 0.01);
    }
}
