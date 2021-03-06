package ir.airline.service.login;

import ir.airline.domain.User;
import ir.airline.util.ApplicationContext;
import ir.airline.util.LoginServiceContext;

public class AfterSecondFailedLoginAttempt extends LoginServiceState {
    private final String previousAccountId;

    public AfterSecondFailedLoginAttempt(String previousAccountId) {
        this.previousAccountId = previousAccountId;
    }

    @Override
    public void handleIncorrectPassword(LoginServiceContext context, User account,
                                        String password) {
        if (previousAccountId.equals(account.getUsername())) {
            account.setRevoked(true);
            context.setState(new AwaitingFirstLoginAttempt());
        } else {
            context.setState(new AfterFirstFailedLoginAttempt(account.getUsername()));
        }
    }
}