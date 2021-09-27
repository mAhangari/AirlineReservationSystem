package ir.airline.service;

import ir.airline.domain.FlightSchedule;
import ir.baseCRUD.base.service.BaseEntityService;
import java.util.List;

public interface FlightScheduleService extends BaseEntityService<FlightSchedule, Long> {

    List<FlightSchedule> findAllBySourceAndDestination(String source, String destination);
}
