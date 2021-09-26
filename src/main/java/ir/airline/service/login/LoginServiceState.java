package ir.airline.service.login;

import ir.airline.domain.User;
import ir.airline.service.ExceptionHandling.AccountLoginLimitReachedException;
import ir.airline.service.ExceptionHandling.AccountRevokedException;
import ir.airline.util.LoginServiceContext;

public abstract class LoginServiceState {
    public final User login(LoginServiceContext context, User account, String password) {

        if (account.passwordMatches(password)) {
            if (account.isLoggedIn())
                throw new AccountLoginLimitReachedException();
            if (account.isRevoked())
                throw new AccountRevokedException();
            account.setLoggedIn(true);
            context.setState(new AwaitingFirstLoginAttempt());
        } else
            handleIncorrectPassword(context, account, password);

        return account;
    }

    public abstract void handleIncorrectPassword(LoginServiceContext context,
                                                 User account, String password);
}