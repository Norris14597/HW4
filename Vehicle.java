package VehiclePackage;

import java.io.Serializable;

/**
 * Created by jonathan norris on 9/12/16.
 */
public class Vehicle implements Serializable{
    private
    String make;
    String model;
    int year;
    double retailPrice;
    boolean fourWheel;
    double milesPerGallon;

    public Vehicle()
    {
        this.make = "";
        this.model = "";
        this.year = 1900;
        this.retailPrice = 0.00;
        this.fourWheel = false;
        this. milesPerGallon = 0.0;
    }
    public void setVehicle(String mk, String mod, int yr, boolean fW, double rtP, double mpg)
    {
        this.make = mk;
        this.model = mod;
        this.year = yr;
        this.retailPrice = rtP;
        this.fourWheel = fW;
        this.milesPerGallon = mpg;
    }
    public void setVehicle(String mk, String mod, int yr, double rtP) //constructor for dealer
    {
        this.make = mk;
        this.model = mod;
        this.year = yr;
        this.retailPrice = rtP;
        this.fourWheel = false;
        this. milesPerGallon = 0.0;
    }
    public String getMake()
    {
        return this.make;
    }
    public String getModel()
    {
        return this.model;
    }
    public int getYear()
    {
        return this.year;
    }
    public double getRetailPrice()
    {
        return this.retailPrice;
    }
    public boolean getFourWheel()
    {
        return this.fourWheel;
    }
    public double getMilesPerGallon()
    {
        return this.milesPerGallon;
    }
    public String toString()
    {
        return String.format(" Make: " + this.getMake() + " %n " +
                "Model: " + this.getModel() + " %n " +
                "Year: " + this.getYear() + " %n " +
                "Four Wheel: " + this.getFourWheel() + " %n " +
                "Retail Price: " + this.getRetailPrice() + " %n " +
                "Miles Per Gallon: " + this.getMilesPerGallon() + " %n"
        );

    }


}
