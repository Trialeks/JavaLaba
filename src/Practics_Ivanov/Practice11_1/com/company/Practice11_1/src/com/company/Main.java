package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void parseTable()
    {

        try
        {
            HashMap<String,Double> company=new HashMap<>();
            List<String> table= Files.readAllLines(Paths.get("data/movementList.txt"));
            double p=0.0;
            double r=0.0;
            for(int i=1;i<=119;i++)
            {
                String[] line = table.get(i).split("\t");

                    String path=line[5].replaceAll("( ){3,}", "   ");
                    path=path.replace('\\', '/');
                    String[] nextpath=path.split("   ");
                    String firm=nextpath[1].substring(nextpath[1].indexOf('/')+1);
                    double prihod = Double.parseDouble(line[6].replace(',', '.'));
                    double rashod = Double.parseDouble(line[7].replace(',', '.'));
                    p+=prihod;
                    r+=rashod;
                    if(!company.containsKey(firm))
                        {
                            company.put(firm,rashod);
                        }
                    else
                    {
                        double d=company.get(firm)+rashod;
                        company.put(firm,d);
                    }
            }
            System.out.println("Сумма расходов: " + r );
            System.out.println("Сумма доходов: " + p );
            System.out.println("Суммы расходов по организациям: ");
            for(String k:company.keySet())
            {
                System.out.println(k + ": " + company.get(k));
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        parseTable();
    }
}
