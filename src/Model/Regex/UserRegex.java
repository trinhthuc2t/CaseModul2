package Model.Regex;

import Model.File.Input;

public class UserRegex {
    private static final String NAME_REGEX = "^[\\p{L}\\p{M}']+([\\s-][\\p{L}\\p{M}']+)*$";

    private static final String PHONE_REGEX = "\\+84\\.\\d{9}";
    private static final String USERNAME_REGEX = "[a-z0-9]+";
    private static final String ID_REGEX = "[a-zA-Z0-9]+";
    String fullName;

    String phoneNumber;
    String userName;
    String id;


    public String checkName() {

        do {
            fullName = Input.inputString();
            if (fullName.matches(NAME_REGEX)) {
                return fullName;
            } else System.err.println("Nhập đúng định dạng tên!");
        } while (true);
    }
    public String checkUserPass() {
        do {
            userName = Input.inputString();
            if (userName.matches(USERNAME_REGEX)) {
                return userName;
            } else System.err.println("Nhập đúng định dạng user!");
        } while (true);
    }

    public String checkPhone() {
        do {
            phoneNumber = Input.inputString();
            if (phoneNumber.matches(PHONE_REGEX)) {
                return phoneNumber;
            } else System.err.println("Yêu cầu nhập đúng đinh dạng +84.xxxxxxxxx!");
        } while (true);

    }public String checkId() {
        do {
            id = Input.inputString();
            if (id.matches(ID_REGEX)) {
                return id;
            } else System.err.println("Yêu cầu nhập đúng đinh dạng ID!");
        } while (true);
    }
}
