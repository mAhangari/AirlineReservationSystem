package ir.airline.repository;

import ir.airline.domain.User;
import ir.baseCRUD.base.repository.BaseEntityRepository;

public interface BaseUserRepository<E extends User, UT, PT> extends BaseEntityRepository<E, Long> {

    E findUserByUsername(UT username);

    Boolean existsByUsernameAndPassword(UT username, PT password);

    Boolean existsByUsername(UT username);
}
