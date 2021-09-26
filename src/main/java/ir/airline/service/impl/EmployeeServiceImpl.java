package ir.airline.service.impl;

import ir.airline.domain.Employee;
import ir.airline.domain.User;
import ir.airline.domain.enumeration.WorkPlace;
import ir.airline.repository.BaseUserRepository;
import ir.airline.service.EmployeeService;
import ir.airline.service.menu.BaseMenu;
import ir.airline.util.ApplicationContext;
import ir.baseCRUD.domain.enumeration.UserType;
import java.util.*;

public class EmployeeServiceImpl extends UserServiceImpl implements EmployeeService {

    Scanner input = new Scanner(System.in);

    public EmployeeServiceImpl(BaseUserRepository<User, String, String> repository) {
        super(repository);
    }

    @Override
    public void signUp() {
        try {
            var username = "";
            var password = "";

            BaseMenu.singleSetMessage("Insert First Name");
            var firstName = input.next();

            BaseMenu.singleSetMessage("Insert Last Name");
            var lastName = input.next();

            do {
                BaseMenu.singlePrintMessage("Username must have 3-15 character and must has one of these character: ([a-z0-9_-])");
                BaseMenu.singleSetMessage("Insert Username");
                username = input.next();

            } while (ApplicationContext.chInInformation.checkUsername(username));

            do {
                BaseMenu.singlePrintMessage("Password must hase 8 or more character!!");
                BaseMenu.singleSetMessage("Insert Password");
                password = input.next();

            } while (ApplicationContext.chInInformation.checkPassword(password));

            BaseMenu.singleSetMessage("Insert national code");
            var nationalCode = input.next();

            UserType userType = UserType.Employee;

            List<String> list1 = new ArrayList<>(
                    Arrays.asList("Employee", "Boss"));
            BaseMenu.optionMessageWithTitle(list1, "choose access level", true);
            switch (input.nextInt()) {
                case 1 -> {
                }
                case 2 -> userType = UserType.Boss;

                default -> {
                    BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                    signUp();
                }
            }

            WorkPlace workPlace = WorkPlace.AIRLINE;

            List<String> list2 = new ArrayList<>(
                    Arrays.asList("Airline", "Road Logistic", "Sea Logistic"));
            BaseMenu.optionMessageWithTitle(list2, "choose work place", true);
            switch (input.nextInt()) {
                case 1 -> {
                }
                case 2 -> workPlace = WorkPlace.ROAD_LOGISTIC;

                case 3 -> workPlace = WorkPlace.SEA_LOGISTIC;

                default -> {
                    BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                    signUp();
                }
            }

            Employee employee = new Employee(username, password, firstName, lastName, nationalCode, userType, workPlace);
            save(employee);
            BaseMenu.singlePrintMessage("Congratulations! Your Registration was Successful!!!");

        } catch (InputMismatchException e) {
            input.nextLine();
            BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
            signUp();
        }
    }
}
