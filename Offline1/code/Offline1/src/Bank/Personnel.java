package Bank;

import Employees.*;

public class Personnel {
    public Employee appoint(String name,EmployeeType type)
    {
        switch (type) {
            case Cashier:
                return new Cashier(name);
            case Officer:
                return new Officer(name);
            case ManagingDirector:
                return new ManagingDirector(name);
            default:
                return null;
        }
    }
}
