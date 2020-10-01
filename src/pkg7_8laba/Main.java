
package pkg7_8laba;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) 
    {
        Company company=new Company();
        for(int  i=0;i<180;i++)
        {
            Employee employee=new Employee("Name","Surname",12000,new Operator(company));
            company.hair(employee);
        }
         for(int  i=0;i<80;i++)
        {
            Employee employee=new Employee("Name","Surname",20000,new Manager(company));
            company.hair(employee);
        }
         
         ArrayList<Employee> topManager = new ArrayList<Employee>();
         
         for(int  i=0;i<10;i++)
        {
            Employee employee=new Employee("Name","Surname",50000,new TopManager(company));
            topManager.add(employee);
        }
         company.hairAll(topManager);
         
        List<Employee> topSalary=company.getTopSalaryStaff(10);
        for(Employee obj: topSalary)
        {
            System.out.printf("%d Руб.\n",(int)obj.calcSalary()); 
        }
        
        List<Employee> lowerSalary=company.getLowestSalaryStaff(30);
        for(Employee obj: lowerSalary)
        {
            System.out.printf("%d Руб.\n",(int)obj.calcSalary()); 
        }
        
        System.out.println(company.getSize()+" -Размер до удаления");
        
        int len=company.getSize()/2;
        for(int i=0;i<len;i++)
        {
        int index=(int)(Math.random()*company.getSize());
        
        company.fire(index);
        }
        
        System.out.println(company.getSize()+" -Размер после удаления");
        
         topSalary=company.getTopSalaryStaff(10);
        for(Employee obj: topSalary)
        {
            System.out.printf("%d руб.\n",(int)obj.calcSalary()); 
        }
        
         lowerSalary=company.getLowestSalaryStaff(30);
        for(Employee obj: lowerSalary)
        {
            System.out.printf("%d руб.\n",(int)obj.calcSalary()); 
        }
    }
    
}
