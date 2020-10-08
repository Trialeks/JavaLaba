
package pkg9Laba;

import java.util.Scanner;
import java.util.Random;

public class Main 
{
    public static void main(String[] args) 
    {
        Company company=new Company();
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        System.out.println("Введите имя, фамилию, место жительства и номер телефона сотрудника: ");
    for (int i = 0; i < 2; i++) 
    {
        String name=scanner.nextLine();
        String surname=scanner.nextLine();
        int year=random.nextInt(19)+1982;
        int month=random.nextInt(12);
        int day=random.nextInt(28);
        String home=scanner.nextLine();
        String telephone=scanner.nextLine();
        int oklad=random.nextInt(40000)+30000;
            Employee employee= new Employee(
                    name,
                    surname,
                    year,
                    month,
                    day,
                    home,
                    telephone,
                    oklad
                    );
            company.hair(employee);
            System.out.println(employee.toString());
        }
        System.out.println("count= "+company.getEmployee());
    
    
    company.provName(
        new HanlderName ()
        {
           @Override
           public void handleEmployee(Employee employee)
           {
               System.out.println("Name: "+employee.getName()
                       +" Number: "+employee.getTelephone());
                
           }
        }
            
        );
    

company.provYear((Employee employee)->{System.out.println(
        "Name: "+employee.getName()+
        " Surnmae"+employee.getSurname());
        });
    
}
}
