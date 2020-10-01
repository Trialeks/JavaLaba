
package pkg7_8laba;

public class Manager implements EmployeePosition
{
  
   private Company company;
   private int dohod;
    public Manager(Company company){
        dohod = (int)(Math.random() * 25000) + 115000;
        this.company=company;
        }
   
    public String getJobTitle()
    {
      return "Manager" ;
    }
    public double calcSalary(double baseSalary)
    {
       return baseSalary + 0.05*dohod;
    }
     public int getDohod()
    {
        return dohod;
    }   
}
