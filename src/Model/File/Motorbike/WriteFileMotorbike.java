package Model.File.Motorbike;
import Model.Vehicle.Motorbike;

import java.io.*;
import java.util.List;

public class WriteFileMotorbike {
    File file = new File("Case_1/data/motorbike.csv");

    public void writeData(List<Motorbike> motorbikes) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Motorbike st : motorbikes) {
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
