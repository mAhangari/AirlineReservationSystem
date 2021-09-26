package ir.airline.service.abstractFactoryMenu.impl.airline;

import ir.airline.domain.Customer;
import ir.airline.domain.Employee;
import ir.airline.service.abstractFactoryMenu.ProfileMenu;
import ir.airline.service.abstractFactoryMenu.ProfileMenuAbstractFactory;

public class AirlineProfileMenuFactory implements ProfileMenuAbstractFactory {

    @Override
    public ProfileMenu createBossProfileMenu(Employee employee) {
        return new AirlineBossProfileMenu(employee);
    }

    @Override
    public ProfileMenu createSimpleEmployeeProfileMenu(Employee employee) {
        return new AirlineSimpleEmployeeProfileMenu(employee);
    }

    @Override
    public ProfileMenu crateCustomerProfileMenu(Customer customer) {
        return new AirlineCustomerProfileMenu(customer);
    }
}
