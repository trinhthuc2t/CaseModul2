package View;

import View.user.MenuUser;

public class MainMenu {
    private MenuUser userMenu = new MenuUser();
    public void showMainMenu() {
        userMenu.showLoginMenu();
    }
}
