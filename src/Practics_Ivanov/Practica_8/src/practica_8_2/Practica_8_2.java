
package practica_8_2;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Practica_8_2 {
    static TreeSet <String> mail = new TreeSet<>();
    
    public String comand1( String str)
    {
        String mas[]=str.split(" ");
        
                return mas[0];
    }
    
     public String comand2( String str)
    {
        String mas[]=str.split(" ");
        
                return mas[1];
    }
     
    public boolean proverka(String str)
    {
        Pattern mailPattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher matcher = mailPattern.matcher(str);
        return matcher.find();
    }
    
    public void ADD(String str)
    {
        if(proverka(str))
        {
            System.out.println("Адрес введен правильно и успешно добавлен"); 
            mail.add(str);                 
        }
        else
        {
            System.out.println("Не корректный ввод");
        }
        
    }
    
    
    public static void main(String[] args) {        
        Practica_8_2 d=new Practica_8_2();   
        Scanner scan=new Scanner(System.in);
        for(;;)
        {
            System.out.println("Введите команду: ");
            String str = scan.nextLine();
            switch(d.comand1(str))
            {
                case "ADD":
                {
                    d.ADD(d.comand2(str));                    
                }
                break;
                case "LIST":
                {
                    System.out.println(mail);
                }
                break;
                case "EXIT":
                {
                    System.out.println("Программа завершилась");
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Такая команда отсутствует");
                }
                break;
            }
        }
    }
}
