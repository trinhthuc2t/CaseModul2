package Model.Vehicle;

public class Container extends Vehicle {


    public Container(String typeOfVehicle, String id, String manufacturer, String dateOfManufacture, String licensePlate, String color) {
        super(typeOfVehicle, id, manufacturer, dateOfManufacture, licensePlate, color);
    }

    public String writeString() {
        return getTypeOfVehicle() + "," + getId() + "," + getManufacturer() + "," + getDateOfManufacture()
                + "," + getLicensePlate() + "," + getColor() + "\n";
    }
}
