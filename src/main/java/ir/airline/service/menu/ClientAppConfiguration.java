package ir.airline.service.menu;

import ir.airline.domain.Employee;
import ir.airline.domain.User;
import ir.airline.domain.enumeration.WorkPlace;
import ir.airline.service.menu.impl.airline.AirlineProfileMenuFactory;
import ir.airline.service.menu.impl.ClientApp;
import ir.baseCRUD.domain.enumeration.UserType;
import java.util.*;

public class ClientAppConfiguration {

    static Scanner input = new Scanner(System.in);
    public static ProfileMenuAbstractFactory abstractFactory;
    public static ClientApp clientApp;

    public static ClientApp configureApp(User user) {

        String logisticName = "";

        if (user.getUserType().equals(UserType.Customer)) {
            try {
                List<String> list = new ArrayList<>(Arrays.asList("Airline", "Road", "Sea"));
                BaseMenu.optionMessageWithTitle(list, "select transport way", true);

                switch (input.nextInt()) {
                    case 1 -> logisticName = "airline";
                    case 2 -> logisticName = "road";
                    case 3 -> logisticName = "sea";
                    default -> {
                        BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                        configureApp(user);
                    }
                }
            } catch (InputMismatchException e) {
                input.nextLine();
                BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                configureApp(user);
            }
        } else {
            Employee employee = (Employee) user;
            if (employee.getWorkPlace().equals(WorkPlace.AIRLINE)){
                logisticName = "airline";
            }else if (employee.getWorkPlace().equals(WorkPlace.ROAD_LOGISTIC)){
                logisticName = "rad";
            }else logisticName = "sea";
        }

        if (logisticName.equalsIgnoreCase("airline")) {
            abstractFactory = new AirlineProfileMenuFactory();
            clientApp = new ClientApp(abstractFactory, user);
        } else if (logisticName.equalsIgnoreCase("road")) {
//            abstractFactory = new RoadLogisticProfileMenu();
//            clientApp = new ClientApp(abstractFactory);
        } else {
            //abstractFactory = new SeaLogisticProfileMenu();
            //clientApp = new ClientApp(abstractFactory);
        }

        return clientApp;

    }
}
