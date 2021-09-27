package ir.airline.repository;

import ir.airline.domain.FlightSchedule;
import ir.baseCRUD.base.repository.BaseEntityRepository;
import java.util.List;

public interface FlightScheduleRepository extends BaseEntityRepository<FlightSchedule, Long> {

    List<FlightSchedule> findAllBySourceAndDestination(String source, String destination);
}
