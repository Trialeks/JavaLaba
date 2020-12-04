package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        String srcFolder = "images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        int kolvo=Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер в процессорe: "+ kolvo);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }
            int middle=files.length /kolvo;

            File[][] fail = new File[kolvo][];
            Thread[] potok=new Thread[kolvo];
            for(int i=0;i<kolvo;i++)
            {
                if(i<(kolvo-1))
                {
                    fail[i]=new File[middle];
                }
                else
                {
                    fail[i]=new File[files.length-middle*i];
                }
                System.arraycopy(files, middle*i,fail[i],0, fail[i].length);
                potok[i]=new ImageResize(fail[i],dstFolder,start);
                potok[i].start();
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
