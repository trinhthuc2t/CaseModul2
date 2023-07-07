package Model.Vehicle;

public class Vehicle {
    private String id;
    private String manufacturer;//hãng
    private String dateOfManufacture; //năm sx;
    private String licensePlate;//Biển số xe
    private String typeOfVehicle;// Loại xe
    private String color;
    private boolean status;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle(String typeOfVehicle, String id, String manufacturer, String dateOfManufacture, String licensePlate, String color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.dateOfManufacture = dateOfManufacture;
        this.licensePlate = licensePlate;
        this.typeOfVehicle = typeOfVehicle;
        this.color = color;
        this.status = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  typeOfVehicle + ", id - " + id +
                ", Hãng xe - " + manufacturer +
                ", Năm sx - " + dateOfManufacture +
                ", Biển số xe - " + licensePlate +
                ", color - " + color  +
                ", status - " + status;
    }
    public String writeString() {
        return getTypeOfVehicle() + "," + getId() + "," + getManufacturer()+","+getDateOfManufacture()
                + "," + getLicensePlate() + "," + getColor() + "\n";
    }
}
