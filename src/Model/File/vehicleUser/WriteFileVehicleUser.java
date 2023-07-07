package Model.File.vehicleUser;

import Model.Vehicle.Car;
import Model.Vehicle.VehicleUser;

import java.io.*;
import java.util.List;

public class WriteFileVehicleUser {
    File file = new File("Case_1/data/vehicleUser.csv");

    public void writeData(List<VehicleUser> vehicleUsers) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (VehicleUser st : vehicleUsers) {
                bufferedWriter.write(st.writeString());
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
