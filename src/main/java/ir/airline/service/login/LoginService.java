package ir.airline.service.login;

import ir.airline.domain.User;
import ir.airline.service.ExceptionHandling.AccountNotFoundException;
import ir.airline.service.UserService;
import ir.airline.util.LoginServiceContext;

public class LoginService extends LoginServiceContext {
    private final UserService userService;

    public LoginService(UserService userService) {
        super(new AwaitingFirstLoginAttempt());
        this.userService = userService;
    }

    public User login(String username, String password) {
        User user = userService.findUserByUsername(username);

        if (user == null)
            throw new AccountNotFoundException("Account not exists");

        return getState().login(this, user, password);
    }
}