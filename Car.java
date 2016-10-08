package VehiclePackage;

import java.io.Serializable;

/**
 * Created by jonathan norris on 9/12/16.
 */
public class Car extends Vehicle{
    boolean convertable;

    public Car()
    {
        super();
        this.convertable = false;
    }
    public void setVehicle(String mk, String mod, int yr, boolean fW, double rtP, double mpg, boolean conv)
    {
        super.setVehicle(mk, mod, yr, fW, rtP, mpg);
        this.convertable = conv;
    }
    public boolean getConvertable()
    {
        return this.convertable;
    }
    public String toString()
    {
        return String.format(super.toString() + " Convertable: " + this.getConvertable() + " %n");
    }

}
