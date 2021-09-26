package ir.airline.service.menu.impl.airline;

import ir.airline.domain.Employee;
import ir.airline.service.menu.ProfileMenu;
import ir.airline.service.menu.BaseMenu;
import ir.airline.service.transport.LogisticsFactory;
import ir.airline.service.transport.TransportService;
import lombok.AccessLevel;
import lombok.Getter;
import java.util.*;

public class AirlineSimpleEmployeeProfileMenu implements ProfileMenu {

    Scanner input = new Scanner(System.in);

    @Getter(AccessLevel.PRIVATE)
    private final Employee employee;

    public AirlineSimpleEmployeeProfileMenu(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void dashboard() {
        try {
            List<String> list = new ArrayList<>(
                    Arrays.asList("Create new travel schedule", "Log Out"));
            BaseMenu.optionMessage(list, true);

            switch (input.nextInt()) {
                case 1 -> {
                    LogisticsFactory logisticsFactory = new LogisticsFactory();
                    TransportService transportService = logisticsFactory.createTransferSchedule(employee);
                    if (transportService != null)
                        transportService.travelSchedule();
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
