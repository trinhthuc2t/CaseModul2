package Model.Management.vehicle;

import Model.Management.Management;
import Model.Vehicle.Motorbike;
import Model.Vehicle.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckManager implements Management<Truck> {
    private List<Truck> trucks;

    public TruckManager() {
        trucks = new ArrayList<>();
    }


    @Override
    public void add(Truck truck) {
        trucks.add(truck);
    }

    @Override
    public void delete(String id) {
        int index = findIndexById(id);
        trucks.remove(trucks);
    }

    @Override
    public void edit(String id, Truck truck) {
        int index = findIndexById(id);
        trucks.set(index, truck);

    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < trucks.size(); i++) {
            if (id.equals(trucks.get(i).getId()))
                return i;
        }
        return -1;
    }

    public List<Truck> getAllTruck() {
        return trucks;
    }
}
