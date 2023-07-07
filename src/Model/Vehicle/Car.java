package Model.Vehicle;

public class Car extends Vehicle {


    public Car(String typeOfVehicle, String id, String manufacturer, String dateOfManufacture, String licensePlate, String color) {
        super("Ô tô", id, manufacturer, dateOfManufacture, licensePlate, color);
    }

    public String writeString() {
        return getTypeOfVehicle() + "," + getId() + "," + getManufacturer() + ","+getDateOfManufacture()
                + "," + getLicensePlate() + "," + getColor() + "\n";
    }
}
