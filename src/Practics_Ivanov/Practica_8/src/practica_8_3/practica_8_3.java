
package practica_8_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class practica_8_3 {
    static HashMap<String,String> map=new HashMap<>();
    public boolean proverka(String str)
    {
        Pattern namePattern = Pattern.compile("^[A-Za-z]+");
        Matcher matcher = namePattern.matcher(str);
        return matcher.find();
    }
    
    public boolean numberProv(String str)
    {
        Vector  n= new Vector(0);
      
        for (int i = 0; i < str.length(); i++) 
        {
           char c=str.charAt(i);
            if ('0'<=c&&c<='9') 
            {    
                n.add(c);
            }
        }
 
        if(n.size()==11||n.size()==10)
        {
        Pattern numberPattern = Pattern.compile("\\+?[78]?[\\s\\-]?\\(?(\\d{3})\\)?[\\s\\-]?(\\d{3})[\\s\\-]?(\\d{2})[\\s\\-]?(\\d{2})");
        Matcher matcher = numberPattern.matcher(str);
        return matcher.find();      
        }
        else return false;
    }
    
    public void LIST(String str)
    {
        map.entrySet().stream();
    }
    
    public static void main(String[] args) {
        
        practica_8_3 d=new practica_8_3();
        Scanner scan=new Scanner(System.in);
        
        for(;;)
        {
             System.out.println("������� �������: ");
             String str = scan.nextLine();
             
            switch(str)
            {
                case "LIST":
                {
                    map.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey()).forEach(System.out::println);
                }
                break;
                case "EXIT":
                {
                    System.out.println("����������");
                    System.exit(0);
                }
                break;
                default:
                {
                if(d.proverka(str))
                {                    
                if(map.containsKey(str))
                {
                    System.out.println(str + " " + map.get(str));
                }
                else
                {
                    System.out.println("������� ����� ��������: ");
                    String number=scan.nextLine();
                    if(d.numberProv(str))
                    {
                    System.out.println("����� �������� ������ �����");     
                    map.putIfAbsent(str,number );
                    }
                    else
                    {
                        System.out.println("����� �������� ������ �� �����");
                    }
            
                }
            }
                else
                {
                    if(d.numberProv(str)&&map.containsValue(str))
                    {
                        System.out.println("����� �������� ������ �����"); 
                        for(Map.Entry<String, String> pair: map.entrySet()){
                        if(str.equals(pair.getValue())){
                         System.out.println(pair.getKey() + " " + str);
                        }
                        }
                    }
                    else if(d.numberProv(str))
                {
                System.out.println("������� ���");
                map.putIfAbsent(scan.nextLine(), str);
                }
                    else  System.out.println("����� �������� ������ �� �����"); 
        }
                }
                break;
            }

        
    }
}}

