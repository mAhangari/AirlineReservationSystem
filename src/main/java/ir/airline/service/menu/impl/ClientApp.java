package ir.airline.service.menu.impl;

import ir.airline.domain.Customer;
import ir.airline.domain.Employee;
import ir.airline.domain.User;
import ir.airline.service.menu.ProfileMenu;
import ir.airline.service.menu.ProfileMenuAbstractFactory;
import ir.baseCRUD.domain.enumeration.UserType;

public class ClientApp {

    private static ProfileMenu profileMenu;

    public ClientApp(ProfileMenuAbstractFactory abstractFactory, User user) {
        if (user.getUserType().equals(UserType.Customer))
            profileMenu = abstractFactory.crateCustomerProfileMenu((Customer) user);
        else if (user.getUserType().equals(UserType.Employee))
            profileMenu = abstractFactory.createSimpleEmployeeProfileMenu((Employee) user);
        else profileMenu = abstractFactory.createBossProfileMenu((Employee) user);
    }

    public ProfileMenu getProfileMenu() {

        return profileMenu;
    }

}
