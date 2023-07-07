package Model.Regex;

import Model.File.Input;

public class AdmRegex {
    private static final String ID_REGEX = "(^XM|OTO|TR|CTM)(\\d)+";
    private static final String DATE = "^(20[0-9]{2})$";
    private static final String LICENSE_PLATE_REGEX = "^[0-9]{2}[A-Z]-[0-9]{4,5}$";
    String id;
    String date;
    String licensePlate;
    public String checkID() {

        do {
            id = Input.inputString();
            if (id.matches(ID_REGEX)) {
                return id;
            } else System.err.println("Nhập sai định dạng!");
        } while (true);
    }  public String checkDate() {

        do {
            date = Input.inputString();
            if (date.matches(DATE)) {
                return date;
            } else System.err.println("Nhập sai định dạng!");
        } while (true);
    }

    public String checkLicensePlate() {

        do {
            licensePlate = Input.inputString();
            if (licensePlate.matches(LICENSE_PLATE_REGEX)) {
                return licensePlate;
            } else System.err.println("Nhập sai định dạng!");
        } while (true);
    }
}
