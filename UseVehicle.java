package VehiclePackage;
import java.util.Random;

/**
 * Created by jonathan norris on 9/12/16.
 */

//Vehicle car truck: just stores data on specific vehicle
//        Inventory: stores all vehicle cars and truck objects and can calculate some stuff
//        URLReader: takes url and gets array of each string of line on webpage
//        Dealer: the dealer handles the array of urlreader and then sets the inventory of vehicle objects. Then dealer does that other crap to files and stuff

public class UseVehicle {
    public static void main(String[] args) {
        //Random r = new Random();
        //boolean rand = r.nextBoolean();
        boolean rand = true;
        if (rand == true) {
            String urlLine = "https://raw.githubusercontent.com/kyungsooim/TestData/master/data/SeptemberInventory.txt";
            Dealer dealer = new Dealer(urlLine);
            dealer.serializeToFile();
            //dealer.printDealerVehicles();
        }
        else {
            Dealer dealer = new Dealer();
            dealer.deserializeFromFile();
            dealer.printDealerVehicles();
        }
    }

}
