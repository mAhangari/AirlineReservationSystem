package ir.airline.repository.impl;

import ir.airline.repository.EmployeeRepository;
import javax.persistence.EntityManagerFactory;

public class EmployeeRepositoryImpl extends UserRepositoryImpl  implements EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

}
