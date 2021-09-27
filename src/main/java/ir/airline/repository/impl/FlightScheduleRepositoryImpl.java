package ir.airline.repository.impl;

import ir.airline.domain.FlightSchedule;
import ir.airline.repository.FlightScheduleRepository;
import ir.baseCRUD.base.repository.impl.BaseEntityRepositoryImpl;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class FlightScheduleRepositoryImpl extends BaseEntityRepositoryImpl<FlightSchedule, Long>
        implements FlightScheduleRepository {

    public FlightScheduleRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<FlightSchedule> getEntityClass() {
        return null;
    }

    @Override
    public List<FlightSchedule> findAllBySourceAndDestination(String source, String destination) {
        return em.createQuery(
                "FROM FlightSchedule f " +
                        "WHERE f.source =: source " +
                        "AND f.destination =: destination",
                FlightSchedule.class)
                .setParameter("source", source)
                .setParameter("destination", destination).getResultList();
    }
}
