package ir.airline.domain;

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
public class Customer extends User {

	private static final String NATIONAL_CODE = "national_code";

	@Column(name = NATIONAL_CODE, nullable = false, unique = true)
	private String nationalCode;

	public Customer(String username, String password, String firstName,
			String lastName) {
		super.setUsername(username);
		super.setPassword(password);
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}
	
	@Override
	public String toString() {
		return  "id='" + getId() + "' " +
                "firstName= '" + getFirstName() + "' " +
                "lastName= '" + getLastName() + "' " +
                "username= '" + getUsername() + "' " +
                "birthday= '" + getBirthDate() + "' ";
	}
}
