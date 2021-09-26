package ir.airline.repository;

import ir.airline.domain.FlightSchedule;
import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;

import javax.persistence.EntityManagerFactory;

public class FlightScheduleRepositoryImpl extends BaseEntityRepositoryImpl<FlightSchedule, Long>
        implements FlightScheduleRepository {

    public FlightScheduleRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<FlightSchedule> getEntityClass() {
        return null;
    }
}
