package Model.Management;

import Model.File.vehicle.ReadFileVehicle;
import Model.File.vehicle.WriteFileVehicle;
import Model.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManeger implements Management<Vehicle> {
    WriteFileVehicle writeFileVehicle = new WriteFileVehicle();
    ReadFileVehicle readFileVehicle = new ReadFileVehicle();
    private List<Vehicle> vehicles;

    public VehicleManeger() {
        vehicles = readFileVehicle.readData();
   }

    @Override
    public void add(Vehicle vehicle) {
        this.vehicles = readFileVehicle.readData();
        vehicles.add(vehicle);
        writeFileVehicle.writeData(vehicles);
    }

    @Override
    public void delete(String id) {
        this.vehicles = readFileVehicle.readData();
        int index = findIndexById(id);
        vehicles.remove(index);
        writeFileVehicle.writeData(vehicles);
    }

    @Override
    public void edit(String id, Vehicle vehicle) {
        this.vehicles = readFileVehicle.readData();
        int index = findIndexById(id);
        vehicles.set(index, vehicle);
        writeFileVehicle.writeData(vehicles);
    }

    @Override
    public int findIndexById(String id) {
        this.vehicles = readFileVehicle.readData();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public List<Vehicle> findByLicensePlate(String licensePlate) {
        this.vehicles = readFileVehicle.readData();
        List<Vehicle> vehicleList = new ArrayList<>();
        for (Vehicle vhc : vehicles) {
            if (vhc.getLicensePlate().toUpperCase().contains(licensePlate.toUpperCase())) {
                vehicleList.add(vhc);
            }
        }
        return vehicleList;

    }
    public List<Vehicle> getAllVehicle() {
        return this.readFileVehicle.readData();
    }
}
