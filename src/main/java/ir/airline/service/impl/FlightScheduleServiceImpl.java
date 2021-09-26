package ir.airline.service.impl;

import ir.airline.domain.FlightSchedule;
import ir.airline.repository.FlightScheduleRepository;
import ir.airline.service.FlightScheduleService;
import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;

public class FlightScheduleServiceImpl extends BaseEntityServiceImpl<FlightSchedule, Long, FlightScheduleRepository>
                        implements FlightScheduleService {

    public FlightScheduleServiceImpl(FlightScheduleRepository repository) {
        super(repository);
    }
}
