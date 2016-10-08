package VehiclePackage;
import java.io.Serializable;
import java.util.*;
/**
 * Created by jonathan norris on 9/18/16.
 */
public class Inventory implements Serializable{

    public List<Vehicle> cars;
    public Inventory()
    {
        this.cars = new ArrayList<Vehicle>();
    }
    public void add(Vehicle v)
    {
        this.cars.add(v);
    }
    public void remove(Vehicle v)
    {
        this.cars.remove(v);
    }

    public Vehicle getVehicle(int index)
    {
        return this.cars.get(index);
    }
    public Vehicle findCheapestVehicle()
    {
        Vehicle v = null;
        Vehicle vc = null;
        double cheapPrice = 1_000_000_000.0; //starting price at 1 billion
        for (int i = 0; i < this.cars.size(); i++)
        {
            v = this.cars.get(i);
            if (v.getRetailPrice() < cheapPrice)
            {
                cheapPrice = v.getRetailPrice();
                vc = this.cars.get(i);
            }
        }
        return vc;
    }
    public Vehicle findMostExpensiveVehicle()
    {
        Vehicle v = null;
        Vehicle vm = null;
        double expPrice = 0.0; //starting price at 1 billion
        for (int i = 0; i < this.cars.size(); i++)
        {
            v = this.cars.get(i);
            if (v.getRetailPrice() > expPrice)
            {
                expPrice = v.getRetailPrice();
                vm = this.cars.get(i);
            }
        }
        return vm;
    }
    public void printAveragePriceOfAllVehicles()
    {
        Vehicle v = null;
        double avg = 0.0; //starting price at 1 billion
        for (int i = 0; i < this.cars.size(); i++)
        {
            v = this.cars.get(i);
            avg += v.getRetailPrice();
        }
        avg /= this.cars.size();
        System.out.println("$ " + avg);
    }
}
