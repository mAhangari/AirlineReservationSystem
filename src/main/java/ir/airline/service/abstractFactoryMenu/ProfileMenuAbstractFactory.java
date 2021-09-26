package ir.airline.service.abstractFactoryMenu;

import ir.airline.domain.Customer;
import ir.airline.domain.Employee;

public interface ProfileMenuAbstractFactory {

    ProfileMenu createBossProfileMenu(Employee employee);

    ProfileMenu createSimpleEmployeeProfileMenu(Employee employee);

    ProfileMenu crateCustomerProfileMenu(Customer customer);

}
