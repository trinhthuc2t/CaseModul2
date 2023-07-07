package View.user;

import Model.File.Input;
import Model.Management.VehicleManeger;
import Model.Management.user.UserManager;
import Model.Management.vehicle.*;
import Model.Regex.UserRegex;
import Model.User.User;
import Model.User.StaticUser;
import View.Customer.MenuCustomer;
import View.admin.MenuAdm;


public class MenuUser {
    UserRegex userRegex = new UserRegex();
    private UserManager userManager = new UserManager();
    private VehicleManeger vehicleManeger = new VehicleManeger();
    private ContainerManager containerManager = new ContainerManager();
    private CarManager carManager = new CarManager();
    private MotorbikeManager motorbikeManager = new MotorbikeManager();
    private TruckManager truckManager = new TruckManager();
    private VehicleUserManager vehicleUserManager = new VehicleUserManager();
    private MenuAdm menuAdm = new MenuAdm(userManager, motorbikeManager, carManager, truckManager, containerManager, vehicleManeger,vehicleUserManager);
    private MenuCustomer menuCustomer = new MenuCustomer(userManager, motorbikeManager, carManager, truckManager, containerManager, vehicleManeger,vehicleUserManager);

    public void showLoginMenu() {
        String menu = "-------Trang chủ-------\n" +
                "1. Đăng nhập\n" +
                "2. Đăng ký";
        int choice;
        do {
            System.out.println(menu);
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    registerUser();
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }


    public void registerUser() {
        System.out.println("Đăng ký tài khoản mới");
        String userName;
        while (true) {
            System.out.println("Nhập tên tài khoản: ");
            userName = userRegex.checkUserPass();
            if (userManager.findIndexByUser(userName) != -1) {
                System.err.println("ID đã tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }
        System.out.println("Mật khẩu: ");
        String passWord = userRegex.checkUserPass();
        System.out.println("Họ và tên:");
        String fullName = userRegex.checkName();
        String id;
        while (true) {
            System.out.println("CMND: ");
            id = userRegex.checkId();
            if (userManager.findIndexById(id) != -1) {
                System.err.println("ID đã tồn tại. Vui lòng nhập lại ID.");
            } else break;
        }
        int age;
        while (true) {
            System.out.println("Tuổi:");
            age = Input.inputInteger();
            if (age <= 18) {
                System.err.println("Bạn chưa đủ 18 tuổi!");
            } else break;
        }
        System.out.println("Số điện thoại:");
        String phoneNumber = userRegex.checkPhone();
        System.out.println("Địa chi: ");
        String address = Input.inputString();
        User user = new User(fullName, id, age, phoneNumber, address, userName, passWord);
        userManager.add(user);
        System.out.println("Đăng ký tài khoản thành công");
    }


    public void loginUser() {
        System.out.println("Tên tài khoản:");
        String userName = Input.inputString();
        System.out.println("Mật khẩu");
        String passWord = Input.inputString();
        int index = userManager.findIndexByUser(userName);
        if (userName.equals("admin") && passWord.equals("123456")) {
            menuAdm.showMenuAdm();
        } else if (index != -1) {
            String pass = userManager.getAllUser().get(index).getPassWord();
            if (passWord.equals(pass)) {
                System.out.println("Đăng nhập thành công");
                StaticUser.user = userManager.getAllUser().get(index);
                menuCustomer.showMenuCustomer();
            } else {
                System.err.println("Mật khẩu không chính xác");
            }
        } else {
            System.err.println("Tài khoản không tồn tại");
        }
    }

}
