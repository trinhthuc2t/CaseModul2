package Model.File.Car;


import Model.User.User;
import Model.Vehicle.Car;

import java.io.*;
import java.util.List;

public class WriteFileCar {

    File file = new File("Case_1/data/car.csv");

    public void writeData(List<Car> cars) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Car st : cars) {
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