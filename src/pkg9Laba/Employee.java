
package pkg9Laba;
import java.util.Date;
import java.util.GregorianCalendar;
public class Employee 
{
    String name;
    String surname;
    public Date birthday;
    public String home;
    public String telephone;
    public int oklad;
    public int year;
   
    public Employee(String name, String surname, int year, int month,
            int day, String home,String telephone,int oklad)
    {
        this.name=name;
        this.surname=surname;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        birthday = calendar.getTime();
        this.home=home;
        this.telephone=telephone;
        this.oklad=oklad;
        this.year=year;
    }
    public String getName ()
    {
        return name;
    }
    public String getSurname ()
    {
        return surname;
    }
     public Date getBirthday ()
    {
        return birthday;
    }
     public String getHome ()
    {
        return home;
    }
     public String getTelephone ()
    {
        return telephone;
    }
     public int getOklad ()
    {
        return oklad;
    }
      public int getYear ()
    {
        return year;
    }
         @Override
    public String toString() 
    {
             return 
                     "Employee{" +
                "name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Birthday=" + birthday +
                ", Home=" + home +
                ", Telephone=" + telephone +
                ", Oklad=" + oklad +
                '}';
    }

    
}

