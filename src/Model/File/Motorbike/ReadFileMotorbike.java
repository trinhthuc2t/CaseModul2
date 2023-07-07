package Model.File.Motorbike;

import Model.Vehicle.Car;
import Model.Vehicle.Motorbike;
import Model.Vehicle.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileMotorbike {
    File file = new File("Case_1/data/motorbike.csv");

    public List<Motorbike> readData() {
        List<Motorbike> motorbikes = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(",");
                motorbikes.add(new Motorbike(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return motorbikes;
    }
}
