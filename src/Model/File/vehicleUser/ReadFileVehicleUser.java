package Model.File.vehicleUser;

import Model.Vehicle.Car;
import Model.Vehicle.VehicleUser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileVehicleUser {
        File file = new File("Case_1/data/vehicleUser.csv");

        public List<VehicleUser> readData() {
            List<VehicleUser> vehicleUsers = new ArrayList<>();
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] strings = line.split(",");
                    vehicleUsers.add(new VehicleUser(strings[0], strings[1], strings[2],strings[3], strings[4], strings[5]));
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return vehicleUsers;
        }
}
