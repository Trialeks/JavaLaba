package com.company;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;


public class Main {
    public static ArrayList<String> lineList=new ArrayList<>();
    public static ArrayList<String> numberList=new ArrayList<>();
    public static Map<String,ArrayList> stationMap=new LinkedHashMap<>();

    public static void main(String[] args) throws IOException
    {

        parseFile();
        metroLines metro=new metroLines();
        /////////////////////////////////////////////////////////////////////////////////////////
        try
        {
            Document html = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").get();

            Elements elementsL = html.select("span.js-metro-line.t-metrostation-list-header.t-icon-metroln");

            for (Element elementL: elementsL)
            {
                String line=elementL.text();
                lineList.add(line);

                String str=elementL.attr("abs:data-line");
                String lineNumber=str.substring(str.lastIndexOf('/')+1);
                numberList.add(lineNumber);

            }

           for(int i=0;i<17;i++)
            {
                ArrayList<String> stationList=new ArrayList<>();

                    Elements stationName = html.select("div[data-line="+numberList.get(i)+"]").select("span.name");
                    for(Element st:stationName)
                    {
                        String str=st.toString().split(">")[1].split("<")[0];
                        stationList.add(str);
                    }

                stationMap.put(numberList.get(i),stationList);
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        ////////////////////////////////////////////////////////////////////////////////////////

        for(int i=0;i<numberList.size();i++)
        {
            lines line=new lines();
            line.number=numberList.get(i);
            line.name=lineList.get(i);
            metro.lines.add(line);
        }

        metro.stations=stationMap;
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("data/metro.json");
        json.toJson(metro, writer);
        writer.flush();
        writer.close();
        String jsons= json.toJson(metro);
        System.out.println(jsons);
    }

    public static String parseFile()
    {
        StringBuilder builder=new StringBuilder();
        try{
            List<String> files= Files.readAllLines(Paths.get("data/metro.json"));
            files.forEach(file->builder.append(file).append("\n"));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}

class metroLines
{
    public Map<String,ArrayList> stations=new HashMap<>();
    public List<lines> lines=new ArrayList<>();
}

class lines
{
    public String number;
    public String name;

}
