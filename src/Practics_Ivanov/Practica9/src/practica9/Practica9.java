
package practica9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


public class Practica9 {
     static ArrayList<String> numberCar=new ArrayList<String>();
    
     public void generatorOfNumber()
     {
         String[] mas=new String[]{"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
         for(int X=0;X<mas.length;X++)
         {
             for(int N=0;N<10;N++)
             {
                 for(int Y=0;Y<mas.length;Y++)
                 {
                     for(int Z=0;Z<mas.length;Z++)
                     {
                         for(int R=1;R<=199;R++)
                         {
                             String number=" ";
                             if(mas[X]!=mas[Y]&&mas[Y]!=mas[Z]&&mas[X]!=mas[Z])
                             {
                             if(R<10)
                             {
                                 number=mas[X]+N+N+N+mas[Y]+mas[Z]+"0"+R;
                             }
                             else
                             {
                                 number=mas[X]+N+N+N+mas[Y]+mas[Z]+R;
                             }
                             numberCar.add(number);
                             }
                         }   
                     }
                 }
             }
         }
     }
    
    public static void main(String[] args) throws InterruptedException {
        Practica9 n=new Practica9();
        n.generatorOfNumber();
        Scanner scan=new Scanner(System.in);
        System.out.println("Количество сгенерированных номеров: " + numberCar.size());
        System.out.println("Введите номер, который нужно найти, чтобы завершить программу введите EXIT: " );
        for(;;)
        {
            String count=scan.next();
            if("EXIT".equals(count))
            {
              System.out.println("Работа завершена" );
              System.exit(0);
            }
            else
            {                
            long start = System.nanoTime();
            if(numberCar.contains(count))
            {
                System.out.print("Поиск перебором: номер найден");           
            }
            else 
            
            System.out.print("Поиск перебором: номер не найден");
            long finish = System.nanoTime();
            long elapsed = finish - start;
            System.out.println(", поиск занял  " + elapsed+" нс");
        
            Collections.sort(numberCar);
            boolean c=false;
            start = System.nanoTime();
            if(Collections.binarySearch(numberCar, count) >= 0 )
            {
                c=true;
                System.out.print("Бинарный поиск: номер найден");
            }
            if(c==false)
            {
                System.out.print("Бинарный поиск: номер не найден");
            }
            finish = System.nanoTime();
            elapsed = finish - start;
            System.out.println(", поиск занял  " + elapsed+" нс");
         
            HashSet<String> carSet=new HashSet<>(numberCar);
            start = System.nanoTime();
            if(carSet.contains(count))
            {
                System.out.print("Поиск в HashSet: номер найден"); 
            }
            else System.out.print("Поиск в HashSet: номер не найден"); 

            finish = System.nanoTime();
            elapsed = finish - start;
            System.out.println(", поиск занял  " + elapsed+" нс");
         
            TreeSet<String> tree=new TreeSet<>(numberCar);
            start = System.nanoTime();
            if(tree.contains(count))
            {
                System.out.print("Поиск в TreeSet: номер найден"); 
            }
            else System.out.print("Поиск в TreeSet: номер не найден"); 

            finish = System.nanoTime();
            elapsed = finish - start;
            System.out.println(", поиск занял  " + elapsed+" нс");
            }
        }               
    }    
}
