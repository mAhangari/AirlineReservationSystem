package ir.airline.domain;

import ir.baseCRUD.domain.enumeration.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer extends User {

	public Customer(String username, String password, String firstName,
			String lastName, String nationalCode) {
		super.setUsername(username);
		super.setPassword(password);
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setNationalCode(nationalCode);
		super.setUserType(UserType.Customer);
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
