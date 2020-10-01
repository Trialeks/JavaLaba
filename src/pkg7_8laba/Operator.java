
package pkg7_8laba;

public class Operator implements EmployeePosition
{
    private int dohod;
     private Company company;
      public Operator(Company company)
    {
        this.company=company;
        dohod=(int)(Math.random()* 25000) + 50000;
    }
    public String getJobTitle()
    {
      return "Operator" ;
    }
   
    public double calcSalary(double baseSalary)
    {   
        return baseSalary;   
    }
    
     public int getDohod()
    {
        return dohod;
    }   
}
