
package praktika7;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practica7_2 
{
    public static void main(String[] args) { 
        Scanner text=new Scanner(System.in);
        String str=text.nextLine(); 
        System.out.println(str); 
        int count=0;
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) 
        {
             chars.add(ch);
        }
        
        boolean error = false;
        for(int i = 0; i < chars.size() && !error; i++){
            if(!(1040<=chars.get(i)&&chars.get(i)<=1071||
                   1072<=chars.get(i)&&chars.get(i)<=1103||
                   chars.get(i)==45|| chars.get(i)==' ')){
                error = true;
                
            }
            if(chars.get(i)==' ')
            {
                count++;
            }
            if(count>2)
            {
                error=true;
            }
        }
        if(count==0)
            {
                error=true;
            }
        if(!error)
        {
            if(count==1)
            {
               String mas[]=str.split(" ");
                System.out.println("Фамилия: "+mas[0]);
                System.out.println("Имя: " +mas[1]);
               
            }
            if(count==2)
            {
                String mas[]=str.split(" ");
                System.out.println("Фамилия: "+mas[0]);
                System.out.println("Имя: " +mas[1]);
                System.out.println("Отчества: "+ mas[2]);
            }

        }
        else
        {
            System.out.println("Введенная строка не является ФИО");
        }
        
           
    }
    
}
