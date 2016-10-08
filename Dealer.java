package VehiclePackage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.SerializationUtils;
import sun.misc.FloatingDecimal;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.*;
import java.io.*;
/**
 * Created by jonathan norris on 9/30/16.
 */
//Dealer: the dealer handles the array of urlreader and then sets the inventory of vehicle objects.
        //Then dealer does that other crap to files and stuff
public class Dealer implements Serializable
{
    public Inventory inv;
    private String[] urlArray;

    public Dealer() {
        this.inv = new Inventory();
        this.urlArray = new String[10];

    }

    public Dealer(String url) {
        this.inv = new Inventory();
        urlArray = new String[10];
        setURLArray(url);
        this.setDealer();

    }

    private void setURLArray(String url)
    {
        URL vehUrl = null;
        try{
            vehUrl = new URL(url);
        }
        catch(MalformedURLException e){
            e.getMessage();
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(vehUrl.openStream()));
        }
        catch(IOException e){
            e.getMessage();
        }

        String inputLine = "";
        int i = 0;
        boolean isEndFile = false;
        do{
            try{
                assert in != null;
                inputLine = in.readLine();
                this.urlArray[i] = inputLine;
            } catch(IOException e){
                e.getMessage();
            }
            catch(NullPointerException e){
                e.getMessage();
            }

            if(inputLine == null)
                isEndFile = true;
            i++;
        }
        while(!isEndFile);

        try{
            in.close();
        } catch(IOException e) {
            e.getMessage();
        }
    }

    private void setDealer() {
        String vString = "";//string of vehicle
        String make = "";
        String model = "";
        int year = 0;
        double price = 0;
        Boolean sideStep = null;

        for (int i = 0; i < 9; i++) {
            vString = this.urlArray[i]; //individual line of vehicle
            String[] segmentsAll;
            String[] segmentMkMd = new String[2];
            boolean fW = false;
            if (i == 0 || i == 7 || i == 8) {
                segmentsAll = new String[4];
                fW = true;
            } else
                segmentsAll = new String[3];

            try {
                segmentsAll = vString.split(","); // (mk/model) + year + price + possibly sidestep
                segmentMkMd = segmentsAll[0].split(" ");//make + model
            } catch (NullPointerException e) {
                e.getMessage();
            }
            make = segmentMkMd[0];
            model = segmentMkMd[1];
            try {
                year = Integer.parseInt(segmentsAll[1]);
                price = FloatingDecimal.parseDouble(segmentsAll[2]);
            } catch (NumberFormatException e) {
                e.getMessage();
            }
            if (fW) {
                sideStep = Boolean.parseBoolean(segmentsAll[3]);
                Vehicle vt = new Truck();
                Truck v = (Truck) vt;
                v.setVehicle(make, model, year, price, sideStep);
                this.inv.add(v);
                System.out.println(v.toString());

            } else {
                Vehicle v = new Vehicle();
                v.setVehicle(make, model, year, price);
                this.inv.add(v);
                System.out.println(v.toString());
            }

        }


    }
    public void serializeToFile()
    {

        try {
            File file = FileUtils.getFile("/Users/jennasowers/Desktop/Nathan College/Semester 4/SoftwareConstr/HW/HW1/", "serializable.txt");
            byte[] data = SerializationUtils.serialize(this.inv);
            for (int i = 0; i < data.length; i++)
                System.out.println(data[i]);
            FileUtils.writeByteArrayToFile(file, data);
            System.out.println("Inventory was serialized to file.");
        } catch (IOException io){
            io.printStackTrace();
        }
    }
    public void deserializeFromFile(){
        File file = FileUtils.getFile("/Users/jennasowers/Desktop/Nathan College/Semester 4/SoftwareConstr/HW/HW1/", "serializable.txt");
        byte[] data = null;
        try {
            data = FileUtils.readFileToByteArray(file);
            inv = SerializationUtils.deserialize(data);
            System.out.println("Data was deserialized from file into vehicle inventory.");
        } catch (IOException io){
            io.printStackTrace();
        } catch (SerializationException se){
            se.printStackTrace();
        }

    }
    public void printDealerVehicles() //testing purposes only
    {
        Vehicle v;
        for (int i = 0; i < 9; i++){
            v = this.inv.getVehicle(i);
            System.out.println("Make: "+ v.getMake() + ", Model: " + v.getModel() + ", Year: " + v.getYear() + ", Price: " + v.getRetailPrice());
        }
    }

}