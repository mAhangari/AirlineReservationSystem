package ir.airline.util;

import ir.airline.repository.impl.CustomerRepositoryImpl;
import ir.airline.repository.impl.EmployeeRepositoryImpl;
import ir.airline.repository.impl.UserRepositoryImpl;
import ir.airline.service.abstractFactoryMenu.Menu;
import ir.airline.service.impl.CustomerServiceImpl;
import ir.airline.service.impl.EmployeeServiceImpl;
import ir.airline.service.impl.UserServiceImpl;
import ir.airline.service.login.LoginService;

public class ApplicationContext {

    public static final UserRepositoryImpl userRepo;
    public static final UserServiceImpl userServ;

    public static final CustomerRepositoryImpl customerRepo;
    public static final CustomerServiceImpl customerServ;

    public static final EmployeeRepositoryImpl employeeRepo;
    public static final EmployeeServiceImpl employeeServ;

    public static final LoginService loginServ;

    public static final Menu menu;
    public static final CheckInputInformation chInInformation;

    private ApplicationContext(){
    }

    static {
        userRepo = new UserRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        userServ = new UserServiceImpl(userRepo);

        customerRepo = new CustomerRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        customerServ = new CustomerServiceImpl(customerRepo);

        employeeRepo = new EmployeeRepositoryImpl(HibernateUtil.getEntityMangerFactory());
        employeeServ = new EmployeeServiceImpl(employeeRepo);

        loginServ = new LoginService(userServ);

        menu = new Menu();
        chInInformation = new CheckInputInformation();

    }
}

