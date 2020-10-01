
package pkg7_8laba;

public class Employee 
{
    String name;
    String surname;
    private int salary;
    public EmployeePosition pozition;
    public Employee (String name, String surname,int salary,EmployeePosition pozition)
    {
        this.name=name;
        this.surname=surname;
        this.salary=salary;
        this.pozition=pozition;
    }
    
    public double calcSalary()
    {
        return pozition.calcSalary(salary);
    }
}
