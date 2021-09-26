package ir.airline.domain;

import ir.airline.domain.enumeration.WorkPlace;
import ir.baseCRUD.domain.enumeration.UserType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Employee extends User {

    private static final String WORK_PLACE = "work_place";

    @Column(name = WORK_PLACE)
    @Setter(AccessLevel.PRIVATE)
    @Enumerated(EnumType.STRING)
    private WorkPlace workPlace;

    public Employee(String username, String password, String firstName, String lastName,
                    String nationalCode, UserType userType, WorkPlace workPlace) {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        super.setNationalCode(nationalCode);
        setUserType(userType);
        setWorkPlace(workPlace);
    }

    @Override
    public String toString() {
        return "Employee{" +
                '}';
    }
}
