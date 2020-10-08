package pkg9Laba;

import java.util.Scanner;

public class OkladHendler implements EmployeeHandler {
    private int oklad;
    public OkladHendler(int oklad)
    {
        this.oklad=oklad;
    }
     @Override
     public boolean handleEmployee(Employee employee)
     {
         return employee.getOklad()>oklad;
         
     }
}
