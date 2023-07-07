package Model.Vehicle;

public class Truck extends Vehicle{


    public Truck(String typeOfVehicle, String id, String manufacturer, String dateOfManufacture, String licensePlate, String color) {
        super("Xe tải", id, manufacturer, dateOfManufacture, licensePlate, color);
    }

    public String writeString() {
        return getTypeOfVehicle() + "," + getId() + "," + getManufacturer()+","+getDateOfManufacture()
                + "," + getLicensePlate() + "," + getColor() + "\n";
    }
}
