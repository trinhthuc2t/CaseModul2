package Model.Management.vehicle;

import Model.File.Car.ReadFileCar;
import Model.File.Car.WriteFileCar;
import Model.Management.Management;
import Model.Vehicle.Car;

import java.util.List;

public class CarManager implements Management<Car> {

    WriteFileCar writeFileCar = new WriteFileCar();
    ReadFileCar readFileCar = new ReadFileCar();
    private List<Car> cars;

    public CarManager() {
        cars = readFileCar.readData();
    }


    @Override
    public void add(Car car) {
        this.cars = readFileCar.readData();
        cars.add(car);
        writeFileCar.writeData(cars);
    }

    @Override
    public void delete(String id) {
        this.cars = readFileCar.readData();
        int index = findIndexById(id);
        cars.remove(index);
        writeFileCar.writeData(cars);
    }

    @Override
    public void edit(String id, Car car) {
        this.cars = readFileCar.readData();
        int index = findIndexById(id);
        cars.set(index, car);
        writeFileCar.writeData(cars);
    }


    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < cars.size(); i++) {
            if (id.equals(cars.get(i).getId()))
                return i;
        }
        return -1;
    }

    public List<Car> getAllCar() {
        return this.readFileCar.readData();
    }
}
