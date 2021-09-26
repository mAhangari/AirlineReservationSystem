package ir.airline.service.transport;

import ir.airline.domain.Employee;
import ir.airline.domain.FlightSchedule;
import ir.airline.service.menu.BaseMenu;
import ir.airline.util.ApplicationContext;
import lombok.AccessLevel;
import lombok.Getter;
import java.time.*;
import java.util.*;

public class AirTransportService implements TransportService {

    Scanner input = new Scanner(System.in);
    @Getter(AccessLevel.PRIVATE)
    private final Employee employee;

    public AirTransportService(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void travelSchedule() {
        try {
            List<String> list = new ArrayList<>(
                    Arrays.asList("New Travel Schedule", "Exit"));
            BaseMenu.optionMessage(list, true);

            switch (input.nextInt()) {
                case 1 -> {
                    FlightSchedule flightSchedule = new FlightSchedule();
                    BaseMenu.singleSetMessage("insert source place");
                    flightSchedule.setSource(input.next());

                    BaseMenu.singleSetMessage("insert destination place");
                    flightSchedule.setDestination(input.next());

                    var date = "";
                    do{
                        BaseMenu.singleSetMessage("insert travel day (YYYY-MM-DD)");
                        date = input.next();
                    }while(ApplicationContext.chInInformation.checkDate(date));
                    LocalDate localDate = LocalDate.parse(date);

                    BaseMenu.singleSetMessage("insert travel time (HH:MM)");
                    var time = input.next();
                    LocalTime localTime = LocalTime.parse(time);
                    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
                    flightSchedule.setFlyTime(localDateTime);

                    BaseMenu.singleSetMessage("insert flight number");
                    flightSchedule.setFlightNumber(input.next());

                    flightSchedule.setAirline(employee.getAirline());
                    ApplicationContext.flightScheduleServ.save(flightSchedule);

                }
                case 2 -> {
                }

                default -> {
                    BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
                    travelSchedule();
                }
            }
        } catch (InputMismatchException e) {
            input.nextLine();
            BaseMenu.singlePrintMessage(BaseMenu.WRONG_NUMBER);
            travelSchedule();
        }
    }
}
