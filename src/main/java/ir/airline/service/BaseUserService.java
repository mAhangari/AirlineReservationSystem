package ir.airline.service;

import ir.airline.domain.User;
import ir.baseCRUD.base.service.BaseEntityService;

public interface BaseUserService<E extends User, UT, PT> extends BaseEntityService<E, Long> {

    E findUserByUsername(UT username);

    Boolean existsByUsernameAndPassword(UT username, PT password);

    Boolean existsByUsername(UT username);
}
