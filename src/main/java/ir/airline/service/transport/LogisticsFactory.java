package ir.airline.service.transport;

import ir.airline.domain.Employee;
import ir.airline.domain.enumeration.WorkPlace;

public class LogisticsFactory {

    public TransportService createTransferSchedule(Employee employee) {
        if (employee.getWorkPlace().equals(WorkPlace.AIRLINE))
            return new AirTransportService(employee);

        return null;
    }
}
