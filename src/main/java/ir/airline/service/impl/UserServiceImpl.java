package ir.airline.service.impl;

import ir.airline.domain.User;
import ir.airline.repository.BaseUserRepository;
import ir.airline.service.UserService;

public class UserServiceImpl extends BaseUserServiceImpl<User, String, String> implements UserService {

    public UserServiceImpl(BaseUserRepository<User, String, String> repository) {
        super(repository);
    }

}
