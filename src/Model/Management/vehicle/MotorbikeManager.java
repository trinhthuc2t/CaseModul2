package Model.Management.vehicle;

import Model.File.Motorbike.ReadFileMotorbike;
import Model.File.Motorbike.WriteFileMotorbike;
import Model.Management.Management;
import Model.Vehicle.Motorbike;
import java.util.List;

public class MotorbikeManager implements Management<Motorbike> {
    WriteFileMotorbike writeFileMotorbike = new WriteFileMotorbike();
    ReadFileMotorbike readFileMotorbike = new ReadFileMotorbike();
    private List<Motorbike> motorbikes;

    public MotorbikeManager() {
        motorbikes = readFileMotorbike.readData();
    }


    @Override
    public void add(Motorbike motorbike) {
        motorbikes.add(motorbike);
        writeFileMotorbike.writeData(motorbikes);
    }

    @Override
    public void delete(String id) {
        int index = findIndexById(id);
        motorbikes.remove(index);
        writeFileMotorbike.writeData(motorbikes);
    }

    @Override
    public void edit(String id, Motorbike motorbike) {
        int index = findIndexById(id);
        motorbikes.set(index,motorbike);
        writeFileMotorbike.writeData(motorbikes);

    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < motorbikes.size(); i++) {
            if (id.equals(motorbikes.get(i).getId())){
                return i;
            }
        }
        return -1;
    }
    public List<Motorbike> getAllMotorbike(){
        return readFileMotorbike.readData();
    }
}
