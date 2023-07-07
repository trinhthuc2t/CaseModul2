package Model.File.vehicle;
import Model.Vehicle.Vehicle;
import java.io.*;
import java.util.List;

public class WriteFileVehicle {
    File file = new File("Case_1/data/vehicle.csv");

    public void writeData(List<Vehicle> vehicles) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Vehicle st : vehicles) {
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
