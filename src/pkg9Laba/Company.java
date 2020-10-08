
package pkg9Laba;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Company  
{
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
    
    public int getEmployee()
    {
        int count=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите оклад:");
        int oklads=scanner.nextInt();
    for(int i=0; i<employees.size();i++)
    {
        OkladHendler oklad=new OkladHendler(oklads);
        if(oklad.handleEmployee(employees.get(i))==true)
        {
            count++;
        }
    }
    return count;
}
    
     public void provName(HanlderName  handlerName)
{
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите имя: ");
        String names=scanner.nextLine();
    for(int i=0;i<employees.size();i++)
    { 
        if(employees.get(i).getName().equals(names))
            {
                handlerName.handleEmployee(employees.get(i)); 
            }
    }
}
     
     public void provYear(HanlderName  handlerName)
{
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите год рождения: ");
        int years=scanner.nextInt();
    for(int i=0;i<employees.size();i++)
    { 
        if(employees.get(i).getYear()==years)
            {
                handlerName.handleEmployee(employees.get(i)); 
            }
    }
}
}


