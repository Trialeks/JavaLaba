
package practica_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Practica_10 {
 
public static void log(String fullpath, String text)
{
    String str=text+"\n";
    try(FileOutputStream file= new FileOutputStream(fullpath+"/log.txt", true);) 
    {
    byte[] buffer=str.getBytes();
    file.write(buffer, 0, buffer.length);
    } 
    catch (IOException ex) 
    {
        System.out.println(ex.getMessage());
    }
    
}
 ///////////////////////////////////////////////////////////////////////////////   
 public static String pr1() 
{
    Scanner scan=new Scanner(System.in);
    System.out.println("Введите путь до папки, в которой должен храниться log.txt: ");
    String path = scan.nextLine();
    String[] nextpath=path.split("/");
    String fullpath=nextpath[0];
    for(int i=1;i<nextpath.length; i++)
    {
       fullpath+="/"+nextpath[i];
        File file = new File(fullpath);
         if(!file.isDirectory()) 
         {
            boolean created=file.mkdir();
            if(created)
            {
            System.out.println("Дериктория создана");
            }
            else
            {
                System.out.println("ERROR");
            }
         }
    }    
    return path;
}
 ///////////////////////////////////////////////////////////////////////////////
 public static double pr2(String path)
    {
        File file=new File(path);
        double size=(double)file.length();
        if(file.isDirectory())
        {
            File[] files =file.listFiles();
            for(File item:files)
            {
                //System.out.println(item.getPath());
                size += pr2(item.getPath());
            }
        }
        return size;
    }
    
    public static void getSize(String pathlog, String path2)
    {
        DecimalFormat df=new DecimalFormat("#.#");
        if(pr2(path2)>=1000.0)
        {
            if(pr2(path2)>=1_000_000.0)
            {
             log(pathlog,"Размер папки "+ path2+" cоставляет "+  df.format(pr2(path2)/(1024*1024)) +" Mб");   //Double.toString(pr2(path2)/(1024*1024))
            }
            else
            {
             log(pathlog,"Размер папки "+ path2+" cоставляет "+ df.format(pr2(path2)/1024)+" Kб");
            }          
        }
        else
        {
          log(pathlog,"Размер папки "+ path2+" cоставляет "+ df.format(pr2(path2))+ " б");   
        }
        
    }
    
  ///////////////////////////////////////////////////////////////////////////////  
 public void pr3(String path1,String path2, String pathlog)
 {
    String path=path1+"\\"+path2.substring(path2.lastIndexOf('\\')+1);
    File file = new File(path2);
    File file1 = new File(path);
    if(file.isDirectory()) 
    {   
        file1.mkdir();
        File[] files = file.listFiles();
        for (File item : files) 
        {
            pr3(path, item.getPath(),pathlog);
        }
    }
    else
    {
        StringBuffer buffer=read2(path2);
        write(path,buffer);
    }
    log(pathlog,path2+ " - успешно скопированно");
 }
 ///////////////////////////////////////////////////////////////////////////////
public static void write(String path,StringBuffer buffer) {
       try {
           PrintWriter writer = new PrintWriter(path);
           writer.write(buffer.toString());
           writer.flush();
           writer.close();

       } catch (Exception ex)
       {
           ex.printStackTrace();
       }
   }
 
public static StringBuffer read2(String path) {
       StringBuffer buffer = new StringBuffer();

       try {
           BufferedReader reader = new BufferedReader(new FileReader(path));

           while (true) {
               String line = reader.readLine();

               if(line == null)
                   break;

               buffer.append(line + "\n");
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }

      return buffer;
   }
 
    
 
    public static void main(String[] args) {
       
        Practica_10 f=new Practica_10();
        Scanner str=new Scanner(System.in);   
        System.out.println("------Отработка первой программы-----");
        String pathlog=f.pr1();
        System.out.println("Введите строчку: ");
        f.log(pathlog,str.nextLine());
        System.out.println("------Отработка второй программы-----");
        System.out.println("Введите путь до папки, размер которой нужно посчитать: ");
        f.getSize(pathlog,str.nextLine());
        System.out.println("------Отработка третьей программы-----");
        System.out.println("Введите путь до папки, в которую копируете, и путь папки, которую копируете:");
        f.pr3(str.nextLine(), str.nextLine(),pathlog);
    }    
}

