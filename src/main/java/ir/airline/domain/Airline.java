package ir.airline.domain;

import ir.baseCRUD.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Airline.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Airline extends BaseEntity<Long> {

    public static final String TABLE_NAME = "airline";
    private static final String AIRPLANE_ID = "airplane_id";
    private static final String AIRLINE_ID = "airline_id";
    private static final String AIRLINE_NAME = "airline_name";
    private static final String FLIGHT_SCHEDULE_ID = "flight_schedule_id";

    @Column(name = AIRLINE_NAME, nullable = false, unique = true)
    private String airlineName;

    @OneToMany
    @JoinColumn(name = AIRLINE_ID)
    private Set<Airplane> airplane = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = AIRLINE_ID)
    private Set<Employee> employees = new HashSet<>();

    @OneToMany
    @JoinColumn(name = AIRLINE_ID)
    private Set<FlightSchedule> flightSchedule = new HashSet<>();

}
