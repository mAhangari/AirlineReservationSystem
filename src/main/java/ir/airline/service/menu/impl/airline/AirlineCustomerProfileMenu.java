package ir.airline.service.menu.impl.airline;

import ir.airline.domain.Customer;
import ir.airline.domain.FlightSchedule;
import ir.airline.service.menu.BaseMenu;
import ir.airline.service.menu.ProfileMenu;
import ir.airline.util.ApplicationContext;
import lombok.AccessLevel;
import lombok.Getter;
import java.util.*;
import java.util.stream.Collectors;

public class AirlineCustomerProfileMenu implements ProfileMenu {

    Scanner input = new Scanner(System.in);

    @Getter(AccessLevel.PRIVATE)
    private final Customer customer;

    public AirlineCustomerProfileMenu(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void dashboard() {
        try {
            List<String> list = new ArrayList<>(
                    Arrays.asList("By Ticket", "Ticket Refund", "Log Out"));
            BaseMenu.optionMessage(list, true);

            switch (input.nextInt()) {
                case 1 -> {
                    BaseMenu.singleSetMessage("Insert source place");
                    var sourcePlace = input.next();

                    BaseMenu.singleSetMessage("Insert destination place");
                    var destinationPlace = input.next();

                    List<FlightSchedule> flightSchedules =
                            ApplicationContext.flightScheduleServ.findAllBySourceAndDestination(
                                            sourcePlace, destinationPlace);

                    showFlightSchedule(flightSchedules);
                    sortFlightSchedule(flightSchedules);

                    dashboard();
                }
                case 2 -> dashboard();
                case 3 -> {
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

    private void sortFlightSchedule(List<FlightSchedule> flightSchedules) {
        try {
            BaseMenu.optionMessage(Arrays.asList(
                            "Sort by price", "Sort by Airline",
                            "Sort by source place", "Sort by destination place", "Exit")
                    , true);

            switch (input.nextInt()) {
                case 1 -> {
                    Comparator<FlightSchedule> comparator = Comparator.comparing(a -> Integer.valueOf(a.getPrice()));
                    compareMethod(flightSchedules, comparator);
                }
                case 2 -> {
                    Comparator<FlightSchedule> comparator = Comparator
                            .comparing(a -> a.getAirline().getAirlineName());
                    compareMethod(flightSchedules, comparator);
                }
                case 3, 4 -> {
                    showFlightSchedule(flightSchedules);
                    sortFlightSchedule(flightSchedules);
                }
                case 5 -> {
                }
                default -> {
                    BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                    dashboard();
                }
            }
        }catch (InputMismatchException e) {
                input.nextLine();
                BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                dashboard();
        }
    }

    private void compareMethod(List<FlightSchedule> flightSchedules, Comparator<FlightSchedule> comparator) {
        List<FlightSchedule> flights = flightSchedules
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        BaseMenu.optionMessage(Arrays.asList("ascending", "descending"), true);
        var option = input.nextInt();
        if (option == 1)
            showFlightSchedule(flights);
        else showFlightSchedule(flights
                .stream().sorted(comparator.reversed()).collect(Collectors.toList()));

        sortFlightSchedule(flightSchedules);
    }

    private void showFlightSchedule(List<FlightSchedule> flightSchedules) {

        BaseMenu.optionMessage(flightSchedules
                .stream()
                .map(FlightSchedule::toString)
                .collect(Collectors.toList()), false);
    }
}
