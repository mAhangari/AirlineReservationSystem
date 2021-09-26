package ir.airline.repository.impl;

import ir.airline.domain.User;
import ir.airline.repository.UserRepository;
import javax.persistence.EntityManagerFactory;

public class UserRepositoryImpl extends BaseUserRepositoryImpl<User, String, String>
        implements UserRepository {

    public UserRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
