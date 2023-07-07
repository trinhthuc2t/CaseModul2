package Model.Management.vehicle;

import Model.File.vehicleUser.ReadFileVehicleUser;
import Model.File.vehicleUser.WriteFileVehicleUser;
import Model.Management.Management;
import Model.Vehicle.VehicleUser;

import java.util.List;

public class VehicleUserManager implements Management<VehicleUser> {
    WriteFileVehicleUser writeFileVehicleUser = new WriteFileVehicleUser();
    ReadFileVehicleUser readFileVehicleUser = new ReadFileVehicleUser();
    private List<VehicleUser> vehicleUsers;

    public VehicleUserManager() {
        vehicleUsers = readFileVehicleUser.readData();
    }

    @Override
    public void add(VehicleUser vehicleUser) {
        this.readFileVehicleUser.readData();
        vehicleUsers.add(vehicleUser);
        writeFileVehicleUser.writeData(vehicleUsers);
    }

    @Override
    public void delete(String id) {
        this.readFileVehicleUser.readData();
        int index = findIndexById(id);
        vehicleUsers.remove(index);
        writeFileVehicleUser.writeData(vehicleUsers);
    }

    @Override
    public void edit(String id, VehicleUser vehicleUser) {
        this.readFileVehicleUser.readData();
        int index = findIndexById(id);
        vehicleUsers.set(index, vehicleUser);
        writeFileVehicleUser.writeData(vehicleUsers);
    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < vehicleUsers.size(); i++) {
            if (id.equals(vehicleUsers.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    public List<VehicleUser> getAll() {
        return this.readFileVehicleUser.readData();
    }
}
