
package pkg7_8laba;
import java.util.ArrayList;
import java.util.List;
public class Company 
{
private int dohod;   
private ArrayList<Employee> employees;
public Company()
{
employees = new ArrayList<Employee>();

}

public void hair(Employee m)
{
    employees.add(m);
}
public void hairAll(ArrayList<Employee> objs)
{
  employees.addAll(objs);
}

public void fire(int index)
{
   
   if(index>-1&&index<employees.size())
   {
    employees.remove(index);
    }
}
public int getSize()
{
    return employees.size();
}


public int getIncome()
{
    dohod=0;
    for(Employee person:employees)
    {
      dohod+=person.pozition.getDohod();
    }
    return dohod;
}

public List<Employee> getTopSalaryStaff(int count)
{
    if(count<0&&count>employees.size())
    {
        return null;
    }
    for(int i=0;i<employees.size();i++)
    {
        for(int j=0;j<employees.size()-1-i;j++)
        {
            if(employees.get(j).calcSalary()<employees.get(j+1).calcSalary())
            {
                Employee t;
                t=employees.get(j);
                employees.set(j,employees.get(j+1));
                employees.set(j+1,t);
            }
                
        }
    }
    
    List<Employee> topSalary = new ArrayList<Employee>();
    for(int i=0;i<count;i++)
    {
        topSalary.add(employees.get(i));
    }
    return topSalary;
}

public List<Employee> getLowestSalaryStaff(int count)
{
    if(count<0&&count>employees.size())
    {
        return null;
    }
    for(int i=0;i<employees.size();i++)
    {
        for(int j=0;j<employees.size()-1-i;j++)
        {
            if(employees.get(j).calcSalary()>employees.get(j+1).calcSalary())
            {
                Employee t;
                t=employees.get(j);
                employees.set(j,employees.get(j+1));
                employees.set(j+1,t);
            }
                
        }
    }
    
    List<Employee> lowerSalary = new ArrayList<Employee>();
    for(int i=0;i<count;i++)
    {
        lowerSalary.add(employees.get(i));
    }
    return lowerSalary;
}
}


