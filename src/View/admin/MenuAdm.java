package View.admin;

import Model.File.Input;
import Model.Management.VehicleManeger;
import Model.Management.user.UserManager;
import Model.Management.vehicle.*;
import Model.Regex.AdmRegex;
import Model.User.User;
import Model.Vehicle.*;

import java.util.List;

public class MenuAdm {
    private UserManager userManager;
    private VehicleManeger vehicleManeger;
    private ContainerManager containerManager;
    private CarManager carManager;
    private MotorbikeManager motorbikeManager;
    private TruckManager truckManager;
    private VehicleUserManager vehicleUserManager;

    AdmRegex admRegex = new AdmRegex();

    public MenuAdm(UserManager userManager, MotorbikeManager motorbikeManager, CarManager carManager, TruckManager truckManager, ContainerManager containerManager, VehicleManeger vehicleManeger, VehicleUserManager vehicleUserManager) {
        this.userManager = userManager;
        this.motorbikeManager = motorbikeManager;
        this.carManager = carManager;
        this.truckManager = truckManager;
        this.containerManager = containerManager;
        this.vehicleManeger = vehicleManeger;
        this.vehicleUserManager = vehicleUserManager;
    }

    public void showMenuAdm() {
        String menu = "-------Quản Lý-------\n" +
                "1. Quản lý xe\n" +
                "2. Tài khoản\n" +
                "3. Khách hàng\n" +
                "4. Thanh toán\n" +
                "0. Đăng xuất";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAdmVehicle();
                    break;
                case 2:
                    userMng();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void userMng() {
        String menu = "-------User-------\n" +
                "1. Danh sách user\n" +
                "2. Delete user\n" +
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
                    deleteUser();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void deleteUser() {
        System.out.println("Nhập user: ");
        String user = Input.inputString();
        userManager.delete(user);
    }

    public void showMenuAdmVehicle() {
        String menu = "-------Quản Lý xe-------\n" +
                "1. Thêm xe mới\n" +
                "2. Sửa\n" +
                "3. Xóa\n" +
                "4. Tìm kiếm\n" +
                "5. Danh sách xe\n" +
                "0. Quay lại";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAddVehicle();
                    break;
                case 2:
                    showMenuEditVehicle();
                    break;
                case 3:
                    showMenuDeleteVehicle();
                    break;
                case 4:
                    showMenuSearch();
                    break;
                case 5:
                    showMenuDisplayVehicle();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void showMenuAddVehicle() {
        String menu = "-------Danh sách xe-------\n" +
                "1. Xe máy\n" +
                "2. Xe ô tô\n" +
                "3. Xe tải\n" +
                "4. Xe container\n" +
                "0. Quay lại";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAddMotorbike();
                    break;
                case 2:
                    showMenuAddCar();
                    break;
                case 3:
                    showMenuAddTruck();
                    break;
                case 4:
                    showMenuAddContainer();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void showMenuEditVehicle() {
        String id;
        while (true) {
            System.out.println("Nhập ID xe: ");
            id = admRegex.checkID();
            if (id.equals("exit")) {
                return;
            } else if (vehicleManeger.findIndexById(id) == -1) {
                System.err.println("ID không tồn tại. Vui lòng nhập lại ID hoặc \"exit\" để thoát.");
            } else break;
        }
        System.out.println("Nhâp lại thông tin.");
        System.out.println("Loại xe: ");
        String typeOfVehicle = Input.inputString();
        System.out.println("Hãng: ");
        String manufacture = Input.inputString();
        System.out.println("Năm sx: ");
        String dateOfManufacture = admRegex.checkDate();
        System.out.println("Biển số xe:");
        String licensePalte = admRegex.checkLicensePlate();
        System.out.println("Color:");
        String color = Input.inputString();
        Vehicle vehicle = new Vehicle(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
        vehicleManeger.edit(id, vehicle);
        if (typeOfVehicle.equals("Xe máy")) {
            Motorbike motorbike = new Motorbike(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
            motorbikeManager.edit(id, motorbike);
        }
        if (typeOfVehicle.equals("Ô tô")) {
            Car car = new Car("Ô tô", id, manufacture, dateOfManufacture, licensePalte, color);
            carManager.edit(id, car);
        }
        if (typeOfVehicle.equals("Xe tải")) {
            Truck truck = new Truck(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
            truckManager.edit(id, truck);
        }
        if (typeOfVehicle.equals("Container")) {
            Container container = new Container(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
            containerManager.edit(id, container);
        }

    }

    public void showMenuDeleteVehicle() {
        String id;
        while (true) {
            System.out.println("Nhập ID xe: ");
            id = Input.inputString();
            if (id.equals("exit")) {
                return;
            } else if (vehicleManeger.findIndexById(id) == -1) {
                System.err.println("ID không tồn tại. Vui lòng nhập lại ID hoặc \"exit\" để thoát.");
            } else break;
        }
        if (id.contains("XM")) motorbikeManager.delete(id);
        if (id.contains("OTO")) carManager.delete(id);
        if (id.contains("TR")) truckManager.delete(id);
        if (id.contains("CTN")) containerManager.delete(id);
        vehicleManeger.delete(id);
    }

    public void showMenuSearch() {
        System.out.println("Nhập biển số xe: ");
        String licensePalte = Input.inputString();
        List<Vehicle> a = vehicleManeger.findByLicensePlate(licensePalte);
        System.out.println("Kết quả: \n" + a);
    }

    public void showMenuAddMotorbike() {
        String id;
        while (true) {
            System.out.println("ID: ");
            id = admRegex.checkID();
            if (motorbikeManager.findIndexById(id) != -1) {
                System.err.println("ID đã tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }

        System.out.println("Hãng: ");
        String manufacture = Input.inputString();
        System.out.println("Năm sx: ");
        String dateOfManufacture = admRegex.checkDate();
        System.out.println("Biển số xe:");
        String licensePalte = admRegex.checkLicensePlate();
        System.out.println("Color:");
        String color = Input.inputString();
        String typeOfVehicle = "Xe máy";
        Motorbike motorbike = new Motorbike(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
        motorbikeManager.add(new Motorbike(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color));
        vehicleManeger.add(motorbike);
        System.out.println("Đã thêm " + motorbike);
    }

    public void showMenuAddCar() {
        String id;
        while (true) {
            System.out.println("ID: ");
            id = admRegex.checkID();
            if (carManager.findIndexById(id) != -1) {
                System.err.println("ID đã tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }
        System.out.println("Hãng: ");
        String manufacture = Input.inputString();
        System.out.println("Năm sx: ");
        String dateOfManufacture = admRegex.checkDate();
        System.out.println("Biển số xe:");
        String licensePalte = admRegex.checkLicensePlate();
        System.out.println("Color:");
        String color = Input.inputString();
        String typeOfVehicle = "Ô tô";
        Car car = new Car(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
        carManager.add(new Car(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color));

        vehicleManeger.add(car);
        System.out.println("Đã thêm " + car);

    }

    public void showMenuAddTruck() {
        String id;
        while (true) {
            System.out.println("ID: ");
            id = admRegex.checkID();
            if (truckManager.findIndexById(id) != -1) {
                System.err.println("ID đã tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }
        System.out.println("Hãng: ");
        String manufacture = Input.inputString();
        System.out.println("Năm sx: ");
        String dateOfManufacture = admRegex.checkDate();
        System.out.println("Biển số xe:");
        String licensePalte = admRegex.checkLicensePlate();
        System.out.println("Color:");
        String color = Input.inputString();

        String typeOfVehicle = "Xe tải";
        Truck truck = new Truck(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
        truckManager.add(new Truck(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color));
        vehicleManeger.add(truck);
        System.out.println("Đã thêm " + truck);
    }

    public void showMenuAddContainer() {
        String id;
        while (true) {
            System.out.println("ID: ");
            id = admRegex.checkID();
            if (containerManager.findIndexById(id) != -1) {
                System.err.println("ID đã tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }
        System.out.println("Hãng: ");
        String manufacture = Input.inputString();
        System.out.println("Năm sx: ");
        String dateOfManufacture = admRegex.checkDate();
        System.out.println("Biển số xe:");
        String licensePalte = admRegex.checkLicensePlate();
        System.out.println("Color:");
        String color = Input.inputString();
        String typeOfVehicle = "Container";
        Container container = new Container(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color);
        containerManager.add(new Container(typeOfVehicle, id, manufacture, dateOfManufacture, licensePalte, color));
        vehicleManeger.add(container);
        System.out.println("Đã thêm " + container);
    }

    public void showMenuDisplayVehicle() {
        String menu = "-------Danh sách xe-------\n" +
                "1. Xe máy\n" +
                "2. Xe ô tô\n" +
                "3. Xe tải\n" +
                "4. Xe container\n" +
                "0. Quay lại";

        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMotorbike();
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
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
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

    public void showUser() {
        System.out.println("------Danh sách User-------");
        List<User> list = userManager.getAllUser();
        if (list.size() == 0) System.out.println("Danh sách trống");
        else {
            for (User mtb :
                    list) {
                System.out.println(mtb);
            }
        }
    }
}
