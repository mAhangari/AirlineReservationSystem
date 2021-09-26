package ir.airline.service.menu;

import ir.airline.domain.User;
import ir.airline.service.menu.impl.ClientApp;
import ir.airline.util.ApplicationContext;
import java.util.*;

public class Menu extends BaseMenu {

    Scanner input = new Scanner(System.in);

    public void showMenu() {
        try {
            List<String> list = new ArrayList<>(Arrays.asList("Login User", "Sign Up", "Exit"));
            optionMessage(list, true);

            switch (input.nextInt()) {
                case 1 -> {
                    BaseMenu.singleSetMessage("Insert your Username");
                    var username = input.next();

                    BaseMenu.singleSetMessage("Insert your Password");
                    var password = input.next();

                    User account = ApplicationContext.loginServ.login(username, password);

                    if (account.isLoggedIn()) {
                        ApplicationContext.userServ.save(account);
                        BaseMenu.singlePrintMessage(BaseMenu.WELCOME);

                        ClientApp app = ClientAppConfiguration.configureApp(account);
                        ProfileMenu profile = app.getProfileMenu();

                        profile.dashboard();
                        account.setLoggedIn(false);
                        ApplicationContext.userServ.save(account);
                    }
                    showMenu();
                }
                case 2 -> {
                    ApplicationContext.customerServ.signUp();
                    showMenu();
                }

                case 3 -> {
                }
                default -> {
                    singlePrintMessage(WRONG_NUMBER);
                    showMenu();
                }
            }
        } catch (InputMismatchException e) {
            input.nextLine();
            singlePrintMessage(WRONG_NUMBER);
            showMenu();
        }
    }
}
