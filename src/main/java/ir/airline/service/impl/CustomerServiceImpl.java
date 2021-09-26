package ir.airline.service.impl;

import ir.airline.domain.Customer;
import ir.airline.domain.User;
import ir.airline.repository.BaseUserRepository;
import ir.airline.service.CustomerService;
import ir.airline.service.menu.BaseMenu;
import ir.airline.util.ApplicationContext;
import java.util.Scanner;

public class CustomerServiceImpl extends UserServiceImpl implements CustomerService {

    Scanner input = new Scanner(System.in);

    public CustomerServiceImpl(BaseUserRepository<User, String, String> repository) {
        super(repository);
    }

    @Override
    public void signUp() {
        var username = "";
        var password = "";

        BaseMenu.singleSetMessage("Insert First Name");
        var firstName = input.next();

        BaseMenu.singleSetMessage("Insert Last Name");
        var lastName = input.next();

        do{
            BaseMenu.singlePrintMessage("Username must have 3-15 character and must has one of these character: ([a-z0-9_-])");
            BaseMenu.singleSetMessage("Insert your Username");
            username = input.next();

        }while(ApplicationContext.chInInformation.checkUsername(username));

        do{
            BaseMenu.singlePrintMessage("Password must hase 8 or more character!!");
            BaseMenu.singleSetMessage("Insert your Password");
            password = input.next();

        }while(ApplicationContext.chInInformation.checkPassword(password));

        BaseMenu.singleSetMessage("Insert your national code");
        var nationalCode = input.next();

        Customer customer = new Customer(username, password, firstName, lastName, nationalCode);
        save(customer);
        BaseMenu.singlePrintMessage("Congratulations! Your Registration was Successful!!!");
    }
}
