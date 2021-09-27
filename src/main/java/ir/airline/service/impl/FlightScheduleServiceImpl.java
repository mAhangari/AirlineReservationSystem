package ir.airline.service.impl;

import ir.airline.domain.FlightSchedule;
import ir.airline.repository.FlightScheduleRepository;
import ir.airline.service.FlightScheduleService;
import ir.baseCRUD.base.service.impl.BaseEntityServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class FlightScheduleServiceImpl extends BaseEntityServiceImpl<FlightSchedule, Long, FlightScheduleRepository>
                        implements FlightScheduleService {

    public FlightScheduleServiceImpl(FlightScheduleRepository repository) {
        super(repository);
    }

    @Override
    public List<FlightSchedule> findAllBySourceAndDestination(String source, String destination) {
        EntityManager em = repository.getEntityManager();
        try {
            return repository.findAllBySourceAndDestination(source, destination);
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
