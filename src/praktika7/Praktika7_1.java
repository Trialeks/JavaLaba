
package praktika7;

import java.util.*; 

public class Praktika7_1 {
   
    public static void main(String[] args) {

     String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
     List<Character> chars = new ArrayList<>();
     for (char ch : text.toCharArray()) {
             chars.add(ch);
        }
     
     Vector  v = new  Vector(0);
     Vector  m = new  Vector(0);
////////////////////////////////////////////////////
    for (int i = 0; i < chars.size(); i++)
        {   
         if(chars.get(i)!=',')
            {              
               if((48<=chars.get(i))&&(chars.get(i)<=57))
               {  
                   int k=(int) chars.get(i)-48;
                   v.add(k);                    
               }  
              
            }
          else
            {                       
             break;
            }        
        }
    ////////////////////////////////////////////
  int c=0;
  while(c<2)
  {
    while(chars.get(0)!=',')
    {
        chars.remove(0);
       
    }
    chars.remove(0);
  c++;
    }    
   //////////////////////////////////////////////
   
   for (int i = 0; i < chars.size(); i++)
        {   
             
         if(chars.get(i)!=',')
            {              
               if((48<=chars.get(i))&&(chars.get(i)<=57))
               {  
                   int k=(int) chars.get(i)-48;
                   m.add(k);
                                     
               }  
              
            }
          else
            {
               
             System.out.println(m.size()); 
             break;
            }        
        }
///////////////////////////////////////////     
    double dohod=0;
    int step2;
    int step1;
    for(int i=0;i<v.size();i++)
    {
        step1=(int) v.get(i);
        dohod+=step1*(Math.pow(10,v.size()-1));
    } 
    for(int j=0;j<m.size();j++)
    {
        step2=(int) m.get(j);
        dohod+=step2*(Math.pow(10,m.size()-1));
    }
    
    System.out.println("Заработок Васи и Маши: "+dohod); 
     
}
}
