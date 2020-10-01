
package pkg7_8laba;

public class TopManager implements EmployeePosition 
{
    private Company company;
    private int dohod;
    public TopManager(Company company)
    {
        this.company=company;
        dohod=(int)(Math.random()*250000)+500000;
    }
    
    public String getJobTitle()
    {
      return "TopManager" ;
    }
    public double calcSalary(double baseSalary)
    {
        
        if(company.getIncome()>=10000000)
        {
        return baseSalary + 1.5*dohod;
        }
        else  return baseSalary;
    }
    public int getDohod()
    {
        return dohod;
    }   
}
