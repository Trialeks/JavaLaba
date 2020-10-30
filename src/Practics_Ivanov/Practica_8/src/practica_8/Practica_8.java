
package practica_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Practica_8 {

   static ArrayList<String> todoList=new ArrayList<String>();
    public void LIST()
     {
        
        for(int i=0; i<todoList.size();i++) 
        {
            System.out.println((i) + " - "+todoList.get(i));
            
        }
     }
    
    public int space(String str)
    {
         char[] arr = new char[str.length()];
         for (int i = 0; i < str.length(); i++)
            arr[i] = str.charAt(i);
         int spaces = 0;
         for (int i = 0; i < arr.length; i++)
            if (arr[i] == ' ') spaces++;
         return spaces;
         
    }
    
    
    public String comand1( String str)
    {
        String mas[]=str.split(" ");
        
                return mas[0];
    }
            
     public String comand2( String str)
     {
         String mas[]=str.split(" ");
         String text=" ";
         char c=mas[1].charAt(0);
         if('0'<=c&&c<='9')
                {
                    return mas[1];
                }
                else
                {
                    for(int i=1;i<mas.length;i++)
                    {
                    text = text+ mas[i] + " ";
                    }
                    return text; 
                }
         
     }
     
    public String comand3( String str)
     {
         String mas[]=str.split(" ");
         String text=" ";
          for(int i=2;i<mas.length;i++)
                    {
                    text = text+ mas[i] + " ";
                    }
                    return text; 
     }
    
    public void ADD(int n, String str)
    {
        if(n<=todoList.size()&&n>=0)
        {
           todoList.add(n, str);
           System.out.println("Дело успешно добавлено в ваш список!");
        }
        else
        {
            System.out.println("Превышен размер данных!");
        }
    }
    
    public void DELETE(int n)
    {
       if(n<=todoList.size())
       {
        todoList.remove(n);
        System.out.println("Дело успешно удалено!");
       }
       else
       {System.out.println("Такого дела и так не существует");}
    }
    
    public void EDIT(int n, String str)
    {
        if(n<=todoList.size())
       {
        todoList.set(n, str);
        System.out.println("Дело успешно изменено!");
       }
       else
       {System.out.println("Такого дела нет");}
    }
    
        public static void main(String[] args) {
        Practica_8 d=new Practica_8();   
        Scanner scan=new Scanner(System.in);
        for(;;)
        {
        System.out.println("Введите команду: ");
        String str = scan.nextLine();
        if(d.space(str)==0)
        { switch(d.comand1(str))
            {
               case "EXIT":
               {    
                   System.out.println("Список закончен!");
                    System.exit(0);
               } 
               break;
               case "LIST":
               {
                   d.LIST();
               }
               break;
            }
            
        }
        if(d.space(str)==1)
        {            
            switch(d.comand1(str))
            {
                case "EXIT":
               {    
                   System.out.println("Список закончен!");
                    System.exit(0);
               } 
               case "ADD":
               {     
                    todoList.add(d.comand2(str));
                    System.out.println(d.comand2(str));
                    System.out.println("Дело успешно добавлено в ваш список!");
               } 
               break;
               case "DELETE":
               {
                   d.DELETE(Integer.parseInt(d.comand2(str)));
               }
               break;
            }
        }
        if(d.space(str)>=2)
        {
            switch(d.comand1(str)){
                case "EXIT":
               {    
                   System.out.println("Список закончен!");
                    System.exit(0);
               } 
                case "ADD":
            {
                char c=d.comand2(str).charAt(0);
                if('0'<=c&&c<='9')
                {
                    d.ADD(Integer.parseInt(d.comand2(str)), d.comand3(str));  
                }
                else  todoList.add(d.comand2(str));
            }
            break;
             case "EDIT":
            {
            d.EDIT(Integer.parseInt(d.comand2(str)), d.comand3(str));
            }
            break;
            default:
                {
                    System.out.println("Такая команда отсутствует");
                }
                break;
            }
            
        }
        }
        
   
    }
    
}
