package VehiclePackage;

import java.io.Serializable;

/**
 * Created by jonathan norris on 9/12/16.
 */
public class Truck extends Vehicle {

    Boolean sideStep;
    int towCapacity;

    public Truck()
    {
        super();
        this.sideStep = null;
        this.towCapacity = 0;
    }
    public void setVehicle(String mk, String mod, int yr, boolean fW, double rtP, double mpg, boolean sS, int towC)
    {
        super.setVehicle(mk, mod, yr, fW, rtP, mpg);
        this.sideStep = sS;
        this.towCapacity = towC;
    }
    public void setVehicle(String mk, String mod, int yr, double rtP, boolean sS) //used for dealer
    {
        super.setVehicle(mk, mod, yr, rtP);
        this.sideStep = sS;
    }
    public boolean getSideStep()
    {
        return this.sideStep;
    }
    public int getTowCapacity()
    {
        return this.towCapacity;
    }
    public String toString()
    {
        return String.format(super.toString() +
                " Side Step: " + this.getSideStep()+ " %n " +
                "Tow Capacity: " + this.getTowCapacity() + " %n"
        );
    }
}