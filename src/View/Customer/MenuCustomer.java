package View.Customer;

import Model.File.Input;
import Model.Management.VehicleManeger;
import Model.Management.user.UserManager;
import Model.Management.vehicle.*;
import Model.User.StaticUser;
import Model.Vehicle.*;

import java.util.List;


public class MenuCustomer {
    private UserManager userManager;
    private VehicleManeger vehicleManeger;
    private ContainerManager containerManager;
    private CarManager carManager;
    private MotorbikeManager motorbikeManager;
    private TruckManager truckManager;
    private VehicleUserManager vehicleUserManager;


    public MenuCustomer(UserManager userManager, MotorbikeManager motorbikeManager, CarManager carManager, TruckManager truckManager, ContainerManager containerManager, VehicleManeger vehicleManeger, VehicleUserManager vehicleUserManager) {
        this.userManager = userManager;
        this.motorbikeManager = motorbikeManager;
        this.carManager = carManager;
        this.truckManager = truckManager;
        this.containerManager = containerManager;
        this.vehicleManeger = vehicleManeger;
        this.vehicleUserManager = vehicleUserManager;
    }

    public void showMenuCustomer() {
        String menu = "-------Khách Hàng-------\n" +
                "1. Danh sách xe\n" +
                "2. Thông tin cá nhân\n" +
                "3. Xe đã thuê\n" +
                "4. Trả xe\n" +
                "0. Đăng xuất";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showListVehicle();
                    break;
                case 2:
                    showMenuUser();
                    break;
                case 3:
                    showList();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void showListVehicle() {
        String menu = "-------Danh sách xe-------\n" +
                "1. Xe máy\n" +
                "2. Ô tô\n" +
                "3. Xe tải\n" +
                "4. Container\n" +
                "0. Quay lại";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMotorbike();
                    menuAddMotorbike();
                    break;
                case 2:
                    showCar();
                    break;
                case 3:
                    showTruck();
                    break;
                case 4:
                    showContainer();
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void showMenuUser() {
        String menu = "-------Thông tin-------\n" +
                "1. Thông tin cá nhân\n" +
                "2. Sửa thông tin\n" +
                "3. Đổi mật khẩu\n" +
                "0. Quay lại";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showUser();
                    break;
                case 2:
                    editUser();
                    break;
                case 3:
                    changePassword();
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void menuAddMotorbike() {
        String menu =
                "1. Thuê xe\n" +
                        "0. Quay lại";
        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    addMotobike();
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void addMotobike() {
        String id;
        while (true) {
            System.out.println("Nhập ID xe muốn thuê: ");
            id = Input.inputString();
            if (motorbikeManager.findIndexById(id) == -1) {
                System.err.println("ID không tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }
        int index = vehicleManeger.findIndexById(id);
        Vehicle a = vehicleManeger.getAllVehicle().get(index);
        String typeOfVehicle = a.getTypeOfVehicle();
        String manufacturer = a.getManufacturer();
        String dateOfManufacture = a.getDateOfManufacture();
        String licensePlate = a.getLicensePlate();
        String color = a.getColor();
        System.out.println("Bạn đã thuê: " + vehicleManeger.getAllVehicle().get(index));
        vehicleUserManager.add(new VehicleUser(typeOfVehicle, id, manufacturer, dateOfManufacture, licensePlate, color));
    }

    public void showList(){
        System.out.println("------Danh sách đã thuê-------");
        List<VehicleUser> list = vehicleUserManager.getAll();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (VehicleUser mtb :
                    list) {
                System.out.println(mtb);
            }
        }
    }
    public void editUser() {
        System.out.println("Họ và tên:");
        String fullName = Input.inputString();
        StaticUser.user.setUserName(fullName);
        System.out.println("Tuổi: ");
        int age = Input.inputInteger();
        StaticUser.user.setAge(age);
        System.out.println("Số điện thoại");
        String phoneNumber = Input.inputString();
        StaticUser.user.setPhoneNumber(phoneNumber);
        System.out.println("Địa chỉ: ");
        String address = Input.inputString();
        StaticUser.user.setAddress(address);
    }

    public void showUser() {
        String user = "Họ tên - " + StaticUser.user.getFullName() + ", Tuổi - " + StaticUser.user.getAge() + ", SĐT - " +
                StaticUser.user.getPhoneNumber() + ", Địa chỉ - " + StaticUser.user.getAddress();
        System.out.println(user);
    }

    public void changePassword() {
        System.out.println("Nhập mật khẩu hiện tại:");
        String pass = Input.inputString();
        if (pass.equals(StaticUser.user.getPassWord())) {
            System.out.println("Nhập mật khẩu mới: ");
            String newPassWord = Input.inputString();
            StaticUser.user.setPassWord(newPassWord);
            System.out.println("Đổi mật khẩu thành công!");
        } else System.err.println("Mật khẩu hiện tại không chính xác. Thay đổi mật khẩu thất bại!");
    }

    public void showMotorbike() {
        System.out.println("------Danh sách xe máy-------");
        List<Motorbike> list = motorbikeManager.getAllMotorbike();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (Motorbike mtb :
                    list) {
                System.out.println(mtb);
            }
        }
    }

    public void showCar() {
        System.out.println("------Danh sách Ô tô-------");
        List<Car> list = carManager.getAllCar();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (Car mtb :
                    list) {
                System.out.println(mtb);
            }
        }
    }

    public void showTruck() {
        System.out.println("------Danh sách xe tải-------");
        List<Truck> list = truckManager.getAllTruck();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (Truck mtb :
                    list) {
                System.out.println(mtb);
            }
        }
    }

    public void showContainer() {
        System.out.println("------Danh sách Container-------");
        List<Container> list = containerManager.getAllContainer();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (Container mtb :
                    list) {
                System.out.println(mtb);
            }
        }
    }
}
