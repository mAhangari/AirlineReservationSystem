package ir.airline.domain;

import ir.baseCRUD.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Airplane extends BaseEntity<Long> {

    private static final String TAIL_NAME = "tail_number";
    private static final String NUM_OF_SEATS = "number_of_seats";

    @Column(name = TAIL_NAME)
    private String tailNumber;

    @Column(nullable = false)
    private String model;

    @Column(name = NUM_OF_SEATS)
    private int numberOfSeats;

    private int age;
}
