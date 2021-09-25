package ir.airline.domain;

import ir.baseCRUD.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightSchedule extends BaseEntity<Long> {

    private static final String FLIGHT_NUMBER = "flight_number";

    @Column(name = FLIGHT_NUMBER, nullable = false, unique = true)
    private String flightNumber;

    private String destination;

    private String source;

    private LocalDate flyTime;

    @OneToMany(mappedBy = "flightSchedule")
    private Set<Ticket> ticket;
}
