
package praktika7;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practika7_3 {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("������� ����� ��������: ");
        String number = scan.nextLine();
        Vector  n= new Vector(0);
      
        for (int i = 0; i < number.length(); i++) 
        {
           char c=number.charAt(i);
            if ('0'<=c&&c<='9') 
            {    
                n.add(c);
            }
        }
        
//        if (n.size() != 10 && n.size() != 11) 
//        {
//            System.err.println("����������� ������ �����!");
//        }
        if(n.size()==11||n.size()==10)
        {
        Pattern numberPattern = Pattern.compile("\\+?[78]?[\\s\\-]?\\(?(\\d{3})\\)?[\\s\\-]?(\\d{3})[\\s\\-]?(\\d{2})[\\s\\-]?(\\d{2})");
        Matcher matcher = numberPattern.matcher(number);
        if (matcher.find()) 
        {
            System.out.println("���������� ������ ������: +7 ("+n.get(1)+n.get(2)+n.get(3)+") "+n.get(4)+n.get(5)+n.get(6)+"-"+n.get(7)+n.get(8)+"-"+n.get(9)+n.get(10));
        } 
        else System.out.println("����������� ������ �����!");
        }
        else 
        {
            System.out.println("����������� ������ �����!");
        }  
        
    }
    }

