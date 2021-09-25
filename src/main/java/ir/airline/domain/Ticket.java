package ir.airline.domain;

import ir.baseCRUD.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity<Long> {

    private static final String FLIGHT_SCHEDULE = "flight_schedule";
    private static final String CUSTOMER_ID = "customer_id";

    @OneToOne
    @JoinColumn(name = CUSTOMER_ID)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = FLIGHT_SCHEDULE)
    private FlightSchedule flightSchedule;
}
