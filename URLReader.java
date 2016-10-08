package VehiclePackage;
/**
 * Created by jonathan norris on 9/12/16.
 */
import java.net.*;
import java.io.*;

public class URLReader {

        private URL vehUrl;
        private String[] vehicleArray;

        public URLReader(String url)
        {
            try{
                this.vehUrl = new URL(url);
            }
            catch(MalformedURLException e){
                e.getMessage();
            }

            this.vehicleArray = new String[10];
            this.setVehicleArray();

        }

        private void setVehicleArray()
        {
            BufferedReader in = null;
            try {
                 in = new BufferedReader(new InputStreamReader(this.vehUrl.openStream()));
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
                    this.vehicleArray[i] = inputLine;
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
        public String[] getVehicleArray()
        {
            return this.vehicleArray;
        }
}