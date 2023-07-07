package Model.Vehicle;

public class Motorbike extends Vehicle {

    public Motorbike(String typeOfVehicle, String id, String manufacturer, String dateOfManufacture, String licensePlate, String color) {
        super(typeOfVehicle, id, manufacturer, dateOfManufacture, licensePlate, color);
    }




    public String writeString() {
        return getTypeOfVehicle() + "," + getId() + "," + getManufacturer()+","+getDateOfManufacture()
                + "," + getLicensePlate() + "," + getColor() + "\n";
    }
}
