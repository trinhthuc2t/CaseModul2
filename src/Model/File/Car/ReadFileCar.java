package Model.File.Car;


import Model.Vehicle.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCar {
    File file = new File("Case_1/data/car.csv");

    public List<Car> readData() {
        List<Car> cars = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                cars.add(new Car(strings[0], strings[1], strings[2],strings[3], strings[4], strings[5]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
