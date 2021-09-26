package ir.airline.repository.impl;

import ir.airline.repository.CustomerRepository;
import javax.persistence.EntityManagerFactory;

public class CustomerRepositoryImpl extends UserRepositoryImpl implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
