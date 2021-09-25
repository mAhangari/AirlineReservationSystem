package ir.airline.service.login;

import ir.airline.domain.User;
import ir.airline.util.LoginServiceContext;

public class AwaitingFirstLoginAttempt extends LoginServiceState {
    @Override
    public void handleIncorrectPassword(LoginServiceContext context, User account,
                                        String password) {
        context.setState(new AfterFirstFailedLoginAttempt(account.getUsername()));
    }
}