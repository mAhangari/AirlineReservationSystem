package ir.airline.service.menu.impl.airline;

import ir.airline.domain.Employee;
import ir.airline.service.menu.BaseMenu;
import ir.airline.service.menu.ProfileMenu;
import ir.airline.util.ApplicationContext;
import lombok.AccessLevel;
import lombok.Getter;
import java.util.*;

public class AirlineBossProfileMenu implements ProfileMenu {

    Scanner input = new Scanner(System.in);

    @Getter(AccessLevel.PRIVATE)
    private final Employee employee;

    public AirlineBossProfileMenu(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void dashboard() {
        try {
            List<String> list = new ArrayList<>(
                    Arrays.asList("Crate new Employee", "Log Out"));
            BaseMenu.optionMessage(list, true);

            switch (input.nextInt()) {
                case 1 -> {
                    ApplicationContext.employeeServ.signUp();
                    dashboard();
                }
                case 2 -> {
                }
                default -> {
                    BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                    dashboard();
                }
            }
        } catch (InputMismatchException e) {
            input.nextLine();
            BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
            dashboard();
        }
    }
}
